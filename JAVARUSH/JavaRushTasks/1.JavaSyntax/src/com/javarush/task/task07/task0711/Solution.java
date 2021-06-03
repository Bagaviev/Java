package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numReads = 5;

        for (int i = 0; i < numReads; i++) {
            strings.add(reader.readLine());
        }

        for (int j = 0; j < 13; j++) {
            strings.add(0, strings.get(4));
            strings.remove(5);
        }

        for (int k = 0; k < strings.size(); k++) {
            System.out.println(strings.get(k));
        }
    }
}
