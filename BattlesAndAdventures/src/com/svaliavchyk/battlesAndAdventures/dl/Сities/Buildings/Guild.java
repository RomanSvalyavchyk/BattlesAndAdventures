package com.svaliavchyk.battlesAndAdventures.dl.Сities.Buildings;

import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;
import com.svaliavchyk.battlesAndAdventures.ui.Services.ChatService;
import com.svaliavchyk.battlesAndAdventures.ui.Services.DataService;

public class Guild {

    public void main() {
        System.out.println(ChatService.Cyti(8));
        for (int i = 17; i < 21; i++)
            System.out.println(ChatService.Cyti(i));

        switch (DataService.ProcessingEnteredMessages(' ')) {
            case 'q' -> bordMissions();
            case 'w' -> {
                System.out.println("Виконаних місій немає");
                main();
            }
            case 'e' -> {
                System.out.println("Список взятих завдань: пустий");
                main();
            }
            case 'r' -> DataService.globalCityService.main();
            default -> {
                System.out.println("Ви не знали що робити, тому вийшли з гільдії.");
                main();
            }
        }
    }

    public void bordMissions() {
        System.out.println("Дошка місій");
        System.out.println("q) Повернутись");
        System.out.println("1) Вбити всіх ворогів в локації <<Рівнин гоблінів>> на рівні: 1 ");
        System.out.println("2) Вбити всіх павуків в локації <<Підземелля павуків>> на рівні: 1 ");
        System.out.println("3) Зібрати лікувальні трави біля стін міста");

        switch (DataService.ProcessingEnteredMessages("")) {
            case "q" -> main();
            case "1" -> dungeonsGoblin();
            case "2", "3" -> missionBusy();
            default -> {
                System.out.println("Такої місії немає");
                bordMissions();
            }
        }
    }

    public void missionBusy() {
        System.out.println("Цю місію вже взяла інша команда. ");
        System.out.println("Зачекайти поки вони закінчать, або відмовляться від неї");
        bordMissions();
    }

    public void dungeonsGoblin() {
        System.out.println("Ви в локації <<Рівнини гоблінів>>");
        System.out.println("q) Розвідка");
        System.out.println("w) Повернутись до міста");

        switch (DataService.ProcessingEnteredMessages(' ')) {
            case 'q' -> {
                DataService.globalDungeon.spawnEnemy();
                intelligence();
            }
            case 'w' -> main();
            default -> {
                System.out.println("Ви не знали що робити, тому повернулмсь");
                main();
            }
        }
    }

    void intelligence() {
        System.out.println("Ви помітили гобліна в " + User.userParty.getPartyMembers()[0].enemyDetection() + " метрах від себе");
        System.out.println("q) Атакувати");
        System.out.println("w) Відступити");

        switch (DataService.ProcessingEnteredMessages(' ')) {
            case 'q' -> DataService.globalBattleService.main();
            case 'w' -> dungeonsGoblin();
            default -> {
                System.out.println("Ви вирішили відступити");
                dungeonsGoblin();
            }
        }
    }


}
