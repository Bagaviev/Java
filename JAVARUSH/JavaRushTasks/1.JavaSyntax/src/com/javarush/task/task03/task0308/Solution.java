package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {

    static int multiplier() {
        int multiply = 1;
        for (int i = 1; i <= 10; i++) {
            multiply *= i;
        }
        return multiply;
    }
    public static void main(String[] args) {
        System.out.println(multiplier());
        }
}
