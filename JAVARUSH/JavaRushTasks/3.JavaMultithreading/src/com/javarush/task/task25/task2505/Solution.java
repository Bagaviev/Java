package com.javarush.task.task25.task2505;

/* 
Без дураков
*/

import com.javarush.task.task29.task2909.human.Student;

import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    /*
    public Student getStudentWithMaxAverageGrade() {
        Student goodBoi = Collections.max(students, (o1, o2) -> (int) (o1.getAverageGrade() - o2.getAverageGrade()));
        return goodBoi;
    */

    public class MyThread extends Thread {

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            public MyUncaughtExceptionHandler() {}

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                    String format = "%s, %s, %s";
                    System.out.println(String.format(format, secretKey, t.getName(), e.getMessage()));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }

        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//            setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
    }

}

