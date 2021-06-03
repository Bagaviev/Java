package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = new HashMap<String, String>();

        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }
            String family = reader.readLine();
            map.put(city, family);
        }

//        String cityName = reader.readLine();
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//
//        while (iterator.hasNext()) {
//            Map.Entry<String, String> pair = iterator.next();
//            if (pair.getKey().contains(cityName))
//                System.out.println(pair.getValue());


            String city = reader.readLine();
            if (map.containsKey(city)) {
            String familyName = map.get(city);
            System.out.println(familyName);

        }
    }
}
