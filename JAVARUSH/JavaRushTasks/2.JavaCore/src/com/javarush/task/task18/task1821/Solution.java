package com.javarush.task.task18.task1821;

import java.io.*;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args.length == 0)
            return;

        int[] ascii = new int[128];
        FileInputStream fis = new FileInputStream(args[0]);
        byte[] buffer = new byte[fis.available()];

        while(fis.available() > 0) {
            int symbol = fis.read();
            ascii[symbol]++;
        }

        for (int i = 0; i < ascii.length; i++) {
            if (ascii[i] != 0)
                System.out.println((char) i + " " + ascii[i]);
        }

        fis.close();
    }
}
