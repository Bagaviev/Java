package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        double usd1 = convertEurToUsd(12, 1.21);
        double usd2 = convertEurToUsd(13, 1.21);
        System.out.println(usd1);
        System.out.println(usd2);
    }

    public static double convertEurToUsd(int eur, double exchangeRate) {
        return eur * exchangeRate;
    }
}
