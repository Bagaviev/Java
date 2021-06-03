package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        //threads.add(new Endless());   //nothing to test
        //threads.add(new IntrptExc());
        //threads.add(new Hooray());    //tested
        threads.add(new WarnStop());    //tested
        //threads.add(new Reader());    //tested
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }

/*
        Thread instance = threads.get(0);
        System.out.println(instance.isAlive());
        instance.join();
        System.out.println(instance.isAlive());
*/
        System.out.println(threads.get(0).isAlive());
        Thread.sleep(3000);
        WarnStop instance = (WarnStop) threads.get(0);
//        instance.interrupt();   // OK
        instance.showWarning();   // OK
        Thread.sleep(500);
        System.out.println(threads.get(0).isAlive());
    }

    public static class Endless extends Thread {
        boolean currentINTR = currentThread().isInterrupted();
        @Override
        public void run() {
            while (!currentINTR) {}
        }
    }

    public static class IntrptExc extends Thread {
        boolean currentINTR = currentThread().isInterrupted();
        @Override
        public void run() {
            if (true) {
                try {
                    throw new InterruptedException("InterruptedException");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static class Hooray extends Thread {
        boolean currentINTR = currentThread().isInterrupted();
        @Override
        public void run() {
            while (!currentINTR) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public static class WarnStop extends Thread implements Message {
        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            while (!currentThread().isInterrupted()) {}
        }
    }

    public static class Reader extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;

        @Override
        public void run() {
            int sum = 0;

            try {
                while(!(key = reader.readLine()).equals("N")) {
                    int val = Integer.parseInt(key);
                    sum += val;
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}