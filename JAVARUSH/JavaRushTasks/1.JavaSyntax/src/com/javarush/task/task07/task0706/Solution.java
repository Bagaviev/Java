package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        int oddSum = 0;
        int evenSum = 0;
        int[] broadway = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < broadway.length ; i++) {
            broadway[i] = Integer.parseInt(reader.readLine());
        }

        for (int j = 0; j < broadway.length; j++) {
            if (j % 2 == 0)
                evenSum += broadway[j];
            else
                oddSum += broadway[j];
        }

        System.out.println(oddSum > evenSum ? "В домах с нечетными номерами проживает больше жителей." : "В домах с четными номерами проживает больше жителей.");
    }
}
