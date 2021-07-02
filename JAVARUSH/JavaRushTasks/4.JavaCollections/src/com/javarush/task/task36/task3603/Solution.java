package com.javarush.task.task36.task3603;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
Поиск класса по описанию
*/

public class Solution {
    public static String solution(String[] phone_numbers, String[] phone_owners, String number) {
        String result = new String();

        for (int i = 0; i < phone_numbers.length; i++) {
            if (phone_numbers[i].equals(number)) {
                result = phone_owners[i];
                return result;
            }
            else
                result = number;
        }
        return result;
    }

    public static void main(String... args) {    // This line is correct
        String[] phone_numbers = {"2212", "222", "433"};
        String[] phone_owners = {"bob", "mike", "peter"};
        String number = "4564";

        System.out.println(solution(phone_numbers, phone_owners, number));
        /*
        String result = str + "ede";
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");
        List<String> collection = Arrays.asList("B", "C", "D", "B");
        list.addAllAbsent(collection);

        for (String string : list) {
            System.out.println(string);
        }
        /* Expected output
A
C
B
D
         */
    }
}
