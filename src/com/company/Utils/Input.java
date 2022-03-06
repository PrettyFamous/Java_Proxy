package com.company.Utils;

import java.util.Scanner;

public class Input {
    static Scanner in = new Scanner(System.in);

    /**
     * Ввод целого числа в заданном диапазоне
     */
    public static int inputNum(int min, int max, String msg){
        System.out.print(msg);
        int choice = Integer.parseInt( in.nextLine() );
        while ((choice > max) || (choice < min))
        {
            System.out.println("Ошибка, повторите ввод");
            System.out.println();
            choice = Integer.parseInt( in.nextLine() );
        }

        return choice;
    }

    public static int inputNum(String msg){
        System.out.print(msg);
        int choice = Integer.parseInt( in.nextLine() );

        return choice;
    }
}
