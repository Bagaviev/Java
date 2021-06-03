package com.javarush.task.task32.task3204;

import java.io.*;
import java.util.*;
// для рандомного типа (0,1,2) выбрать из мапы срез этого типа и оттуда рандомный символ
// далее заново сначала выбрать тип потом симв так 8 раз

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = getRawPwd().getBytes();
        baos.write(bytes, 0, bytes.length);
        return baos;
    }

    public static String getRawPwd() {
        StringBuilder pwd = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            pwd.append(getRandomChar()); //        System.out.println(pwd.toString());
        }

        for (int j = 0; j < 3; j++) {
            pwd.append(getRandomChar(j));
        }

        List<String> list = Arrays.asList(pwd.toString().split(""));
        Collections.shuffle(list);
        String result = "";

        for (String item : list) {
            result += item;
        }

//        System.out.println(pwd.toString());
        return result;
    }

    public static Character getRandomChar() {
        Map<Integer, Map<Character, Integer>> symbols = getSymbols();
        List<Character> subset = new ArrayList<>();
        int typeNum = getRandom(3);
        int ch = 0;

        Iterator<Map.Entry<Integer, Map<Character, Integer>>> iterator = symbols.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Map<Character, Integer>> pair = iterator.next();
            Map<Character, Integer> value = pair.getValue();

            if (value.values().contains(typeNum)) {
                for (Character c : value.keySet()) {
                    subset.add(c);
                }
            }
        }
        ch = getRandom(subset.size());   //        System.out.println("Rand item: " + subset.get(ch) + " Num: " + ch);
        return subset.get(ch);
    }

    public static Character getRandomChar(int bucket) {
        Map<Integer, Map<Character, Integer>> symbols = getSymbols();
        List<Character> subset = new ArrayList<>();
        int ch = 0;

        Iterator<Map.Entry<Integer, Map<Character, Integer>>> iterator = symbols.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Map<Character, Integer>> pair = iterator.next();
            Map<Character, Integer> value = pair.getValue();

            if (value.values().contains(bucket)) {
                for (Character c : value.keySet()) {
                    subset.add(c);
                }
            }
        }
        ch = getRandom(subset.size());   //        System.out.println("Rand item: " + subset.get(ch) + " Num: " + ch);
        return subset.get(ch);
    }

    public static Map<Integer, Map<Character, Integer>> getSymbols() {
        Map<Integer, Map<Character, Integer>> chars = new HashMap<>();
        Map<Character, Integer> innerMap;

        for (int i = 0; i <= 255; i++) {
            if ((i >= 48 & i <= 57)) {          // Digits
                innerMap = new HashMap<>();
                innerMap.put((char) i, 0);
                chars.put(i, innerMap);
            } else if ((i >= 65 & i <= 90)) {     // UpperSym
                innerMap = new HashMap<>();
                innerMap.put((char) i, 1);
                chars.put(i, innerMap);
            } else if ((i >= 97 & i <= 122)) {  // LowerSym
                innerMap = new HashMap<>();
                innerMap.put((char) i, 2);
                chars.put(i, innerMap);
            }
        }
        return chars;
    }

    public static int getRandom (int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}


/*
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        //incorrect generation
        ByteArrayOutputStream is = new ByteArrayOutputStream();
        Basket[] baskets = new Basket[3];
        baskets[0] = new Basket('0', '9');
        baskets[1] = new Basket('a', 'z');
        baskets[2] = new Basket('A', 'Z');
        int i = 0;
        for (; i < 5; i++) {
            int index = (int) (Math.random() * 3);
            generateChar(is, baskets, index);
        }
        for (int j = 0; j < baskets.length; j++) {
            if (!baskets[j].isSelected()) {
                generateChar(is, baskets, j);
                i++;
            }
        }

        while (i < 8) {
            int index = (int) (Math.random() * 3);
            generateChar(is, baskets, index);
            i++;
        }
        return is;
    }

    private static void generateChar(ByteArrayOutputStream is, Basket[] baskets, int index) {
        Basket basket = baskets[index];
        is.write((char) basket.getRandom());
    }

    public static class Basket {
        int begin;
        int quantity;
        boolean selected;

        private Basket(char begin, char end) {
            this.begin = begin;
            this.quantity = end - begin;
        }

        public int getRandom() {
            return (int) (Math.random() * quantity) + begin;
        }

        public boolean isSelected() {
            return selected;
        }
    }
}
*/