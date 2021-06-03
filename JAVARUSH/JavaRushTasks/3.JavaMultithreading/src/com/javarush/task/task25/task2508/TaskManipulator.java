package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(thread.getName());
                Thread.sleep(100);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
//                break;
            }

        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);      //???
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
        start("pp");
    }
}
