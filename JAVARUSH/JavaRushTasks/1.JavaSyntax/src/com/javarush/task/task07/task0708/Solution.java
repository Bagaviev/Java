package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/
/*
public class Solution {
    private static ArrayList<String> strings;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String max_Str = "";

    public static void main(String[] args) throws Exception {

        strings = new ArrayList<String>();

        for (int i = 0; i < 5 ; i++) {
            strings.add(reader.readLine());
        }

        for (int j = 0; j < strings.size(); j++) {
            if (strings.get(j).length() > max_Str.length())
                max_Str = strings.get(j);
        }

        for (int j = 0; j < strings.size(); j++) {
            if (strings.get(j).length() == max_Str.length())
                System.out.println(strings.get(j));
        }
    }
}
*/
// ммм не ебу почему не работает мой вариант. Сделал копипаст

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        strings = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        int maxStringLength = strings.get(0).length();
        for (String string : strings) {
            if (string.length() > maxStringLength) {
                maxStringLength = string.length();
            }
        }

        for (String string : strings) {
            if (string.length() == maxStringLength) {
                System.out.println(string);
            }
        }
    }
}

