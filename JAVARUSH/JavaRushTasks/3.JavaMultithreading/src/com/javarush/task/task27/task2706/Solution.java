package com.javarush.task.task27.task2706;

/* 
Убираем deadlock
*/

public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        Object MaxObj = obj1.hashCode() > obj2.hashCode() ? obj1 : obj2;
        Object MinObj = obj1.hashCode() > obj2.hashCode() ? obj2 : obj1; // System.identityHashCode(toAcct);

        synchronized (MaxObj) {  // вариант ниже изначальный - работал, но валик
            longTimeMethod();
            synchronized (MinObj) {
                unsafeMethod(obj1, obj2);
            }
        }
    }
/*
if (fromHash < toHash) {
		synchronized (fromAcct) {
			synchronized (toAcct) {
				doTransfer(fromAcct, toAcct, amount);
			}
		}
	} else if (fromHash > toHash) {
		synchronized (toAcct) {
			synchronized (fromAcct) {
				doTransfer(fromAcct, toAcct, amount);
 */

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
