package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

// D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\tmp.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        String line;
        int cnt = 0;

        while (fileReader.ready()) {
            String[] strs = fileReader.readLine().split("\\pP|\\s");
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].equals("world"))
                    cnt++;
            }
        }

        System.out.println(cnt);

        reader.close();
        fileReader.close();
    }
}
