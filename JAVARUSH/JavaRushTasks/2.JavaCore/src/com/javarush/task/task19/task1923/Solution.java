package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        Matcher matcher = null;
//        Pattern pattern = Pattern.compile("\\S*\\d+\\S*");
        Pattern pattern = Pattern.compile(".+[0-9].+");
        List<String> list = new ArrayList<String>();

        while (fileReader.ready()) {
            String[] str = fileReader.readLine().split(" ");

            for (String var: str) {
                matcher = pattern.matcher(var);

                while (matcher.find())
                    list.add(matcher.group());
            }
        }

        for (int i = 0; i < list.size(); i++) {
            fileWriter.write(list.get(i) + " ");
        }

        fileReader.close();
        fileWriter.close();
    }
}

/*
for (String word : splitedLine) {
    if (word.matches(".+[0-9].+")) {
        fileWriter.write(word + " ");
    }
}
 */