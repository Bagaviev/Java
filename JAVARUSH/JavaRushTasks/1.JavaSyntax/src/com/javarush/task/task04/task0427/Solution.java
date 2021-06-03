package com.javarush.task.task04.task0427;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Описываем числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        String digit = "";
        String evenOdds = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

        if (a >= 1 & a <= 999) {
            int length = (int)(Math.log10(a) + 1);

            switch (length) {
                case 1:
                    digit = "однозначное";
                    break;
                case 2:
                    digit = "двузначное";
                    break;
                case 3:
                    digit = "трехзначное";
                    break;
            }

            if (a % 2 == 0)
                evenOdds = "четное";
            else
                evenOdds = "нечетное";

            System.out.println(evenOdds + " " + digit + " " + "число");
        }
    }
}
