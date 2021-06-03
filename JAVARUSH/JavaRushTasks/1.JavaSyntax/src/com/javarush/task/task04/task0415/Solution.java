package com.javarush.task.task04.task0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Правило треугольника
*/

public class Solution {

    public static void is_real(int a, int b, int c) {

        if (a < b + c & b < a + c & c < b + a)
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        is_real(a, b, c);
    }
}