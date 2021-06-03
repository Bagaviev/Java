package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {

    //  D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\test.txt

    public static void main(String[] args) throws IOException {
        char commaValue = 44;
        int commaCnt = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename = reader.readLine();
        FileInputStream inStream = new FileInputStream(filename);
        while(inStream.available() > 0) {
            if(inStream.read() == commaValue)
                commaCnt++;
        }

        System.out.println(commaCnt);
        inStream.close();
    }
}
