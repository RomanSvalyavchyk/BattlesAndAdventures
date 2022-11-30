package com.svaliavchyk.battlesAndAdventures.dl.classes;

import com.svaliavchyk.battlesAndAdventures.dl.Monsters.BaseMonsters;
import com.svaliavchyk.battlesAndAdventures.dl.Monsters.MonsterStatus;
import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.AttackType;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.CharactersClass;
import com.svaliavchyk.battlesAndAdventures.dl.dungeons.Dungeon;
import com.svaliavchyk.battlesAndAdventures.ui.Services.DataService;

import java.util.Random;

public abstract class BaseCharacter implements BaseClass {
    private String name;
    private int healthPoint;
    private int manaPoint;
    private int level;
    private int attackDistanceAmount;
    private int attackMeleeAmount;
    private int attackMagicAmount;
    private int maxHealthPoints;
    private int maxManaPoints;
    private AttackType attackType;
    private CharactersClass charactersClass;
    private int strong;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int attentiveness;
    private int vision;
    private int attackRange;
    private int rangedAttackRange;
    private int accuracy;
    private int experience;
    private int skillUpgradePoints;
    private int attributeUpgradePoints;
    private int maxExperience;
    private int Gold;
    private int magicShield;
    private int distanceCorrectionNumber = 5;

    public int getMagicShield() {
        return magicShield;
    }

    public void setMagicShield(int magicShield) {
        this.magicShield = magicShield;
    }

    int[] raisingCharacteristicsPerLevel = new int[4];


    public int[] getRaisingCharacteristicsPerLevel() {
        return raisingCharacteristicsPerLevel;
    }

    public void setRaisingCharacteristicsPerLevel(int[] raisingCharacteristicsPerLevel) {
        this.raisingCharacteristicsPerLevel = raisingCharacteristicsPerLevel;
    }

    public int getAttackMagicAmount() {
        return attackMagicAmount;
    }

    public void setAttackMagicAmount(int attackMagicAmount) {
        this.attackMagicAmount = attackMagicAmount;
    }

    public int getAttackMeleeAmount() {
        return attackMeleeAmount;
    }

    public void setAttackMeleeAmount(int attackMeleeAmount) {
        this.attackMeleeAmount = attackMeleeAmount;
    }

    public int getDistanceCorrectionNumber() {
        return distanceCorrectionNumber;
    }

    public void setDistanceCorrectionNumber(int distanceCorrectionNumber) {
        this.distanceCorrectionNumber = distanceCorrectionNumber;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    public int getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(int maxExperience) {
        this.maxExperience = maxExperience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
        if (getExperience() >= getMaxExperience()) {
            levelUp(1);
            this.experience = getExperience() - getMaxExperience();
        }
    }

    public int getSkillUpgradePoints() {
        return skillUpgradePoints;
    }

    public void setSkillUpgradePoints(int skillUpgradePoints) {
        this.skillUpgradePoints = skillUpgradePoints;
    }

    public int getAttributeUpgradePoints() {
        return attributeUpgradePoints;
    }

    public void setAttributeUpgradePoints(int attributeUpgradePoints) {
        this.attributeUpgradePoints = attributeUpgradePoints;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getRangedAttackRange() {
        return rangedAttackRange;
    }

    public void setRangedAttackRange(int rangedAttackRange) {
        this.rangedAttackRange = rangedAttackRange;
    }

    public int getStrong() {
        return strong;
    }

    public void setStrong(int strong) {
        this.strong = strong;

        int previousMaxHealthPoints = getMaxHealthPoints();
        setMaxHealthPoints(getStrong() * 2);
        setHealthPoint(getMaxHealthPoints() * getHealthPoint() / previousMaxHealthPoints);


    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;

        int previousMaxManaPoints = getMaxManaPoints();
        setMaxManaPoints(getWisdom() * 2);
        setManaPoint(getMaxManaPoints() * getManaPoint() / previousMaxManaPoints);
    }

    public int getAttentiveness() {
        return attentiveness;
    }

    public void setAttentiveness(int attentiveness) {
        this.attentiveness = attentiveness;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public CharactersClass getCharactersClass() {
        return charactersClass;
    }

    public void setCharactersClass(CharactersClass charactersClass) {
        this.charactersClass = charactersClass;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        if (healthPoint < 0) healthPoint = 0;
        else if (healthPoint > this.maxHealthPoints) healthPoint = this.maxHealthPoints;
        this.healthPoint = healthPoint;
    }

    public int getManaPoint() {
        return manaPoint;
    }

    public void setManaPoint(int manaPoint) {
        if (manaPoint < 1) {
            manaPoint = 0;
        } else if (manaPoint > this.maxManaPoints) manaPoint = this.maxManaPoints;
        this.manaPoint = manaPoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 0) System.out.println("Рівень гравця понижено!");
        this.level = level;
    }

    public int getAttackDistanceAmount() {
        return attackDistanceAmount;
    }

    public void setAttackDistanceAmount(int attackDistanceAmount) {
        this.attackDistanceAmount = attackDistanceAmount;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getMaxManaPoints() {
        return maxManaPoints;
    }

    public void setMaxManaPoints(int maxManaPoints) {
        this.maxManaPoints = maxManaPoints;
    }

    @Override
    public void attack() {

    }

    @Override
    public void restoreHealth(int amount) {
        setHealthPoint(this.healthPoint + amount);
    }

    @Override
    public void loseHealth(int amount) {
        setHealthPoint(this.healthPoint - amount);

    }

    @Override
    public void restoreMana(int amount) {
        setManaPoint(this.manaPoint + amount);
    }

    @Override
    public void loseMana(int amount) {
        setManaPoint(this.manaPoint - amount);
        if (healthPoint < 1) Death();
    }

    @Override
    public void levelUp(int amount) {
        setLevel(this.level + amount);

        setStrong(getStrong() + getRaisingCharacteristicsPerLevel()[0]);
        setDexterity(getDexterity() + getRaisingCharacteristicsPerLevel()[1]);
        setIntelligence(getIntelligence() + getRaisingCharacteristicsPerLevel()[2]);
        setWisdom(getWisdom() + getRaisingCharacteristicsPerLevel()[3]);
        setAttributeUpgradePoints(getAttributeUpgradePoints() + 1);

        System.out.println("------------------------------");
        System.out.println("|Рівень персонажа піднято. Рівень: " + getLevel() + " |");
        System.out.println("------------------------------");
    }

    @Override
    public void info() {
        System.out.println("--------------------" + '\n'
                + "Ім'я: " + this.name + '\n'
                + "Клас: " + this.charactersClass + '\n'
                + "Рівень: " + this.level + '\n'
                + "Здоров'я: " + this.healthPoint + "/" + this.maxHealthPoints + '\n'
                + "Мана: " + this.manaPoint + "/" + this.maxManaPoints + '\n'
                + "Урон: " + this.attackDistanceAmount);
        System.out.println("--------------------");
    }

    @Override
    public String enemyDetection() {

        BaseCharacter Character = User.userParty.getPartyMembers()[0];
        Random rnd = new Random();
        int Dist = Character.getAttentiveness() - rnd.nextInt(0, Character.getAttentiveness() / distanceCorrectionNumber);
        for (BaseMonsters CheckMonster : DataService.globalDungeon.listMonstersInLocation) {

            if (CheckMonster.getHealthPoint() > 0) {
                CheckMonster.setDistanceToCharacter(Dist);
                break;
            }

        }
        DataService.globalDungeon.agrEnemy();
        int maxRange = Character.getAttentiveness() + ((Character.getAttentiveness() - Character.getVision()) / distanceCorrectionNumber);
        int minRange = Character.getAttentiveness() - ((Character.getAttentiveness() - Character.getVision()) / distanceCorrectionNumber);
        if (minRange == maxRange) {
            return maxRange + " ";
        } else {
            return minRange + "~" + maxRange;
        }


    }

    @Override
    public String enemyDetection(BaseMonsters enemy) {
        BaseCharacter Character = User.userParty.getPartyMembers()[0];
        int maxRange = enemy.getDistanceToCharacter() + ((enemy.getDistanceToCharacter() - Character.getVision()) / distanceCorrectionNumber);
        int minRange = enemy.getDistanceToCharacter() - ((enemy.getDistanceToCharacter() - Character.getVision()) / distanceCorrectionNumber);
        if (minRange == maxRange) {
            return maxRange + " ";
        } else {
            return minRange + "~" + maxRange + " ";
        }
    }

    @Override
    public void showingLossHealthPoint() {
        System.out.println("------------------------------");
        System.out.println("І'мя : " + getName());
        System.out.println("Клас : " + getCharactersClass());
        System.out.println("Здоров'я :" + getHealthPoint() + "/" + getMaxHealthPoints());
        System.out.println("------------------------------");
    }

    @Override
    public void gettingGold(int n) {
        setGold(getGold() + n);
    }

    @Override
    public void Death() {
        System.out.println("Ваш герой помер!");
    }

    @Override
    public void upliftingExperience(int n) {
        setExperience(getExperience() + n);
    }

    @Override
    public void AgrEnemy() {
        int elementList;
        if (DataService.globalDungeon.listMonsters.size() - 1 != 0) {
            elementList = DataService.myRandom(0, DataService.globalDungeon.listMonsters.size() - 1);
        } else {
            elementList = 0;
        }

        if (DataService.globalDungeon.listMonsters.get(elementList).getMonsterStatus() != MonsterStatus.Агресивний)
            System.out.println("Ви привернули увагу ворога!");

        DataService.globalDungeon.listMonsters.get(elementList).setMonsterStatus(MonsterStatus.Агресивний);
    }
}
