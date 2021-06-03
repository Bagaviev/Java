package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

// D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\test.txt

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFilename = reader.readLine();
        String outFilename = reader.readLine();
        FileInputStream inStream = new FileInputStream(inFilename);
        FileOutputStream outStream = new FileOutputStream(outFilename);
        byte[] buffer = new byte[inStream.available()];

        while (inStream.available() > 0) {
            int count = inStream.read(buffer);

            System.out.println(Arrays.toString(buffer));

            for (int i = buffer.length - 1; i >= 0; i--) {
                outStream.write(buffer[i]);
            }
        }

        inStream.close();
        outStream.close();
    }
}
