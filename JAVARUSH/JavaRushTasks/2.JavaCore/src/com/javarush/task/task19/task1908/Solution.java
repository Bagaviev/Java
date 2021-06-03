package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

// D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\regex.txt
// D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\regexResult.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filename2));

        String str = null;
        Matcher matcher = null;
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        List<Integer> list = new ArrayList<Integer>();

        while (fileReader.ready()) {
            str = fileReader.readLine();
            matcher = pattern.matcher(str);
            while (matcher.find())
                list.add(Integer.parseInt(matcher.group()));
        }

        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1)
                fileWriter.write(list.get(i) + " ");
            else
                fileWriter.write(list.get(i) + "");
        }

        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
