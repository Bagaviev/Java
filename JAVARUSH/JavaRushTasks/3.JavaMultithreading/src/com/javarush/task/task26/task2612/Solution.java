package com.javarush.task.task26.task2612;

import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/

public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {

        try {
            if(lock.tryLock()) {
                actionIfLockIsFree();
                lock.unlock();
            } else
                actionIfLockIsBusy();
        } catch (Exception e) {
            lock.unlock();
            e.printStackTrace();
        }
            // more readable
        /*
               if (lock.tryLock()) {
            try {
                actionIfLockIsFree();
            } finally {
                lock.unlock();
            }
        } else {
            actionIfLockIsBusy();
        }
         */
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}