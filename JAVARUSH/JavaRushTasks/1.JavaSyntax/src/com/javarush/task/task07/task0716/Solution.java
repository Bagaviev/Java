package com.javarush.task.task07.task0716;

import java.util.ArrayList;
import java.util.ListIterator;

/* 
Р или Л
*/


public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
//        strings.add("роза");
//        strings.add("лоза");
//        strings.add("лира");
        strings.add("роза");
        strings.add("мера");
        strings.add("лоза");
        strings.add("лира");
        strings.add("вода");
        strings.add("упор");

        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).contains("л") & strings.get(i).contains("р"))
                continue;
            if (strings.get(i).contains("л")) {
                    strings.add(i, strings.get(i));
                    i++;
                }
            }

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).contains("р") & !strings.get(i).contains("л")) {
                strings.remove(i);
                i--;
            }
        }
            return strings;
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("роза");
        strings.add("мера");
        strings.add("лоза");
        strings.add("лира");
        strings.add("вода");
        strings.add("упор");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {

        String r = "р";
        String l = "л";

        ArrayList<String> result = new ArrayList<>();
        for (String string : strings) {
            boolean isR = string.contains(r);
            boolean isL = string.contains(l);

            if (isR && !isL) {
                continue;
            }

            if (!isR && isL) {
                result.add(string);
            }

            result.add(string);
        }
        return result;
    }
}
*/


//лоза
//лира
//вода
//лоза