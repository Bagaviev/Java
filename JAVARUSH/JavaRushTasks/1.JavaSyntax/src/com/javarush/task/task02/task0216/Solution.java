package com.javarush.task.task02.task0216;

/* 
Минимум трёх чисел
*/

public class Solution {
    public static int min(int a, int b, int c) {
        int arr[] = {a, b, c};
        int current_min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(current_min > arr[i])
                current_min = arr[i];
            else
                continue;
        }
        return current_min;
    }

    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}
