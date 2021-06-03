package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.max;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        System.out.println(NOD(a, b));
    }

    public static int NOD(int a, int b) {   //System.out.println(NOD(24, 18));  // 6
        List<Integer> dels1 = new ArrayList<Integer>();
        List<Integer> dels2 = new ArrayList<Integer>();

        for (int i = a; i > 0; i--) {
            if (a % i == 0)
                dels1.add(i);
        }

        for (int i = b; i > 0; i--) {
            if (b % i == 0)
                dels2.add(i);
        }

        dels1.retainAll(dels2);
        int NOD = Collections.max(dels1);
        return NOD;
    }
}
