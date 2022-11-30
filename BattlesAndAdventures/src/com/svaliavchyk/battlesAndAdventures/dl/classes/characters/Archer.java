package com.svaliavchyk.battlesAndAdventures.dl.classes.characters;

import com.svaliavchyk.battlesAndAdventures.dl.Monsters.BaseMonsters;
import com.svaliavchyk.battlesAndAdventures.dl.Monsters.MonsterStatus;
import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;
import com.svaliavchyk.battlesAndAdventures.dl.classes.BaseCharacter;
import com.svaliavchyk.battlesAndAdventures.ui.Services.DataService;

import static java.lang.Integer.parseInt;

public class Archer extends BaseCharacter {

    int[] raisingCharacteristicsPerLevel = {3, 4, 1, 2};

    public Archer(String name) {
        this.setName(name);
        this.setLevel(1);
        this.setRaisingCharacteristicsPerLevel(raisingCharacteristicsPerLevel);
        this.setMaxHealthPoints(6);
        this.setHealthPoint(6);
        this.setMaxManaPoints(2);
        this.setManaPoint(2);
        this.setAttackDistanceAmount(5);
        this.setAttackType(AttackType.Barbed);
        this.setCharactersClass(CharactersClass.Archer);
        this.setStrong(getLevel() * getRaisingCharacteristicsPerLevel()[0]);
        this.setDexterity(getLevel() * getRaisingCharacteristicsPerLevel()[1]);
        this.setIntelligence(getLevel() * getRaisingCharacteristicsPerLevel()[2]);
        this.setWisdom(getLevel() * getRaisingCharacteristicsPerLevel()[3]);
        this.setAttentiveness(10);
        this.setVision(1);
        this.setRangedAttackRange(10);
        this.setAccuracy(2);

        this.setMaxExperience(10 * getLevel());
        this.setExperience(0);

        this.setAttributeUpgradePoints(0);
    }

    @Override
    public void setDexterity(int dexterity) {
        super.setDexterity(dexterity);

        setAttackDistanceAmount(getDexterity());
    }

    @Override
    public void attack() {
        attackArcher();
    }

    public int maxShotPower() {
        if (getRangedAttackRange() % getAccuracy() == 0) return getRangedAttackRange() / getAccuracy();
        else return (getRangedAttackRange() / getAccuracy()) + 1;
    }

    public void attackArcher() {

        for (BaseMonsters CheckMonster : DataService.globalDungeon.listMonsters) {
            System.out.println("Ворог на відстані " + enemyDetection(CheckMonster) + "метрів. |Статус : " + CheckMonster.getMonsterStatus() + "| ");
        }

        System.out.println("Введіть силу пострілу числом від 1 до " + maxShotPower() + ", якщо дальність пострілу дорівнює " + User.userParty.getPartyMembers()[0].getRangedAttackRange());
        System.out.println("№) Атакувати");
        System.out.println("q) Відступити");
        shotAnalysis();

    }

    void shotAnalysis() {
        try {
            int shotStrong = parseInt(DataService.ProcessingEnteredMessages(""));

            boolean hitMessage = false;
            for (BaseMonsters CheckMonsters : DataService.globalDungeon.listMonsters) {

                if (shotStrong > maxShotPower() + 1) {
                    System.out.println("|Стріла перелетіла ворога|");
                    AgrEnemy();
                    hitMessage = true;
                    break;
                } else {
                    int fluctuation = (CheckMonsters.getDistanceToCharacter() - User.userParty.getPartyMembers()[0].getVision()) / 4;

                    int numbRandom;
                    if (fluctuation < 1) {
                        numbRandom = 0;
                    } else {
                        numbRandom = DataService.myRandom(-fluctuation, fluctuation);
                    }

                    int monsterPosition = CheckMonsters.getDistanceToCharacter() + numbRandom;

                    if (getAccuracy() * shotStrong - 1 <= monsterPosition && monsterPosition <= getAccuracy() * shotStrong) {
                        System.out.println("|Ви влучили по ворогу|");
                        CheckMonsters.loseHealth(getAttackDistanceAmount());
                        hitMessage = true;
                        break;
                    }
                }
            }
            if (!hitMessage) System.out.println("|Ви промахнулись|");

        } catch (Exception e) {
            switch (DataService.ProcessingEnteredMessages(' ')) {
                case '№' -> {
                    System.out.println("Введіть силу пострілу числом від 1 до " + maxShotPower() + ", якщо дальність пострілу дорівнює " + User.userParty.getPartyMembers()[0].getRangedAttackRange());
                    try {
                        shotAnalysis();
                    } catch (Exception ex) {
                        System.out.println("Ви не змогли вистрілити, тому вирішили відступити");
                        DataService.globalGuild.dungeonsGoblin();
                    }
                }
                case 'q' -> DataService.globalGuild.dungeonsGoblin();
                default -> System.out.println("Не вдалось вистрілити, стріла зачепилась за лук");
            }

        }
    }
}
