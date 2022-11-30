package com.svaliavchyk.battlesAndAdventures.dl.classes.characters;

import com.svaliavchyk.battlesAndAdventures.dl.Monsters.BaseMonsters;
import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;
import com.svaliavchyk.battlesAndAdventures.dl.Spells.PureMagic.ManaShield;
import com.svaliavchyk.battlesAndAdventures.dl.Spells.PureMagic.ManaShot;
import com.svaliavchyk.battlesAndAdventures.dl.classes.BaseCharacter;
import com.svaliavchyk.battlesAndAdventures.ui.Services.DataService;

import java.util.ArrayList;

public class Magician extends BaseCharacter {

    int[] raisingCharacteristicsPerLevel = {2, 1, 2, 5};

    int[] bonusQuickCast = {1, 1};
    BaseCharacter Caster ;
    ArrayList<int[]> upgradeSpellsCell = new ArrayList<>();
    public Magician(String name) {
        this.setName(name);
        this.setLevel(1);
        this.setRaisingCharacteristicsPerLevel(raisingCharacteristicsPerLevel);
        this.setMaxHealthPoints(4);
        this.setHealthPoint(4);
        this.setMaxManaPoints(8);
        this.setManaPoint(8);
        this.setAttackMagicAmount(3);
        this.setAttackType(AttackType.Magic);
        this.setCharactersClass(CharactersClass.Magiciann);
        this.setStrong(getLevel() * getRaisingCharacteristicsPerLevel()[0]);
        this.setDexterity(getLevel() * getRaisingCharacteristicsPerLevel()[1]);
        this.setIntelligence(getLevel() * getRaisingCharacteristicsPerLevel()[2]);
        this.setWisdom(getLevel() * getRaisingCharacteristicsPerLevel()[3]);
        this.setAttentiveness(7);
        this.setVision(1);
        this.setRangedAttackRange(7);
        this.setAccuracy(2);

        this.setMaxExperience(10 * getLevel());
        this.setExperience(0);

        this.setAttributeUpgradePoints(0);


        fillListApgradeSpell();
    }

    @Override
    public void loseHealth(int amount) {
        if(getMagicShield()>0){
            setMagicShield(getMagicShield() - amount);
            і
            if(getMagicShield() < 0) setMagicShield(0);
        }else {
            setHealthPoint(getHealthPoint() - amount);
        }

    }
    void fillListApgradeSpell(){
        upgradeSpellsCell.add(new int[4]);
    }

    @Override
    public void setIntelligence(int intelligence) {
        super.setIntelligence(intelligence);

        setAttackMagicAmount(getIntelligence());
    }

    @Override
    public void attack() {
        Caster = User.userParty.getPartyMembers()[0];
        attackMagician();
    }

    public void attackMagician() {
        for (BaseMonsters CheckMonster : DataService.globalDungeon.listMonsters) {
            System.out.println("Ворог на відстані " + enemyDetection(CheckMonster) + "метрів. |Статус : " + CheckMonster.getMonsterStatus() + "| ");
        }
        System.out.println("Як бажаєте використати здібності?");
        System.out.println("Ваша мана : " + getManaPoint() + "/" + getMaxManaPoints());
        System.out.println("q) Швидкий каст");
        System.out.println("w) Книга заклинаннь");
        System.out.println("e) Відступити з поля бою");
        switch (DataService.ProcessingEnteredMessages(' ')) {
            case 'q' -> quickCast();
            case 'w' -> BookOfSpells();
            case 'e' -> DataService.globalGuild.dungeonsGoblin();
            default -> {
                System.out.println("Ви вирішили відступити");
                DataService.globalGuild.dungeonsGoblin();
            }
        }

    }

    public void quickCast() {
        System.out.println("|Впишіть формулу швидкого каста заклинання|");
        System.out.println("~~~) Заклинання");
        System.out.println("qwe) Відхилити швидкий каст");
        switch (DataService.ProcessingEnteredMessages("")) {
            case "qwe" -> attackMagician();
            case "q1" -> new ManaShot(Caster, upgradeSpellsCell.get(0), bonusQuickCast);
            case "w1" -> {
                System.out.println("Недостатньо вмінь");
                attackMagician();
            }
            case "e1" -> {
                System.out.println("Недостатньо вмінь ");
                attackMagician();
            }
            case "r1" -> new ManaShield(Caster, upgradeSpellsCell.get(0), bonusQuickCast);
            default -> {
                System.out.println("Заклинання вийшло з під контролю");
                System.out.println("Здоров'я : -1");
                System.out.println("Мана : -1");
                loseMana(1);
                loseHealth(1);
                System.out.println("------------------------------");
                System.out.println("І'мя : " + getName());
                System.out.println("Клас : " + getCharactersClass());
                System.out.println("Здоров'я :" + getHealthPoint() + "/" + getMaxHealthPoints());
                System.out.println("Мана :" + getManaPoint() + "/" + getMaxManaPoints());
                System.out.println("------------------------------");
            }
        }
    }

    public void BookOfSpells() {
        System.out.println("Книга магії");
        System.out.println("a) Повернутись");
        System.out.println("q) Заклинання дальнього бою");
        System.out.println("w) Заклинання ближнього бою");
        System.out.println("e) Заклинання по області");
        System.out.println("r) Заклинання захисту");
        switch (DataService.ProcessingEnteredMessages(' ')) {
            case 'a' -> attackMagician();
            case 'q' -> rangedSpell();
            case 'w' -> meleeSpell();
            case 'e' -> areaSpells();
            case 'r' -> shieldSpell();
            default -> {
                System.out.println("Такої вкладки немає");
                BookOfSpells();
            }
        }

        attackMagician();
    }

    public void rangedSpell(){
        System.out.println("Заклинання дальнього бою");
        System.out.println("Оберіть заклинання яке бажаєте використати");
        System.out.println("q) Повернутись");
        System.out.println("1) Постріл магії");
        switch (DataService.ProcessingEnteredMessages(' ')) {
            case 'q' -> rangedSpell();
            case '1' -> {
                System.out.println("Формула швидкого каста (q1) ");
                new ManaShot(Caster, upgradeSpellsCell.get(0));
            }
            default -> {
                System.out.println("Такого заклинання немає");
                BookOfSpells();
            }
        }
    }
    public void meleeSpell(){
        BookOfSpells();
    }
    public void areaSpells(){
        BookOfSpells();
    }
    public void shieldSpell(){
        System.out.println("Заклинання захисту");
        System.out.println("Оберіть заклинання яке бажаєте використати");
        System.out.println("q) Повернутись");
        System.out.println("1) Щит магії");
        switch (DataService.ProcessingEnteredMessages(' ')) {
            case 'q' -> shieldSpell();
            case '1' -> {
                System.out.println("Формула швидкого каста (r1) ");
                new ManaShield(Caster, upgradeSpellsCell.get(0));
            }
            default -> {
                System.out.println("Такого заклинання немає");
                BookOfSpells();
            }
        }
    }




}
