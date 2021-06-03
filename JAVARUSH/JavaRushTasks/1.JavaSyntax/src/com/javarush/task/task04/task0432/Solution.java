package com.javarush.task.task04.task0432;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Хорошего много не бывает
*/

public class Solution {

    public static void printer(String s, int num) {

        int i = 0;
        while (i < num) {
            System.out.println(s);
            i++;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        int num = Integer.parseInt(reader.readLine());
        printer(a, num);
    }
}