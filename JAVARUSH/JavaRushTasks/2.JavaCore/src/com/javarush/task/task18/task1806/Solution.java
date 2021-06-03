package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\test.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\test.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\result.txt");

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        inputStream.close();
        outputStream.close();
    }
}
