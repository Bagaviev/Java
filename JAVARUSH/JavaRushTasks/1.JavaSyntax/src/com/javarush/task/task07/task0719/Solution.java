package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        int numRead = 10;

        for (int i = 0; i < numRead; i++) {
            intArr.add(0, Integer.parseInt(reader.readLine()));
        }

//        сортировка встроенная
//        Object[] intArr2 = intArr.toArray();
//        Arrays.sort(intArr2);

        for (Object o: intArr ) {
            System.out.println(o);
        }
    }
}
