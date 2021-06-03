package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\test.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String filename = reader.readLine();
            try (FileInputStream fileInputStream = new FileInputStream(filename)) {

            } catch (FileNotFoundException e) {
                System.out.println(filename);
                break;
            }
        }
    }
}
