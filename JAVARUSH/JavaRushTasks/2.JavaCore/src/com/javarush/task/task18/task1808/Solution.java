package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Разделение файла
*/

// D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\test.txt
/*
public class Solution {
    static List<String> files = new ArrayList<String>();

    static {
        int readCnt = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(readCnt < 3) {
            String file = null;
            try {
                files.add(reader.readLine());
                readCnt++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FileInputStream inStream = new FileInputStream(files.get(0));
        FileOutputStream outStream1 = new FileOutputStream(files.get(1));
        FileOutputStream outStream2 = new FileOutputStream(files.get(2));
        int fileSize = inStream.available();
        byte[] buffer = new byte[fileSize];

        while (inStream.available() > 0) {
            int count = inStream.read(buffer);

            if (fileSize % 2 == 0) {
                outStream1.write(buffer, 0, count / 2);
                outStream2.write(buffer, count / 2, count / 2);
            } else {
                outStream1.write(buffer, 0, count / 2 + 1);
                outStream2.write(buffer, count / 2 + 1, count / 2);
            }
        }

        inStream.close();
        outStream1.close();
        outStream2.close();
    }
}
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        String outputFile1 = reader.readLine();
        String outputFile2 = reader.readLine();

        try (FileInputStream fileInputStream = new FileInputStream(inputFile);
             FileOutputStream fileOutputStream1 = new FileOutputStream(outputFile1);
             FileOutputStream fileOutputStream2 = new FileOutputStream(outputFile2)) {

            int halfOfFile = (fileInputStream.available() + 1) / 2;
            int numberOfByte = 0;
            while (fileInputStream.available() > 0) {
                if (numberOfByte < halfOfFile) {
                    fileOutputStream1.write(fileInputStream.read());
                    numberOfByte++;
                } else fileOutputStream2.write(fileInputStream.read());
            }
        }
    }
}
