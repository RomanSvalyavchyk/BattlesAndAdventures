package com.svaliavchyk.battlesAndAdventures.ui.Services;

import com.svaliavchyk.battlesAndAdventures.dl.Objects.Party;
import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.Archer;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.Magician;
import com.svaliavchyk.battlesAndAdventures.dl.classes.characters.Warrior;

public class CharacterSelectionService {
    public void main(){
        System.out.println(ChatService.ChracterSelection(0));

        printInfoCharacters();

    }

    void printInfoCharacters(){
        System.out.println(ChatService.ChracterSelection(1));
        Warrior warrior = new Warrior("___");
        Archer archer = new Archer("___");
        Magician magician = new Magician("___");
        switch(DataService.ProcessingEnteredMessages(' ')) {
            case 113: //q

                warrior.info();
                warrior = null;
                CharacterSelection(1);
                break;
            case 119: //w

                archer.info();
                archer = null;
                CharacterSelection(2);
                break;
            case 101: //e

                magician.info();
                magician = null;
                CharacterSelection(3);
                break;
            case 114: //r

                warrior.info();

                archer.info();

                magician.info();

                warrior = null;
                archer = null;
                magician = null;
                CharacterSelection(4);
                break;

            default:
                System.out.println("Некоректний вибір!");
                System.out.println("Спробуйте ще раз");

                warrior = null;
                archer = null;
                magician = null;
                printInfoCharacters();
                break;
        }
    }

    void CharacterSelection (int numb){
        switch(numb) {
            case 1:
                System.out.println("Ви впевнені що хочите вибрати: Воїна?");
                System.out.println("a) Вибрати Воїна");
                System.out.println("s) Повернутись");
                switch(DataService.ProcessingEnteredMessages(' ')) {
                    case 'a':
                        System.out.println("Введіть ім'я Воїна.");
                        Party party = new Party(new Warrior(DataService.ProcessingEnteredMessages("")));
                        User.userParty = party;
                        break;
                    case 's':
                        System.out.println("Повернення до перегляду характеристик.");
                        printInfoCharacters();
                        break;
                    default:
                        System.out.println("Не коректний вибір!");
                        System.out.println("Повернення до перегляду характеристик.");
                        printInfoCharacters();
                        break;
                }
                break;
            case 2:
                System.out.println("Ви впевнені що хочите вибрати: Лучника?");
                System.out.println("a) Вибрати Лучника");
                System.out.println("s) Повернутись");
                switch(DataService.ProcessingEnteredMessages(' ')) {
                    case 'a':
                        System.out.println("Введіть ім'я Лучника.");
                        Party party = new Party(new Archer(DataService.ProcessingEnteredMessages("")));
                        User.userParty = party;
                        break;
                    case 's':
                        System.out.println("Повернення до перегляду характеристик.");
                        printInfoCharacters();
                        break;
                    default:
                        System.out.println("Не коректний вибір!");
                        System.out.println("Повернення до перегляду характеристик.");
                        printInfoCharacters();
                        break;
                }
                break;
            case 3:
                System.out.println("Ви впевнені що хочите вибрати: Мага?");
                System.out.println("a) Вибрати Мага");
                System.out.println("s) Повернутись");
                switch(DataService.ProcessingEnteredMessages(' ')) {
                    case 'a':
                        System.out.println("Введіть ім'я Мага.");
                        Party party = new Party(new Magician(DataService.ProcessingEnteredMessages("")));
                        User.userParty = party;
                        break;
                    case 's':
                        System.out.println("Повернення до перегляду характеристик.");
                        printInfoCharacters();
                        break;
                    default:
                        System.out.println("Не коректний вибір!");
                        System.out.println("Повернення до перегляду характеристик.");
                        printInfoCharacters();
                        break;
                }
                break;
            case 4:
                System.out.println("a) Вибрати Воїна");
                System.out.println("s) Вибрати Лучника");
                System.out.println("d) Вибрати Мага");
                System.out.println("f) Повернутись");

                switch(DataService.ProcessingEnteredMessages(' ')) {
                    case 'a':
                        System.out.println("Ви впевнені що хочите вибрати: Воїна?");
                        System.out.println("q) Вибрати Воїна");
                        System.out.println("w) Повернутись");
                        switch(DataService.ProcessingEnteredMessages(' ')) {
                            case 113: //q
                                System.out.println("Введіть ім'я Воїна.");
                                Party party = new Party(new Warrior(DataService.ProcessingEnteredMessages("")));
                                User.userParty = party;
                                break;
                            case 119: //w
                                System.out.println("Повернення до перегляду характеристик.");
                                printInfoCharacters();
                                break;
                            default:
                                System.out.println("Не коректний вибір!");
                                System.out.println("Повернення до перегляду характеристик.");
                                printInfoCharacters();
                                break;
                        }
                        break;
                    case 's':
                        System.out.println("Ви впевнені що хочите вибрати: Лучника?");
                        System.out.println("q) Вибрати Лучника");
                        System.out.println("w) Повернутись");
                        switch(DataService.ProcessingEnteredMessages(' ')) {
                            case 113: //q
                                System.out.println("Введіть ім'я Лучника.");
                                Party party = new Party(new Archer(DataService.ProcessingEnteredMessages("")));
                                User.userParty = party;
                                break;
                            case 119: //w
                                System.out.println("Повернення до перегляду характеристик.");
                                printInfoCharacters();
                                break;
                            default:
                                System.out.println("Не коректний вибір!");
                                System.out.println("Повернення до перегляду характеристик.");
                                printInfoCharacters();
                                break;
                        }
                        break;
                    case 'd':
                        System.out.println("Ви впевнені що хочите вибрати: Мага?");
                        System.out.println("q) Вибрати Лучника");
                        System.out.println("w) Повернутись");
                        switch(DataService.ProcessingEnteredMessages(' ')) {
                            case 113: //q
                                System.out.println("Введіть ім'я Мага.");
                                Party party = new Party(new Magician(DataService.ProcessingEnteredMessages("")));
                                User.userParty = party;
                                break;
                            case 119: //w
                                System.out.println("Повернення до перегляду характеристик.");
                                printInfoCharacters();
                                break;
                            default:
                                System.out.println("Не коректний вибір!");
                                System.out.println("Повернення до перегляду характеристик.");
                                printInfoCharacters();
                                break;
                        }
                        break;
                    case 'f':
                        System.out.println("Повернення до перегляду характеристик.");
                        printInfoCharacters();
                        break;
                    default:
                        System.out.println("Не коректний вибір!");
                        System.out.println("Повернення до перегляду характеристик.");
                        printInfoCharacters();
                        break;
                }
                break;
            default:
                System.out.println("Ви впевнені що хочите вибрати: Война");
                break;
        }
    }
}
