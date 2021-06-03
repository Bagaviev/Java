package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {    // Compact way without external class
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error)
                    System.out.println("Нельзя дальше работать");
                else if (e instanceof Exception)
                    System.out.println("Надо обработать");
                else {
                    System.out.println("Поживем - увидим");
                }
            }
        });
//        this.setUncaughtExceptionHandler((t, e) -> {        // lambda auto cool method for functional class
//            if (e instanceof Error)
//                System.out.println("Нельзя дальше работать");
//            else if (e instanceof Exception)
//                System.out.println("Надо обработать");
//            else {
//                System.out.println("Поживем - увидим");
//            }
//        });
//        this.start();
    }

    @Override
    public void run() {
        throw new IllegalArgumentException();
    }
//        throw new OutOfMemoryError();
//        throw new Throwable();  // это не удалось пробросить наверх
//        throw new IllegalArgumentException();

    public static void main(String[] args) {
//        new Solution();
    }
}
