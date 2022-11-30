package com.svaliavchyk.battlesAndAdventures.ui.Services;

import com.svaliavchyk.battlesAndAdventures.da.Encryption.EncryptionMethod;
import com.svaliavchyk.battlesAndAdventures.dl.dungeons.Dungeon;
import com.svaliavchyk.battlesAndAdventures.dl.Сities.Buildings.Guild;

import java.util.Random;
import java.util.Scanner;

public class DataService {

    public static CityService globalCityService;
    public static Guild globalGuild;
    public static Dungeon globalDungeon;
    public static BattleService globalBattleService;

    public static void fillingPaths(){
        DataService.globalGuild = new Guild();
        DataService.globalCityService = new CityService();
        DataService.globalDungeon = new Dungeon();
        DataService.globalBattleService = new BattleService();
    }

    public static int myRandom(int i, int j){
        Random rnd = new Random();
        return  rnd.nextInt(i, j);
    }

    public String Hashing(String TextToHashed){
        EncryptionMethod encryptionMethod =new EncryptionMethod();
        return encryptionMethod.HashingProcess(TextToHashed);
    }

    public static char ProcessingEnteredMessages(char c){
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine().charAt(0);
        }catch (Exception e){
            return ' ';
        }

    }

    public static String ProcessingEnteredMessages(String s){
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }catch (Exception e){
            return "";
        }
    }

    public static String myMethodSplit(String s, char c, int j){
        String[] Result = myMethodSplit(s,c);
        return Result[j];
    }
    public static String[] myMethodSplit(String s, char c){
        int lengthMas = 1;
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c)
                lengthMas++;
        }
        String[] Result = new String[lengthMas];
        int Cell = 0;
        Result[0] = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                Cell++;
                Result[Cell] = "";
            }else{
                Result[Cell] += s.charAt(i);
            }
        }
        return Result;
    }
    public static boolean similarityString(String s1, String s2){
        try {
            if(s1.length() == s2.length()){
                for(int i = 0; i < s1.length(); i++){
                    if(s1.charAt(i) != s2.charAt(i)){
                        return false;
                    }
                }
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
