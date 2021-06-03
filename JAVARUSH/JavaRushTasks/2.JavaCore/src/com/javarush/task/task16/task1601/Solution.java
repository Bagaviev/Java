package com.javarush.task.task16.task1601;

/* 
My first thread
*/

public class Solution {

    public static class TestThread implements Runnable {
        @Override
        public void run() {
            System.out.println("My first thread");
        }
    }

    public static void main(String[] args) {
//        System.out.println("Main thread1");
        TestThread task = new TestThread();
        new Thread(task).start();
//        System.out.println("Main thread2");
    }


}
