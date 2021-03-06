package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

/*
    public static String recursion(int a, int b) {    // рекурсия
        if (a > b) {
            return a + " " + recursion(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + recursion(a + 1, b);
        }
    }
*/

    public static String getAllNumbersBetween(int a, int b) {
        String result = new String();
        if (a < b) {
            for (int i = a; i <= b; i++)
                result += i + " ";
        } else {
            for (int i = a; i >= b; i--)
                result += i + " ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
//        System.out.println(recursion(numberA, numberB));
//        System.out.println(recursion(numberB, numberA));

        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}