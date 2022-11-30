package com.svaliavchyk.battlesAndAdventures.dl.Monsters.Goblins;

import com.svaliavchyk.battlesAndAdventures.dl.Monsters.BaseMonsters;
import com.svaliavchyk.battlesAndAdventures.dl.Monsters.MonstersType;
import com.svaliavchyk.battlesAndAdventures.ui.Services.DataService;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.AttackType;

public class GoblinWorker extends BaseMonsters {

    public GoblinWorker() {
        this.setName("Робочий гоблінів");
        this.setLevel(1);
        this.setMaxHealthPoints(10);
        this.setHealthPoint(10);
        this.setMaxManaPoints(2);
        this.setManaPoint(2);
        this.setAttackAmount(1);
        this.setAttackType(AttackType.Cutting);
        this.setMonstersType(MonstersType.goblin);
        this.setMuveSpeed(3);
        this.setDistanceToCharacter(12 + DataService.myRandom(0, 5 + (10 * DataService.globalDungeon.LevelDungeon)));
        this.setAttackRange(2);
        this.setAttentiveness(6);
    }

}
