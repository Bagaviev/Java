package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Bagaviev", "Bulat");
        map.put("Bogaveev", "Bulat");
        map.put("Bagaviev", "Boulate");
        map.put("Ivanov", "Ivan");
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Ivan");
        map.put("Petrov", "Vasya");
        map.put("Umbatova", "Marina");
        map.put("Kiseleva", "Marina");
        map.put("Bagavieva", "Marina");
        map.put("Bagava", "Marina");
        map.put("Baga", "Marina");
        map.put("Bva", "Marina");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int cnt = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue() == name)
                cnt++;
        }
        return cnt;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int cnt = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey() == lastName)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        Map<String, String> map = createMap();
//
//        for (Map.Entry<String, String> pair : map.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
//
//        System.out.println(getCountTheSameFirstName(map, "Bogaveev"));
//        System.out.println(getCountTheSameLastName(map, "Bogaveev"));
    }
}
