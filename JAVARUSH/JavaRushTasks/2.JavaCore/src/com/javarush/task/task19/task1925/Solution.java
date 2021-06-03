package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        /*String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        List<String> list = new ArrayList<String>();

        while (fileReader.ready()) {
            String[] str = fileReader.readLine().split(" ");
            for (String var: str) {
                if (var.length() > 6)
                    list.add(var);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1)
                fileWriter.write(list.get(i) + ",");
            else {
                fileWriter.write(list.get(i));
            }
        }

        fileReader.close();
        fileWriter.close();*/

        FileOutputStream fos = new FileOutputStream("test.txt");
        fos.write(124);
        fos.write(49);
        fos.write(51);
        fos.write("lalal".getBytes("UTF-8"));
        fos.flush();
        fos.close();

        FileWriter fw = new FileWriter("test2.txt");
        fw.write(124);
        fw.write('|');
        fw.flush();
        fw.close();
    }
}
