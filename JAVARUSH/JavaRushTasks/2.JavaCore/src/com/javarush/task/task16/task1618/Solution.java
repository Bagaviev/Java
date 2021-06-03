package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread tt = new TestThread();
        tt.start();
        Thread.sleep(3000);
        tt.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        public void run() {

            while(!isInterrupted()) {
                System.out.println("TestThread started");

                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    System.out.println("TestThread interrupted");
                    interrupt();
                }
            }
        }
    }
}