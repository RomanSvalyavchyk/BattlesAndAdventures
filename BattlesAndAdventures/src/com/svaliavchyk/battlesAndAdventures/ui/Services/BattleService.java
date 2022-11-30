package com.svaliavchyk.battlesAndAdventures.ui.Services;

import com.svaliavchyk.battlesAndAdventures.dl.Monsters.BaseMonsters;
import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;

public class BattleService {

    public void main() {

        while (true){

            User.userParty.getPartyMembers()[0].attack();

            if(victoryCondition()){
                break;
            }
            int numbDeath = 0;
            int formerHealthPoint = User.userParty.getPartyMembers()[0].getHealthPoint();
            for (BaseMonsters CheckMonsters: DataService.globalDungeon.listMonsters) {
                if(CheckMonsters.getHealthPoint() > 0){
                    CheckMonsters.attack();
                }
                else {
                    numbDeath++;
                }

                if(victoryCondition()){
                    break;
                }
            }
            if(formerHealthPoint > User.userParty.getPartyMembers()[0].getHealthPoint()) User.userParty.getPartyMembers()[0].showingLossHealthPoint();

            DataService.globalDungeon.removeDeath(numbDeath);
        }

        DataService.globalGuild.dungeonsGoblin();

    }
    public boolean victoryCondition(){
        boolean ollEnemyDeath = false;
        for (BaseMonsters CheckMonsters: DataService.globalDungeon.listMonsters) {
            if (CheckMonsters.getHealthPoint() > 0) {
                ollEnemyDeath = true;
                break;
            }
        }
        return !ollEnemyDeath || User.userParty.getPartyMembers()[0].getHealthPoint() < 1;
    }
}
