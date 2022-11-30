package com.svaliavchyk.battlesAndAdventures.dl.Spells.PureMagic;

import com.svaliavchyk.battlesAndAdventures.dl.Monsters.BaseMonsters;
import com.svaliavchyk.battlesAndAdventures.dl.Spells.SpellsClass;
import com.svaliavchyk.battlesAndAdventures.dl.classes.BaseCharacter;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.Magician;
import com.svaliavchyk.battlesAndAdventures.ui.Services.DataService;

import java.util.ArrayList;

public class ManaShot extends SpellsClass {
    public ManaShot(BaseCharacter Character, int[] upgrade , int[] bonusQC) {
        System.out.println("Використання швидкого касту: Шкода (+1), Витрати мани (-1)");
        this.setName("Постріл мани");
        this.setRange(2 + Character.getRangedAttackRange());
        this.setAttackAmount(1 + Character.getAttackMagicAmount()+1);
        this.setNumberTargets(1);
        this.setManaCost(2 - 1);

        if (getManaCost() <= Character.getManaPoint()) {
            Character.loseMana(getManaCost());
            System.out.println("Використано заклинання :" + getName());
            attackEnemy();
        } else {
            System.out.println("|Недостатньо мани|");
        }
    }

    public ManaShot(BaseCharacter Character, int[] upgrade) {
        this.setName("Постріл мани");
        this.setRange(2 + Character.getRangedAttackRange());
        this.setAttackAmount(1 + Character.getAttackMagicAmount());
        this.setNumberTargets(1);
        this.setManaCost(2);

        info();

        System.out.println("Підтвердіть каст");
        System.out.println("q) Використати заклинання");
        System.out.println("w) Відхилити");
        Magician magician = (Magician)Character;;
        switch (DataService.ProcessingEnteredMessages( ' ')){

            case 'q':
                if (getManaCost() <= Character.getManaPoint()) {
                    Character.loseMana(getManaCost());
                    System.out.println("Використано заклинання :" + getName());
                    attackEnemy();
                } else {
                    System.out.println("|Недостатньо мани|");
                }
                break;
            case 'w':
                magician.BookOfSpells();
                break;
            default:
                System.out.println("Каст відхилено");
                magician.BookOfSpells();
                break;

        }


    }

    public void attackEnemy() {
        int hit = getNumberTargets();
        for (BaseMonsters CheckMonsters : DataService.globalDungeon.listMonsters) {
            if (CheckMonsters.getDistanceToCharacter() < getRange()) {
                hit --;
                System.out.println("|Ви влучили по ворогу|");
                CheckMonsters.loseHealth(getAttackAmount());
                if(hit < 1) break;
            }
        }
        if (hit == getNumberTargets()) {
            System.out.println("|Заклинання не долетіло до ворога|");
            AgrEnemy();
        }
    }
}
