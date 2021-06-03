package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int numRead = 10;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> initList = new ArrayList<>();

        for (int i = 0; i < numRead; i++) {
            initList.add(reader.readLine());
        }

        ArrayList<String> result = doubleValues(initList);

        for (String str: result) {
            System.out.println(str);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.add(i+1, list.get(i));
            i++;
        }
        return list;
    }
}
