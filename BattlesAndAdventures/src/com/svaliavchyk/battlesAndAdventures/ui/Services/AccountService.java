package com.svaliavchyk.battlesAndAdventures.ui.Services;

import com.svaliavchyk.battlesAndAdventures.da.Encryption.EncryptionMethod;
import com.svaliavchyk.battlesAndAdventures.dl.Objects.User;

import java.io.*;

public class AccountService {
    public void main() {
    String Log, Pas;
    System.out.println("q) Авторизація");
    System.out.println("w) Реєстрація");
    System.out.println("e) Вихід");

    File file = new File("Users.txt");
    boolean existingAccount = false;

    switch(DataService.ProcessingEnteredMessages(' '))
    {
        case 113: //q

            //Авторизація
            System.out.println("Введіть логін:");
            Log = DataService.ProcessingEnteredMessages("");
            System.out.println("Введіть пароль:");
            Pas = hashing(DataService.ProcessingEnteredMessages(""));

            int leng = Log.length();
            for(int i= 0; i < 16 - leng;i++){
                Log += " ";
            }

            Log += "|";
            for (String CheckLine:DataService.myMethodSplit(readFile(file), '\n')) {
                try{
                    if(DataService.similarityString(DataService.myMethodSplit(CheckLine, '┌')[0], DataService.myMethodSplit(Log + Pas, '┌')[0]))
                    {
                        User.isLogin = true;
                        existingAccount = true;
                        System.out.println("Успішна авторизація");
                        break;
                    }
                }catch (Exception ignored){
                }
            }
            if (!existingAccount){
                System.out.println( "Такого гравця немаэ в базі даних!");
            }
            break;
        case 119: //w
            //Реєстрація
            System.out.println("Введіть логін:");
            Log = DataService.ProcessingEnteredMessages("");
            System.out.println("Введіть пароль:");
            Pas = hashing(DataService.ProcessingEnteredMessages(""));

            int lengh = Log.length();
            for(int i= 0; i < 16 - lengh;i++){
                Log += " ";
            }
            Log += "|";
            for (String CheckLine:DataService.myMethodSplit(readFile(file), '\n')) {
                try{
                    if(DataService.similarityString(DataService.myMethodSplit(CheckLine,'┌')[0], DataService.myMethodSplit(Log + Pas,'┌')[0]))
                    {
                        existingAccount = true;
                        break;
                    }

                }catch (Exception ignore){

                }
            }
            if (!existingAccount){
                User.isLogin = true;
                files(Log + Pas);
                System.out.println("Успішна реєстрація");
            }else {
                System.out.println("Такий гравець вже існує в базі даних!");
                break;
            }

            break;
        case 101: //e
            User.desireLeave = true;
            System.out.println("До зустрічі!");
            break;

        default:
            System.out.println("Не коректний вибір!");
            System.out.println("Спробуйте ще раз");
            break;
    }
}
    void files(String textWritten)
    {
        BufferedReader br = null;
        try{
            File file = new File("./resurses/Users.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            String TextFiles = readFile(file);
            writingTextToFile(file, TextFiles, textWritten);
        }catch (IOException e){
            System.out.println("Error: " + e);
        }
    }

    String readFile(File file){
        String textFiles = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null )
            {
                textFiles += line + "\n";
            }

        }catch (IOException e){
                System.out.println("Error: " + e);

        }finally {
            try{
                    br.close();
            }catch (IOException e){
                    System.out.println("Error: " + e);

            }
        }
            return textFiles;
    }

    void writingTextToFile(File file, String pastText, String textWritten){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            String newText =  pastText;
            newText += textWritten;
            pw.write(newText);
            pw.close();

        }catch (IOException e){
            System.out.println("Error: " + e);
        }
    }

    String hashing(String TextToHashed){
        EncryptionMethod encryptionMethod =new EncryptionMethod();
        String Hash = encryptionMethod.HashingProcess(TextToHashed);
        return Hash;
    }

}