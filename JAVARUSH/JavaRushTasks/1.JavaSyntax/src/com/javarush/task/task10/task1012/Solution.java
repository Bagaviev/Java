package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {                  // !!!
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        //подсчет количества букв
        int[] count = new int[alphabet.size()];
        for (String line : list) {
            for (char character : line.toCharArray()) {
                int index = alphabet.indexOf(character);
                if (index < 0) {
                    continue;
                }

                count[index]++;
            }
        }

        //вывод результата
        for (int i = 0; i < alphabet.size(); i++) {
            char character = alphabet.get(i);
            System.out.println(character + " " + count[i]);
        }
    }
}
    //kal
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//
//        for (int i = 0; i < list.size(); i++) {
//
//            List<Character> arrayListFromCharArray = list.get(i).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
//
//            for (int j = 0; j < alphabet.size(); j++) {
//                map.put(alphabet.get(j), Collections.frequency(arrayListFromCharArray, alphabet.get(j)));
//            }
//        }
//
//        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
//    }
//}
