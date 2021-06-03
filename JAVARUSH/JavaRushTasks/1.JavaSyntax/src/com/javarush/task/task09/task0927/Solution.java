package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("Barsik1", new Cat("Barsik"));
        map.put("Barsik2", new Cat("Barsi"));
        map.put("Barsik3", new Cat("Barsi"));
        map.put("Barsik4", new Cat("Barsik"));
        map.put("Barsik5", new Cat("Barsk"));
        map.put("Barsik6", new Cat("Baik"));
        map.put("Barsik7", new Cat("Barsik"));
        map.put("Barsik8", new Cat("rsik"));
        map.put("Barsik9", new Cat("arsik"));
        map.put("Barsik10", new Cat("Bsik"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> set = new HashSet<>(map.values());
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
