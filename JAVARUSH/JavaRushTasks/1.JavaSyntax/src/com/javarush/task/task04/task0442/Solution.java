package com.javarush.task.task04.task0442;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Суммирование
*/
/*
public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isActive = false;
        int sum = 1;                       //почему а самое главное нахуя?
        while(!isActive) {
            int m = Integer.parseInt(reader.readLine());
            sum += m;
            if (m == -1) {
                --sum;
                System.out.println(sum);
                isActive = true;
            }
        }
    }
}*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        while (true) {
            int number = Integer.parseInt(reader.readLine());
            sum += number;

            if (number == -1) {
                break;
            }
        }
        System.out.println(sum);
    }
}