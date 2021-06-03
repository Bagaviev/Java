package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String result = null;

        try {
            String[] str = string.split(" ");
            result = str[1] + " " + str[2] + " " + str[3] + " " + str[4];
            //return String.format("%s %s %s %s", arr[1], arr[2], arr[3], arr[4]);

        } catch (Exception e) {
            throw new TooShortStringException("Error short!");
        }

        return result;
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException(String s) {
        }
    }

    /*
    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] splitWithSpaces = string.split(" ");

        if (splitWithSpaces.length < 5) throw new TooShortStringException();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < 5; i++) {
            stringBuilder.append(splitWithSpaces[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
     */
}
