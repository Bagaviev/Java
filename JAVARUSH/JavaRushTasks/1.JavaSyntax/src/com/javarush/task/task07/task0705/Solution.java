package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int[] big = new int[20];
        int[] low1 = new int[10];
        int[] low2 = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < big.length ; i++) {
            big[i] = Integer.parseInt(reader.readLine());
        }

        for (int j = 0; j < big.length; j++) {
            if (j < big.length / 2)
                low1[j % low1.length] = big[j];
            else
                low2[j % low1.length] = big[j];
        }


        //print
/*        for (int cnt : big) {
            System.out.print(cnt + " ");
        }

        System.out.println("");

        for (int cnt : low1) {
            System.out.print(cnt + " ");
        }*/

        //System.out.println("");

        for (int cnt : low2) {
            System.out.print(cnt + " ");
        }
    }
}
