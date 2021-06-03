package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/* 
Пробелы
*/

//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\result.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            return;

        double matchCnt = 0;
        double allCnt = 0;
        char space = ' ';
        FileInputStream inStream = new FileInputStream(args[0]);

        while (inStream.available() > 0) {
            char check = (char) inStream.read();
            if (check == space)
                matchCnt++;
            allCnt++;
        }
        inStream.close();
        System.out.format("%.2f", (matchCnt / allCnt) * 100);
    }
}

