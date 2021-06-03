package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

//D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\tmp.txt

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int fileSize = 0;
        String filename = reader.readLine();
        FileInputStream inStream = new FileInputStream(filename);

        while(inStream.available() >= 1000) {
            byte[] buffer = new byte[inStream.available()];
            int count = inStream.read(buffer);

            System.out.println("Size bytes: " + count);

            filename = reader.readLine();
            inStream = new FileInputStream(filename);
        }

        if(fileSize < 1000) {
            inStream.close();
            throw new DownloadException();
        }
    }

    public static class DownloadException extends Exception {

    }
}
