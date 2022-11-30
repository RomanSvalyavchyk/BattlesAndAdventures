package com.svaliavchyk.battlesAndAdventures.dl.Objects;

import com.svaliavchyk.battlesAndAdventures.dl.classes.BaseCharacter;

public class Party {
    private BaseCharacter[] partyMembers;

    public Party(BaseCharacter... members){
        partyMembers = new BaseCharacter[members.length];
        for(int i = 0; i < partyMembers.length; i++){
            partyMembers[i] = members[i];
        }
    }
    public void info(){
        for (BaseCharacter partyMembers: partyMembers){
            partyMembers.info();
        }
    }

    public BaseCharacter[] getPartyMembers() {
        return partyMembers;
    }
}
