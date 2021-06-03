package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {

    public static class AmigoThreadFactory implements ThreadFactory {
        private static final AtomicInteger factoryNum = new AtomicInteger(1);
        private final AtomicInteger threadNum = new AtomicInteger(1);
        private final ThreadGroup group;
        private String prefix;

        public AmigoThreadFactory() {
            group = Thread.currentThread().getThreadGroup();
            prefix = "" + factoryNum.getAndIncrement();
        }

        @Override
        public Thread newThread(Runnable r) {

            Thread newThread = new Thread(group, r
                , group.getName() + "-pool-" + prefix + "-thread-" + threadNum.getAndIncrement());  // с положением getAndIncrement аккуратнее отдельной строкой не работает норм

            if (newThread.isDaemon())
                newThread.setDaemon(false);
            if (newThread.getPriority() != Thread.NORM_PRIORITY)
                newThread.setPriority(Thread.NORM_PRIORITY);

            return newThread;
        }
    }

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
