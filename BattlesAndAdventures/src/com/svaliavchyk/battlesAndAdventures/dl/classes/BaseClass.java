package com.svaliavchyk.battlesAndAdventures.dl.classes;

import com.svaliavchyk.battlesAndAdventures.dl.Monsters.BaseMonsters;

public interface BaseClass {
    void attack();
    void restoreHealth(int amount);
    void loseHealth(int amount);
    void restoreMana(int amount);
    void loseMana(int amount);
    void levelUp(int amount);
    void info();
    void showingLossHealthPoint();
    void upliftingExperience(int n);
    void Death();
    void gettingGold(int n);
    String enemyDetection();
    String enemyDetection(BaseMonsters enemy);
    void AgrEnemy();

}
