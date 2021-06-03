package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {

    public static double calculate_mean() throws IOException {

        double sum = 0;
        int cnt = 0;
        double mean = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            double number = Double.parseDouble(reader.readLine());
            if (number != -1) {
                sum += number;
                cnt++;
                mean = sum / cnt;
            }

            if (number == -1)
                return mean;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(calculate_mean());
    }
}