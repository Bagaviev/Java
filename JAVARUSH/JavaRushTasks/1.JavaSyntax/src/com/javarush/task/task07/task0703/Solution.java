package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = new String[10];
        int[] ints = new int[10];

        for (int i = 0; i < strs.length ; i++) {
            strs[i] = reader.readLine();
            ints[i] = strs[i].length();
        }

        for (int k: ints) {
            System.out.println(k);
        }
    }
}
