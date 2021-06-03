package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] result = new String[st.countTokens()];
//        String[] result = new String[query.split("\\" + delimiter).length];
        int i = 0;

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            result[i++] = token;
        }

        return result;
    }
}
