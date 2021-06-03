package com.javarush.task.task04.task0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Количество дней в году
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(reader.readLine());

        int days;

        if (year % 400 == 0)
            days = 366;
        else if (year % 100 == 0)
            days = 365;
        else if (year % 4 == 0)
            days = 366;
        else
            days = 365;

        System.out.println("количество дней в году: " + days);
    }
}

/*
public class Solution {

    public static void make_calculations(int year) {

        int days;

        if (year % 400 == 0)
            days = 366;
        else if (year % 100 == 0)
                days = 365;
        else if (year % 4 == 0)
                    days = 366;
        else
            days = 365;

        System.out.println("количество дней в году: " + days);

    }

    public static void main(String[] args) throws Exception {

        System.out.println("Введите год (в разумных пределах):");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(reader.readLine());

        if (year <= 0 && year >= 2200)
            System.out.println("Неправильный диапазон, попробуйте еще раз");
        else
            System.out.println("Making some calculations...");
            Thread.sleep(5000);
            make_calculations(year);
    }
}*/
