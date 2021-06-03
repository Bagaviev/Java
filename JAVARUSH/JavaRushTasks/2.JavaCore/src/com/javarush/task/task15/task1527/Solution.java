package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> doubleVar = new ArrayList<String>();
        String testURL = reader.readLine();

//        String testURL = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
//        String testURL = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";

        String[] Spl1 = testURL.split("\\?")[1].split("&");

        for (int i = 0; i < Spl1.length; i++) {
            String[] item = Spl1[i].split("=");
            System.out.print(item[0] + " ");

            if (item[0].contains("obj"))
                doubleVar.add(item[1]);
        }
        System.out.println("");
        if (!doubleVar.isEmpty()) {
            try {
                alert(Double.parseDouble(doubleVar.get(0)));
            } catch (Exception e) {
                alert(doubleVar.get(0));
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
