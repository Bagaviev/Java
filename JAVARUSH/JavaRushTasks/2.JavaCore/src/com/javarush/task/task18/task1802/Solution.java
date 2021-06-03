package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

//        D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\test.txt

        FileInputStream inStream = new FileInputStream(filename);
        int min = 128;   // 255

        while (inStream.available() > 0) {
            int current = inStream.read();
            if (current < min)
                min = current;
        }
        System.out.println(min);

        reader.close();
        inStream.close();
    }
}
