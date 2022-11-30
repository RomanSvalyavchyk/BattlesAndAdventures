package com.svaliavchyk.battlesAndAdventures.dl.Monsters;

import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;
import com.svaliavchyk.battlesAndAdventures.dl.classes.BaseClass;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.AttackType;

public abstract class BaseMonsters implements BaseClass {

    private String name;
    private int healthPoint;
    private int manaPoint;
    private int level;
    private int AttackAmount;
    private int maxHealthPoints;
    private int maxManaPoints;
    private AttackType attackType;
    private MonstersType monstersType;
    private int distanceToCharacter;
    private int muveSpeed;
    private int Gold;
    private MonsterStatus monsterStatus = MonsterStatus.Спокійний;
    private int attentiveness;

    public MonsterStatus getMonsterStatus() {
        return monsterStatus;
    }

    public void setMonsterStatus(MonsterStatus monsterStatus) {
        this.monsterStatus = monsterStatus;
    }

    public int getAttentiveness() {
        return attentiveness;
    }

    public void setAttentiveness(int attentiveness) {
        this.attentiveness = attentiveness;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    public int getMuveSpeed() {
        return muveSpeed;
    }

    public void setMuveSpeed(int muveSpeed) {
        this.muveSpeed = muveSpeed;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    private int attackRange;

    public int getDistanceToCharacter() {
        return distanceToCharacter;
    }

    public void setDistanceToCharacter(int distanceToCharacter) {
        if(distanceToCharacter<1) this.distanceToCharacter = 1;
        else this.distanceToCharacter = distanceToCharacter;


    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = "GoblinUnName";
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        if(healthPoint<1){
            healthPoint=0;
        }else if (healthPoint > this.maxHealthPoints) healthPoint = this.maxHealthPoints;
        this.healthPoint = healthPoint;
    }

    public int getManaPoint() {
        return manaPoint;
    }

    public void setManaPoint(int manaPoint) {
        if(manaPoint<0) manaPoint =0;
        else if (manaPoint>this.maxManaPoints) manaPoint=this.maxManaPoints;
        this.manaPoint = manaPoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level < 0) System.out.println("Рівень гравця понижено!");
        this.level = level;
    }

    public int getAttackAmount() {
        return AttackAmount;
    }

    public void setAttackAmount(int attackAmount) {
        AttackAmount = attackAmount;
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

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public MonstersType getMonstersType() {
        return monstersType;
    }

    public void setMonstersType(MonstersType monstersType) {
        this.monstersType = monstersType;
    }

    @Override
    public void attack() {
        if (getMonsterStatus() == MonsterStatus.Агресивний) {
            if (distanceToCharacter > attackRange){
                System.out.println("Ворог наближається!");

                setDistanceToCharacter(getDistanceToCharacter() - muveSpeed);

            }else {
                System.out.println("Ворог вас атакує!");
                User.userParty.getPartyMembers()[0].loseHealth(getAttackAmount());
            }
        }
    }

    @Override
    public void restoreHealth(int amount) {
        setHealthPoint(this.healthPoint + amount);
    }

    @Override
    public void loseHealth(int amount) {
        setHealthPoint(this.healthPoint - amount);
        showingLossHealthPoint();
        setMonsterStatus(MonsterStatus.Агресивний);
        if(healthPoint<1) Death();

    }

    @Override
    public void restoreMana(int amount) {
        setManaPoint(this.manaPoint + amount);
    }

    @Override
    public void loseMana(int amount) {
        setManaPoint(this.manaPoint - amount);
    }

    @Override
    public void levelUp(int amount) {
        setLevel(this.level + amount);
    }
    @Override
    public void info() {

    }
    @Override
    public String enemyDetection() {
        return null;
    }

    @Override
    public String enemyDetection(BaseMonsters enemy) {
        return null;
    }

    @Override
    public void showingLossHealthPoint(){
        System.out.println("------------------------------");
        System.out.println("І'мя : " + getName() );
        System.out.println("Клас : " + getMonstersType());
        System.out.println("Здоров'я :" + getHealthPoint() + "/" + getMaxHealthPoints());
        System.out.println("------------------------------");
    }

    @Override
    public void gettingGold(int n){
        setGold(getGold() + n);
    }

    @Override
    public void Death(){
        System.out.println("Ви вбили ворога!");

        System.out.println("------------------------------");
        System.out.println("Ви отримуєте:");
        System.out.println("+" + "5 досвіду");
        System.out.println("+" + "1 покращення характеристик");
        System.out.println("+" + "1 покращення вмінь");
        System.out.println("+" + "2 золота");
        System.out.println("------------------------------");

        User.userParty.getPartyMembers()[0].gettingGold(getGold());
        User.userParty.getPartyMembers()[0].upliftingExperience(5);
        User.userParty.getPartyMembers()[0].setAttributeUpgradePoints(User.userParty.getPartyMembers()[0].getAttributeUpgradePoints() + 1);
        User.userParty.getPartyMembers()[0].setSkillUpgradePoints( User.userParty.getPartyMembers()[0].getSkillUpgradePoints() + 1);
        User.userParty.getPartyMembers()[0].setGold( User.userParty.getPartyMembers()[0].getGold() + 2);


    }

    @Override
    public void upliftingExperience(int n){

    }

    @Override
    public void AgrEnemy() {

    }
}
