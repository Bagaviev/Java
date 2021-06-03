package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/* 
Функциональности маловато!
*/

/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<String, Integer>();

        while(true) {
            String id = reader.readLine();
            String name = reader.readLine();

            try {
                map.put(name, Integer.parseInt(id));
            } catch (NumberFormatException e) {
                for (Map.Entry<String, Integer> pair : map.entrySet()) {
                    System.out.println(pair.getValue() + " " + pair.getKey());
                }
            }

            if (id.isEmpty() | name.isEmpty()) {
                break;
            }
        }
    }
}*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            String number = reader.readLine();
            if (number.isEmpty()) {
                break;
            }

            int id = Integer.parseInt(number);
            String name = reader.readLine();
            map.put(name, id);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}