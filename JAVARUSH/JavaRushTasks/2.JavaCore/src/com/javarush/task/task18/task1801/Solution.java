package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\test.txt

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

//        InputStream inStream = new FileInputStream(path);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
//        BufferedReader reader = new BufferedReader(new FileReader(path))

        FileInputStream inStream = new FileInputStream(filename);
        int max = 0;

        while (inStream.available() > 0) {
            int current = inStream.read();
            if (current > max)
                max = current;
        }
        System.out.println(max);

        reader.close();
        inStream.close();
    }
}
