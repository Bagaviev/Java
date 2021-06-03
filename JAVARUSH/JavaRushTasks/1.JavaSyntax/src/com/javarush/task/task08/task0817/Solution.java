package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Bagaviev", "Bulat");
        map.put("Bogaveev", "Bulat");
        map.put("Ivanov", "Ivan");
        map.put("Petrov", "Vasya");
        map.put("Umbatova", "Marina");
        map.put("Kiseleva", "Marina");
        map.put("Bagavieva", "Marina");
        map.put("Bagava", "Marina");
        map.put("Baga", "Marina");
        map.put("Bva", "Marina");
        return map;
    }

    //right solution (but hard)
    /*
    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copy = new HashMap<>(map);
        for (String name : copy.values()) {
            int count = 0;
            for (String nameTmp : map.values()) {
                if (nameTmp.equals(name)) {
                    count++;
                }
            }
            if (count > 1) {
                removeItemFromMapByValue(map, name);
            }
        }
    }
    */

    //tip comments solution (can be done with previous method in 0815)
    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        List<String> names = new ArrayList<String>(map.values());

        for (String name_to_check : names) {
            if (Collections.frequency(names, name_to_check) > 1)
                removeItemFromMapByValue(map, name_to_check);
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        Map<String, String> map = createMap();
//        removeTheFirstNameDuplicates(map);
//
//        for (Map.Entry<String, String> pair : map.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
    }
}
