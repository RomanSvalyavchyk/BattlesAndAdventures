package com.svaliavchyk.battlesAndAdventures.ui.Services;

import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;
import com.svaliavchyk.battlesAndAdventures.dl.classes.BaseCharacter;

import static java.lang.Integer.parseInt;

public class CityService {
    public void main() {
        System.out.println("Ви в локації: місто <<Авелон>>");
        for (int i = 0; i < 9; i++) {
            System.out.println(ChatService.chatMainSquareInCity(i));
        }

        switch (DataService.ProcessingEnteredMessages(' ')) {
            case 'q' -> guild();
            case 'w' -> tavern();
            case 'e' -> inn();
            case 'r' -> leaveCity();
            case 'a' -> WeaponShop();
            case 's' -> ArmorShop();
            case 'd' -> PotionShop();
            case 'f' -> ArtifactsAndRareMaterials();
            case 'z' -> Temple();
            default -> {
                System.out.println("Такого варіанту немаэ, але можливо в гільдії вам допоможуть!");
                guild();
            }
        }
    }

    void guild() {

        DataService.globalGuild.main();
    }

    void tavern() {
        System.out.println("Таверна була зачинена, ви повернулись");
        main();
    }

    void inn() {
        BaseCharacter character = User.userParty.getPartyMembers()[0];
        System.out.println("Вітаємо в гостинниці <<Ялта>>");
        System.out.println("Вартісь ночівлі 2 золота");
        System.out.println("Ваше золото : " + character.getGold());
        System.out.println("q) Переночувати");
        System.out.println("w) Вийти з гистиниці");
        switch (DataService.ProcessingEnteredMessages(' ')) {
            case 'q':
                if (character.getGold() >= 2) {
                    character.setGold(character.getGold() - 2);
                    System.out.println("Гарного відпочинку!");
                    System.out.println("ZZZzzzzz...");
                    character.setHealthPoint(character.getMaxHealthPoints());
                    character.setManaPoint(character.getMaxManaPoints());
                    System.out.println("------------------------------");
                    System.out.println("Здоров'я: " + character.getHealthPoint() + "/" + character.getMaxHealthPoints());
                    System.out.println("Мана: " + character.getManaPoint() + "/" + character.getMaxManaPoints());
                    System.out.println("------------------------------");

                    System.out.println("|Ви повністю відпочили|");
                    System.out.println("Вихід з гостинниці");
                    main();
                }else {
                    System.out.println("У вас було недостатньо золота, вас ввічливо попросили вийти");
                    main();
                }
                break;
            case 'w':
                main();
                break;
            default:
                System.out.println("Повернення на головну площу");
                main();
                break;

        }
        System.out.println("Гостиниця була зачинена, ви повернулись");
        main();
    }

    void leaveCity() {
        System.out.println("Ворота були зачинені, ви повернулись");
        main();
    }

    void WeaponShop() {
        System.out.println("Було зачинено, ви повернулись");
        main();
    }

    void ArmorShop() {
        System.out.println("Було зачинено, ви повернулись");
        main();
    }

    void PotionShop() {
        System.out.println("Було зачинено, ви повернулись");
        main();
    }

    void ArtifactsAndRareMaterials() {
        System.out.println("Було зачинено, ви повернулись");
        main();
    }

    void Temple() {
        System.out.println("Ви в локацї: <<Храм Авелона>>");
        System.out.println("В храмі ви пожете піднімати рівні деяких вмінь, та збільшувати значення характеристик");
        System.out.println("q) Покращити характеристики");
        System.out.println("w) Покращити вміння");
        System.out.println("e) Зброя проти нежиті");
        System.out.println("r) Вийти з храму");

        switch (DataService.ProcessingEnteredMessages(' ')) {
            case 'q' -> {
                if (User.userParty.getPartyMembers()[0].getAttributeUpgradePoints() > 0) ImprovementCharacteristics();
                else {
                    System.out.println("Недостатньо очків покращення характеристик");
                    Temple();
                }
            }
            case 'w' -> ImprovementSkill();
            case 'e' -> inn();
            case 'r' -> DataService.globalCityService.main();
            default -> {
                System.out.println("Вас не зрозуміли!");
                Temple();
            }
        }
    }

    public void ImprovementCharacteristics() {
        System.out.println("Покращення характеристик");
        System.out.println("q) Повернутись");
        System.out.println("Кількіст балів які молжа використати : " + User.userParty.getPartyMembers()[0].getAttributeUpgradePoints());
        System.out.println("Оберіть характеристику яку бажаєте покращити:");
        System.out.println("1) Сила : " + User.userParty.getPartyMembers()[0].getStrong());
        System.out.println("2) Спритність : " + User.userParty.getPartyMembers()[0].getDexterity());
        System.out.println("3) Інтелект : " + User.userParty.getPartyMembers()[0].getIntelligence());
        System.out.println("4) Мудрість : " + User.userParty.getPartyMembers()[0].getWisdom());
        System.out.println("5) Увага : " + User.userParty.getPartyMembers()[0].getAttentiveness());
        System.out.println("6) Зір : " + User.userParty.getPartyMembers()[0].getVision());
        System.out.println("7) Дальність дистанційної атаки : " + User.userParty.getPartyMembers()[0].getRangedAttackRange());
        System.out.println("8) Міткість : " + User.userParty.getPartyMembers()[0].getAccuracy());
        String ChoiceCharacteristics = DataService.ProcessingEnteredMessages("");

        int userChoice = 0;

        switch (ChoiceCharacteristics) {
            case "q" -> Temple();
            case "1" -> {
                userChoice = numbImprovementCharacteristics();
                System.out.println("Підтвердіть дію щоб продовжити!");
                System.out.println("Підняття характеристтики Сила на : " + userChoice);
                System.out.println("q) Підтвердити");
                System.out.println("w) Відхилити");
                switch (DataService.ProcessingEnteredMessages(' ')) {
                    case 'q' -> {
                        User.userParty.getPartyMembers()[0].setStrong(User.userParty.getPartyMembers()[0].getStrong() + userChoice);
                        User.userParty.getPartyMembers()[0].setAttributeUpgradePoints(User.userParty.getPartyMembers()[0].getAttributeUpgradePoints() - userChoice);
                        System.out.println("Вітаємо з успішним покращенням характеристики!");
                        Temple();
                    }
                    case 'w' -> Temple();
                    default -> {
                        System.out.println("Підняття характеристик відхилено!");
                        Temple();
                    }
                }
            }
            case "2" -> {
                userChoice = numbImprovementCharacteristics();
                System.out.println("Підтвердіть дію щоб продовжити!");
                System.out.println("Підняття характеристтики Сила на : " + userChoice);
                System.out.println("q) Підтвердити");
                System.out.println("w) Відхилити");
                switch (DataService.ProcessingEnteredMessages(' ')) {
                    case 'q' -> {
                        User.userParty.getPartyMembers()[0].setDexterity(User.userParty.getPartyMembers()[0].getDexterity() + userChoice);
                        User.userParty.getPartyMembers()[0].setAttributeUpgradePoints(User.userParty.getPartyMembers()[0].getAttributeUpgradePoints() - userChoice);
                        System.out.println("Вітаємо з успішним покращенням характеристики!");
                        Temple();
                    }
                    case 'w' -> Temple();
                    default -> {
                        System.out.println("Підняття характеристик відхилено!");
                        Temple();
                    }
                }
            }
            case "3" -> {
                userChoice = numbImprovementCharacteristics();
                System.out.println("Підтвердіть дію щоб продовжити!");
                System.out.println("Підняття характеристтики Інтилект на : " + userChoice);
                System.out.println("q) Підтвердити");
                System.out.println("w) Відхилити");
                switch (DataService.ProcessingEnteredMessages(' ')) {
                    case 'q' -> {
                        User.userParty.getPartyMembers()[0].setIntelligence(User.userParty.getPartyMembers()[0].getIntelligence() + userChoice);
                        User.userParty.getPartyMembers()[0].setAttributeUpgradePoints(User.userParty.getPartyMembers()[0].getAttributeUpgradePoints() - userChoice);
                        System.out.println("Вітаємо з успішним покращенням характеристики!");
                        Temple();
                    }
                    case 'w' -> Temple();
                    default -> {
                        System.out.println("Підняття характеристик відхилено!");
                        Temple();
                    }
                }
            }
            case "4" -> {
                userChoice = numbImprovementCharacteristics();
                System.out.println("Підтвердіть дію щоб продовжити!");
                System.out.println("Підняття характеристтики Мудрість на : " + userChoice);
                System.out.println("q) Підтвердити");
                System.out.println("w) Відхилити");
                switch (DataService.ProcessingEnteredMessages(' ')) {
                    case 'q' -> {
                        User.userParty.getPartyMembers()[0].setWisdom(User.userParty.getPartyMembers()[0].getWisdom() + userChoice);
                        User.userParty.getPartyMembers()[0].setAttributeUpgradePoints(User.userParty.getPartyMembers()[0].getAttributeUpgradePoints() - userChoice);
                        System.out.println("Вітаємо з успішним покращенням характеристики!");
                        Temple();
                    }
                    case 'w' -> Temple();
                    default -> {
                        System.out.println("Підняття характеристик відхилено!");
                        Temple();
                    }
                }
            }
            case "5" -> {
                userChoice = numbImprovementCharacteristics();
                System.out.println("Підтвердіть дію щоб продовжити!");
                System.out.println("Підняття характеристтики Увага на : " + userChoice);
                System.out.println("q) Підтвердити");
                System.out.println("w) Відхилити");
                switch (DataService.ProcessingEnteredMessages(' ')) {
                    case 'q' -> {
                        User.userParty.getPartyMembers()[0].setAttentiveness(User.userParty.getPartyMembers()[0].getAttentiveness() + userChoice);
                        User.userParty.getPartyMembers()[0].setAttributeUpgradePoints(User.userParty.getPartyMembers()[0].getAttributeUpgradePoints() - userChoice);
                        System.out.println("Вітаємо з успішним покращенням характеристики!");
                        Temple();
                    }
                    case 'w' -> Temple();
                    default -> {
                        System.out.println("Підняття характеристик відхилено!");
                        Temple();
                    }
                }
            }
            case "6" -> {
                userChoice = numbImprovementCharacteristics();
                System.out.println("Підтвердіть дію щоб продовжити!");
                System.out.println("Підняття характеристтики Зір на : " + userChoice);
                System.out.println("q) Підтвердити");
                System.out.println("w) Відхилити");
                switch (DataService.ProcessingEnteredMessages(' ')) {
                    case 'q' -> {
                        User.userParty.getPartyMembers()[0].setVision(User.userParty.getPartyMembers()[0].getVision() + userChoice);
                        User.userParty.getPartyMembers()[0].setAttributeUpgradePoints(User.userParty.getPartyMembers()[0].getAttributeUpgradePoints() - userChoice);
                        System.out.println("Вітаємо з успішним покращенням характеристики!");
                        Temple();
                    }
                    case 'w' -> Temple();
                    default -> {
                        System.out.println("Підняття характеристик відхилено!");
                        Temple();
                    }
                }
            }
            case "7" -> {
                userChoice = numbImprovementCharacteristics();
                System.out.println("Підтвердіть дію щоб продовжити!");
                System.out.println("Підняття характеристтики відстані дальньої атаки на : " + userChoice);
                System.out.println("q) Підтвердити");
                System.out.println("w) Відхилити");
                switch (DataService.ProcessingEnteredMessages(' ')) {
                    case 'q' -> {
                        User.userParty.getPartyMembers()[0].setRangedAttackRange(User.userParty.getPartyMembers()[0].getRangedAttackRange() + userChoice);
                        User.userParty.getPartyMembers()[0].setAttributeUpgradePoints(User.userParty.getPartyMembers()[0].getAttributeUpgradePoints() - userChoice);
                        System.out.println("Вітаємо з успішним покращенням характеристики!");
                        Temple();
                    }
                    case 'w' -> Temple();
                    default -> {
                        System.out.println("Підняття характеристик відхилено!");
                        Temple();
                    }
                }
            }
            case "8" -> {
                userChoice = numbImprovementCharacteristics();
                System.out.println("Підтвердіть дію щоб продовжити!");
                System.out.println("Підняття характеристтики відстані дальньої атаки на : " + userChoice);
                System.out.println("q) Підтвердити");
                System.out.println("w) Відхилити");
                switch (DataService.ProcessingEnteredMessages(' ')) {
                    case 'q' -> {
                        User.userParty.getPartyMembers()[0].setAccuracy(User.userParty.getPartyMembers()[0].getAccuracy() + userChoice);
                        User.userParty.getPartyMembers()[0].setAttributeUpgradePoints(User.userParty.getPartyMembers()[0].getAttributeUpgradePoints() - userChoice);
                        System.out.println("Вітаємо з успішним покращенням характеристики!");
                        Temple();
                    }
                    case 'w' -> Temple();
                    default -> {
                        System.out.println("Підняття характеристик відхилено!");
                        Temple();
                    }
                }
            }
            default -> {
                System.out.println("Вас не зрозуміли!");
                Temple();
            }
        }
    }

    public void ImprovementSkill() {

    }

    public int numbImprovementCharacteristics() {

        System.out.println("Скільки балів бажаєте використати?");
        System.out.println("Введіть число від 1 до " + User.userParty.getPartyMembers()[0].getAttributeUpgradePoints());
        int userChoice = 0;

        try {
            userChoice = parseInt(DataService.ProcessingEnteredMessages(""));
            if (userChoice > User.userParty.getPartyMembers()[0].getAttributeUpgradePoints()) {
                System.out.println("Буде використано всі бали, а саме " + User.userParty.getPartyMembers()[0].getAttributeUpgradePoints());
                userChoice = User.userParty.getPartyMembers()[0].getAttributeUpgradePoints();
            } else if (userChoice < 0) {
                System.out.println("Зменшувати характеристику не можна!");
                Temple();
            } else if (userChoice == 0) {
                System.out.println("Не можна змінювати характезистику на значення 0!");
                Temple();
            }
            return userChoice;
        } catch (Exception e) {
            System.out.println("Вас не зрозуміли. Спробуйте ще раз або прийдіть іншим разом.");
            Temple();
            return userChoice;
        }

    }

}
