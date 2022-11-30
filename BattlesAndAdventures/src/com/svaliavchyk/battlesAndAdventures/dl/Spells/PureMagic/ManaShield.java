package com.svaliavchyk.battlesAndAdventures.dl.Spells.PureMagic;

import com.svaliavchyk.battlesAndAdventures.dl.Spells.SpellsClass;
import com.svaliavchyk.battlesAndAdventures.dl.classes.BaseCharacter;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.Magician;
import com.svaliavchyk.battlesAndAdventures.ui.Services.DataService;

public class ManaShield extends SpellsClass {
    public ManaShield(BaseCharacter Character, int[] upgrade, int[] bonusQC) {
        System.out.println("Використання швидкого касту: міцність (+1), витрати мани (-1)");
        this.setName("Щит мани");
        this.setAmountShield(2 + 1);
        this.setManaCost(2 - 1);

        if (getManaCost() <= Character.getManaPoint()) {
            Character.loseMana(getManaCost());
            System.out.println("Використано заклинання :" + getName());
            attackEnemy();
        } else {
            System.out.println("|Недостатньо мани|");
        }
    }

    public ManaShield(BaseCharacter Character, int[] upgrade) {
        this.setName("Щит мани");
        this.setAmountShield(2);
        this.setManaCost(2);
        ;

        System.out.println("------------------------------");
        System.out.println("І'мя : " + getName());
        System.out.println("Міцність щита : " + getAmountShield());
        System.out.println("Вартість мани :" + getManaCost());
        System.out.println("------------------------------");

        System.out.println("Підтвердіть каст");
        System.out.println("q) Використати заклинання");
        System.out.println("w) Відхилити");
        Magician magician = (Magician) Character;
        ;
        switch (DataService.ProcessingEnteredMessages(' ')) {

            case 'q':
                if (getManaCost() <= Character.getManaPoint()) {
                    Character.loseMana(getManaCost());
                    System.out.println("Використано заклинання :" + getName());
                    magician.setMagicShield(getAmountShield());
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

}
