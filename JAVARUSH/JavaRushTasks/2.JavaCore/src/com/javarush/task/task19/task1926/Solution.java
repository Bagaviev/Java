package com.javarush.task.task19.task1926;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Перевертыши
*/

//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\1926.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));

        List<StringBuilder> list = new ArrayList<>();

        while (fileReader.ready()) {
            String var = fileReader.readLine();
            list.add(new StringBuilder(var).reverse());
            }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

        reader.close();
        fileReader.close();
    }
}