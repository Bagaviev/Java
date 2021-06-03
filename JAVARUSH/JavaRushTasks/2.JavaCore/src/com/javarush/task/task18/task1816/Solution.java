package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\result.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            return;

        int matchCnt = 0;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        FileInputStream inStream = new FileInputStream(args[0]);

        while (inStream.available() > 0) {
            char check = (char) inStream.read();

            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == check)
                    matchCnt++;
            }
        }
        inStream.close();
        System.out.println(matchCnt);
    }
}
