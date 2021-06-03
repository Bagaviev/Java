package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Проверка на упорядоченность
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        int numRead = 10;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> initList = new ArrayList<>();

        for (int i = 0; i < numRead; i++) {
            initList.add(reader.readLine());
        }

        //Arrays.equals
        //Arrays.toString()
        //Arrays.asList()
        //Arrays.sort(array)
        //Arrays.copy()
        //List.toArray()
        //List.indexOf()
        //Collections.sort(list)

        for (int i = 0; i < initList.size() - 1; i++) {
            if (initList.get(i).length() <= initList.get(i + 1).length()) {
                continue;
            }
            else {
                System.out.println(initList.get(i).length() > initList.get(i + 1).length() ? i + 1 : i);
                break;
            }
        }
    }
}
///// NOT BAD SOLUTION
/*
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String string = reader.readLine();
            strings.add(string);
        }

        String bugString = strings.get(0);

        for (int i = 1; i < 10; i++) {
            if (strings.get(i).length() >= bugString.length()) {
                bugString = strings.get(i);
            } else {
                System.out.println(i);
                break;
            }
        }
    }
}
 */
