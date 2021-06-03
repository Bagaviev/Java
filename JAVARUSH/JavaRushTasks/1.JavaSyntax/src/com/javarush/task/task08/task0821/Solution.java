package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> map = new HashMap<String, String>();
//        map.put("Багавиев", "Булат");
//        map.put("Багавиев", "Иван");
//        map.put("Иванов", "Петр");
        map.put("Ссаная", "Тряпка");
        map.put("Калечная", "Тряпка");
        map.put("Красавов", "Булат");
        map.put("Красаво", "Булат");
        map.put("Красав", "Булат");
        map.put("Умбатова", "Марина");
        map.put("Маринова", "Умбат");
        map.put("Кеков", "Петр");
        map.put("Кеков", "Кек");
        map.put("Багавиев", "Булат");
        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
