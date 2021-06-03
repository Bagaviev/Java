package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            arr[i] = array[array.length - 1 - i];
        }

        for (int x : arr) {
            System.out.println(x);
        }
    }
}
    //либо так

   /* public static void sort(int[] array) {
        for (int j = array.length - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] < array[i + 1]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }*/
//        не отработало
//        for (int i = 0; i < array.length; i++) {
//            arr[i] = array[array.length - i - 1];