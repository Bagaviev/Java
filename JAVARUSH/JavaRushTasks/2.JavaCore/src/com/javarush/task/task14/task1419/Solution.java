package com.javarush.task.task14.task1419;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {
        try {                               // 1
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                               // 2
            int[] ints = new int[1];
            ints[1] = 3;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                               // 3
            BufferedReader reader = new BufferedReader(new FileReader("cwed"));
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                               // 4
            String s = "j";
            Integer i = Integer.parseInt(s);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                               // 5
            Object obj = null;
            obj.toString();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                               // 6
            int num = -3;
            if (num < 0) throw new IllegalArgumentException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                               // 7
            int num = -3;
            if (num < 0) throw new NoSuchMethodException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                               // 8
            int num = -3;
            if (num < 0) throw new IllegalAccessException();
        } catch (Exception e) {
            exceptions.add(e);
        }

         try {                               // 9
             int num = -3;
             if (num < 0) throw new EOFException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                               // 10
            int num = -3;
            if (num < 0) throw new ClassNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
