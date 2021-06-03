package com.javarush.task.task04.task0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переходим дорогу вслепую
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(reader.readLine());

        double period = t % 5;
        if (period >= 0 & period < 3)
            System.out.println("зелёный");
        else if (period >= 3 & period < 4)
            System.out.println("жёлтый");
        else
            System.out.println("красный");
    }
}