package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        for (String str: list) {
            int cnt = 0;
            for (String strTmp: list) {
                if (str.equals(strTmp))
                    cnt++;
            }
            result.put(str, cnt);
//            result.put("str", 2);
//            result.put("str", 3);
        }
        return result;
    }
//    public static Map<String, Integer> countWords(ArrayList<String> list) {
//        HashMap<String, Integer> result = new HashMap<>();
//
//        for (String word : list) {
//            int count = result.getOrDefault(word, 0);
//            result.put(word, count + 1);
//        }
//
//        return result;
//    }
}

