package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Писатель в файл с консоли
*/

//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_write\test.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();

//        System.out.println("Enter path where file will be created:");

        String path = reader.readLine();
        OutputStream outStream = new FileOutputStream(path);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream));

//        BufferedWriter writer = new BufferedWriter(new FileWriter(path));  так тоже работает!

//        System.out.println("Enter strings to write ('exit' to stop):");

        while (true) {
            String line = reader.readLine();
            list.add(line);
            if (line.equals("exit")) {
                break;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));             // перезаписывает если что
            writer.newLine();
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}