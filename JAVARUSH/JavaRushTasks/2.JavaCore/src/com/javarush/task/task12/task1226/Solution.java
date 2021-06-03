package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public static void main(String[] args) {

    }

    public interface CanFly {
        void fly();
    }

    public interface CanClimb {
        void climb();
    }

    public interface CanRun {
        void run();
    }

    public class Cat implements CanClimb, CanRun {
        public void climb() {
            System.out.println("climbing like cat...");
        };

        public void run() {
            System.out.println("running like cat...");
        };
    }

    public class Dog implements CanRun {
        public void run() {
            System.out.println("running like dog...");
        };
    }

    public class Tiger extends Cat {
    }

    public class Duck implements CanRun, CanFly{
        public void fly() {
            System.out.println("flying like duck...");
        };

        public void run() {
            System.out.println("running like duck...");
        };
    }
}
