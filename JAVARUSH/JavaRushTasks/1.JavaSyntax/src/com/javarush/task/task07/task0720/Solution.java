package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();
        String m = reader.readLine();
//        System.out.println("-------------");
        ArrayList<String> strArr = new ArrayList<String>();

        for (int i = 0; i < Integer.parseInt(n); i++) {
            strArr.add(reader.readLine());
        }

        //Collections.sort(strArr);
        //System.out.println(strArr.toString());

        for (int i = 0; i < Integer.parseInt(m); i++) {
            strArr.add(strArr.get(0));
            strArr.remove(0);
        }

        for (String s: strArr) {
            System.out.println(s);
        }
    }
}
