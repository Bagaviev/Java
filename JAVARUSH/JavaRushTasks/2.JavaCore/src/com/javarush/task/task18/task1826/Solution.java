package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int salt = 10;
        String mode = args[0];
        String fileFrom = args[1];
        String fileTo = args[2];
        FileInputStream inStream = new FileInputStream(fileFrom);
        FileOutputStream outStream = new FileOutputStream(fileTo);

        if (mode.equals("-e")) {
            while (inStream.available() > 0) {
                int data = inStream.read();
                outStream.write(data + salt);
            }
        } else if (mode.equals("-d")) {
            while (inStream.available() > 0) {
                int data = inStream.read();
                outStream.write(data - salt);
            }
        } else
            System.out.println("Incorrect parameters");

        inStream.close();
        outStream.close();
    }

}
