package com.svaliavchyk.battlesAndAdventures.dl.dungeons;

import com.svaliavchyk.battlesAndAdventures.dl.Monsters.BaseMonsters;
import com.svaliavchyk.battlesAndAdventures.dl.Monsters.Goblins.GoblinWorker;
import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    public List<BaseMonsters> listMonstersInLocation = new ArrayList<>();
    public List<BaseMonsters> listMonsters = new ArrayList<>();

    public int numberEnemiesInLevel = 5;
    public int LevelDungeon = 1;

    public Dungeon() {
    }

    public void spawnEnemy(){
        listMonstersInLocation.clear();
        listMonsters.clear();
        for(int i = 0; i < numberEnemiesInLevel * LevelDungeon; i++)
        {
            listMonstersInLocation.add(new GoblinWorker());
        }


    }

    public void agrEnemy(){
        for (BaseMonsters checkMonster: listMonstersInLocation) {

            if(checkMonster.getDistanceToCharacter() <= User.userParty.getPartyMembers()[0].getAttentiveness()){
                listMonsters.add(checkMonster);
            }
        }
        removeAgree();
    }

    public void removeAgree(){
        for (BaseMonsters checkMonster: listMonsters) {
            if(listMonstersInLocation.equals(checkMonster)){
                listMonstersInLocation.remove(checkMonster);
            }
        }
    }
    public void removeDeath(int n){
        for(int i = 0; i < n; i++)
        {
            try {
                listMonsters.removeIf(checkMonster -> checkMonster.getHealthPoint() < 1);
            }catch (Exception ignored){

            }
        }
    }


}
