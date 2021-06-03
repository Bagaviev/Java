package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();
    static String ad = "JavaRush - курсы Java онлайн\n";
    static StringBuilder stringBuilder = new StringBuilder();
    static int adCnt;

    public static void main(String[] args) {
        PrintStream realStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream myStream = new PrintStream(byteArrayOutputStream);
        System.setOut(myStream);

        testString.printSomething();
        char[] chars = byteArrayOutputStream.toString().toCharArray();

        System.setOut(realStream);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\n')
                adCnt++;

            stringBuilder.append(chars[i]);

            if (adCnt == 2) {
                stringBuilder.append(ad);
                adCnt = 0;
            }
        }

        System.out.println(stringBuilder.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
