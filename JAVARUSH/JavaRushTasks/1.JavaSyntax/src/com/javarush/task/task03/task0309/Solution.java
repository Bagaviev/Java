package com.javarush.task.task03.task0309;

/* 
Сумма 5 чисел
*/

public class Solution {

    static void summarize() {

        int val = 0;
        for(int i = 1; i <= 5; i++) {
            val += i;
            System.out.println(val);
        }
    }

    public static void main(String[] args) {
        summarize();
    }
}
