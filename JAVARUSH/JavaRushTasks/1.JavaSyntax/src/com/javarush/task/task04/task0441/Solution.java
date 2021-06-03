package com.javarush.task.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как-то средненько
*/

public class Solution {

    public static void printer(int[] arr) {

        for (int r : arr) {
            System.out.print(r + " ");
        }
        System.out.println("");
    }

    public static int[] sort_asc(int[] arr) {

        int tmp = 0;
        for (int j = arr.length - 1; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                    }
                }
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++) {
            int inp = Integer.parseInt(reader.readLine());
            arr[i] = inp;
        }

         //Solution.printer(arr);
        int[] sorted_arr = Solution.sort_asc(arr);
         //Solution.printer(sorted_arr);

        System.out.println(sorted_arr[1]);
    }
}

/*
n2 n1 n3
n3 n1 n2

n1 n2 n3
n3 n2 n1

n1 n3 n2
n2 n3 n1

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        int number2 = Integer.parseInt(reader.readLine());
        int number3 = Integer.parseInt(reader.readLine());

        if ((number1 >= number2 && number1 <= number3) || (number1 <= number2 && number1 >= number3)) {
            System.out.println(number1);
        } else if ((number2 >= number1 && number2 <= number3) || (number2 <= number1 && number2 >= number3)) {
            System.out.println(number2);
        } else {
            System.out.println(number3);

 */