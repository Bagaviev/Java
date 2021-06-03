package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String pathIn = FileTest.filenameIn;
//        String pathOut = FileTest.filenameOut;
        String pathIn = reader.readLine();
        String pathOut = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(pathIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(pathOut));

        while (fileReader.ready()) {
            fileReader.read();                  //  trash
            int symbol = fileReader.read();
            fileWriter.write(symbol);
        }

        fileReader.close();
        fileWriter.close();
    }
}
