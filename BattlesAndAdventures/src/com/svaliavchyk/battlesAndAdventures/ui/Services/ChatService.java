package com.svaliavchyk.battlesAndAdventures.ui.Services;

public class ChatService {
    public static String ChracterSelection(int NumbDialog){
        String[] AllTextChracterSelection =  {"Вітаємо мандрівник. Зараз тобі доведеться обрати свого першого героя в команду. \nСпочатку ти дивишся характеристики героя і лише потіп обираєш його.",
                "q) Воїн \nw) Лучник \ne) Маг \nr) Вивести всіх",
                "",
                "",
                "",
                ""

        };
        return AllTextChracterSelection[NumbDialog];
    }
    public static String Cyti(int NumbDialog){
        String[] allTextChracterSelection =  {"q) Гільдія ",//0
                "w) Таверна",
                "e) Гостинниця",
                "r) Вийти з міста",
                "a) Магазин зброї",
                "s) Магазин броні",
                "d) Магазин зіль",//6
                "f) Артефакти та рідкісні матеріали",//7
                "Ви в локацї: <<Гільдія Авелона>>",
                "Ви в локацї: Таверна <<П'яний дом>>",
                "Ви в локацї: Гостинниця <<Якблучний пиріг>>",
                "Ви в локацї: Ворота мівста <<Авелон>> ",
                "Ви зайшли в: Маган зброї",
                "Ви зайшли в: Маган броні",
                "Ви зайшли в: Магазин зельєвара",
                "Ви зайшли в: Магазин артефакті та рідкісних матеріалів",//15
                "Такого варіанту немаэ, але можливо в гільдії вам допоможуть!",//16
                "q) Переглянути дошку завдань",//17
                "w) Забрати нагороди",
                "e) Переглянути взяті завдання",//19
                "r) Вийти з гільдії",//20
                ""

        };
        return allTextChracterSelection[NumbDialog];
    }
    public static String chatMainSquareInCity(int NumbDialog){
        String[] allTextChatMainSquareInCity =  {"q) Гільдія ",//0
                "w) Таверна",
                "e) Гостинниця",
                "r) Вийти з міста",
                "a) Магазин зброї",
                "s) Магазин броні",
                "d) Магазин зельєвара",//6
                "f) Артефакти та рідкісні матеріали",//7
                "z) Храм"//8

        };
        return allTextChatMainSquareInCity[NumbDialog];
    }
}
