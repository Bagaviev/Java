package com.javarush.task.task08.task0818;

import java.util.*;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Bagaviev", 1000);
        map.put("Bogaveev", 999);
        map.put("Ivanov", 500);
        map.put("Petrov", 300);
        map.put("Umbatova", 700);
        map.put("Kiseleva", 100);
        map.put("Bagavieva", 900);
        map.put("Bagava", 200);
        map.put("Baga", 10);
        map.put("Bva", 6666);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> copy = new HashMap<>(map);

        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue() < 500)
                map.remove(pair.getKey()); //важно именно так map.remove(pair) не отработает!
        }
    }

    public static void main(String[] args) {
//        Map<String, Integer> map = createMap();
//        removeItemFromMap(map);
//        for (Map.Entry<String, Integer> pair : map.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
    }
}