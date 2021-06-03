package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\test.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        byte[] buffer1 = new byte[fileInputStream1.available()];
        byte[] buffer2 = new byte[fileInputStream2.available()];

        while (fileInputStream1.available() > 0)
            fileInputStream1.read(buffer1);

        while (fileInputStream2.available() > 0)
            fileInputStream2.read(buffer2);

        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1);
        fileOutputStream1.write(buffer2);
        fileOutputStream1.write(buffer1);

        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream1.close();
    }
}
