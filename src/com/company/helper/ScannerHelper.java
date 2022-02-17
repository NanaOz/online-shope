package com.company.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScannerHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final static Scanner READER = new Scanner(System.in);

   /**
    * метод заставляет вводить только числа
    **/
    public static int getIntFromInput(String text) {
        boolean ifInputError = true;
        int number = 0;
        System.out.print(text);
        while (ifInputError) {    // цикл заставляет вводить только числа, не выводя ошибку InputMismatchException
            if (READER.hasNextInt()) {
                number = READER.nextInt();
                ifInputError = false;
            }
            else {
                System.out.print("An error occurred while trying to enter. Please enter a number! " + text);
                READER.next();
            }
        }
        return number;
    }

    /**
     * @param text пользователь вводит "ДА"
     */
    public static boolean isYes(String text) {
        System.out.print(text);
        String answer = READER.next().toLowerCase().trim().replaceAll("\\p{P}", "");
        return "y".equals(answer) || "yes".equals(answer) || "да".equals(answer);
    }

    /**
     * Закрывает сканнер
     */
    public static void close() {
        READER.close();
    }

    public static String readString(){
        try{
            return bufferedReader.readLine();
        }
        catch (IOException e){
            System.out.println("An error occurred while trying to enter text. Try again.");
            return readString();
        }
    }

    public static int readInt(){
        try{
            return Integer.parseInt(readString());
        }
        catch (NumberFormatException e){
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            return readInt();
        }
    }
}
