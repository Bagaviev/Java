package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String result = outputStream.toString();

        num1 = Integer.parseInt(result.split(" ")[0]);
        num2 = Integer.parseInt(result.split(" ")[2]);

        System.setOut(consoleStream);

        if (result.contains("+")) {
            System.out.format("%d + %d = %d", num1, num2, num1 + num2);
        } else if (result.contains("-")) {
            System.out.format("%d - %d = %d", num1, num2, num1 - num2);
        } else {
            System.out.format("%d * %d = %d", num1, num2, num1 * num2);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

