package com.svaliavchyk.battlesAndAdventures.dl.classes.characters;

import com.svaliavchyk.battlesAndAdventures.dl.classes.BaseCharacter;

public class Warrior extends BaseCharacter {
    int[] RaisingCharacteristicsPerLevel = {6, 1, 1, 2};
    public Warrior(String name){
        this.setName(name);
        this.setLevel(1);
        this.setMaxHealthPoints(4);
        this.setHealthPoint(4);
        this.setMaxManaPoints(8);
        this.setManaPoint(8);
        this.setAttackDistanceAmount(5);
        this.setAttackType(AttackType.Magic);
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
    public void levelUp(int amount) {
        super.levelUp(amount);
        setStrong(getStrong() + RaisingCharacteristicsPerLevel[0]);
        setDexterity(getDexterity() + RaisingCharacteristicsPerLevel[1]);
        setIntelligence(getIntelligence() + RaisingCharacteristicsPerLevel[2]);
        setWisdom(getWisdom() + RaisingCharacteristicsPerLevel[3]);
        setAttributeUpgradePoints(getAttributeUpgradePoints() + 1);

        System.out.println("------------------------------");
        System.out.println("|Рівень персонажа піднято. Рівень: " + getLevel() + " |");
        System.out.println("------------------------------");
    }

    @Override
    public void setIntelligence(int intelligence) {
        super.setIntelligence(intelligence);

        setAttackMagicAmount(getIntelligence());
    }
}
