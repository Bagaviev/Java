package com.javarush.task.task18.task1820;

import com.javarush.task.task18.task1819.FileTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader filerReader = new BufferedReader(new FileReader(FileTest.filenameIn));
        BufferedReader filerReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        String[] chars = new String[0];
        char space = ' ';

        while (filerReader.ready()) {
            String str = filerReader.readLine();
            chars = str.split(" ");
        }

        long[] numbers = new long[chars.length];
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = Math.round(Double.valueOf(chars[i]));
        }

        for (int i = 0; i < numbers.length; i++) {
            fileWriter.write(String.valueOf(numbers[i]));
            fileWriter.write(space);
        }

        filerReader.close();
        fileWriter.close();
    }
}

