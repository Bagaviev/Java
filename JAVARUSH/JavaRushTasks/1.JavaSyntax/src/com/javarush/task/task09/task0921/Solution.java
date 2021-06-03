package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    static List<Integer> ints = new ArrayList<>();

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                ints.add(Integer.parseInt(reader.readLine()));
            }
            catch (NumberFormatException e) {
                for (Integer num : ints) {
                    System.out.println(num);
                }
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
