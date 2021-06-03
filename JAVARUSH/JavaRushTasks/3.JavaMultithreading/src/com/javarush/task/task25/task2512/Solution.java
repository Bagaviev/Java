package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<String> res = new LinkedList<>();
        while (e != null) {
            res.add(0, e.toString());
            e = e.getCause();
        }

//        t.interrupt();   // либо так через рекурсию
//        if (e.getCause() != null) {
//            uncaughtException(t, e.getCause());
//        }
//        System.out.println(e);

        for (String s : res) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
//        new Thread(new Solution()).start();
        new Solution().uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
                                            // ^ вот этот момент ебливый конеш, тут бывает this если сам внешний класс- нить
    }
}