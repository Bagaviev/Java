package com.javarush.task.task04.task0424;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Три числа
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int[] arr = {a, b, c};
        int index;

        if (arr[0] == arr[1])
            System.out.println(3);
        else if (arr[0] == arr[2])
            System.out.println(2);
        else if (arr[1] == arr[2])
            System.out.println(1);
    }
}
