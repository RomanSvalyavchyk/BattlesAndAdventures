package com.svaliavchyk.battlesAndAdventures.dl.Spells;

import com.svaliavchyk.battlesAndAdventures.dl.Monsters.MonsterStatus;
import com.svaliavchyk.battlesAndAdventures.ui.Services.DataService;

public abstract class SpellsClass implements BaseSpells{
    private String name;
    private int Range;
    private int AttackAmount;
    private int manaCost;
    private int numberTargets;
    private int amountShield;

    public int getAmountShield() {
        return amountShield;
    }

    public void setAmountShield(int amountShield) {
        this.amountShield = amountShield;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRange() {
        return Range;
    }

    public void setRange(int range) {
        Range = range;
    }

    public int getAttackAmount() {
        return AttackAmount;
    }

    public void setAttackAmount(int attackAmount) {
        AttackAmount = attackAmount;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getNumberTargets() {
        return numberTargets;
    }

    public void setNumberTargets(int numberTargets) {
        this.numberTargets = numberTargets;
    }

    @Override
    public void attackEnemy() {

    }

    @Override
    public void info() {
        System.out.println("------------------------------");
        System.out.println("І'мя : " + getName());
        System.out.println("Дальність : " + getRange());
        System.out.println("Шкода : " + getAttackAmount());
        System.out.println("Кількість цілей :" + getNumberTargets());
        System.out.println("Вартість мани :" + getManaCost());
        System.out.println("------------------------------");
    }

    @Override
    public void lossOfMagicShieldStrength() {

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
