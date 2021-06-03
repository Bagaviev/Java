package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/

class WorkerThread extends Thread {

    public WorkerThread() {
        // When false, (i.e. when it's a non daemon thread),
        // the WorkerThread continues to run.
        // When true, (i.e. when it's a daemon thread),
        // the WorkerThread terminates when the main
        // thread or/and user defined thread(non daemon) terminates.
        setDaemon(true);
    }

    public void run() {
        int count = 0;

        while (true) {
            System.out.println("Hello from Worker "+count++);

            try {
                sleep(5000);
            } catch (InterruptedException e) {
            }
        }
    }
}

/*
public class Solution {
    public enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            HashSet<Wheel> tmpShit = new HashSet<>();
            String[] result = loadWheelNamesFromDB();

            if (result.length != 4)
                throw new IllegalArgumentException();

            for (int i = 0; i < result.length; i++) {
//                if (Wheel.values()[i].toString().equals(result[i]))
                    tmpShit.add(Wheel.valueOf(result[i]));
//                else
//                    throw new IllegalArgumentException();
            }

            wheels = new ArrayList<>(tmpShit);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.wheels.toString());
    }
}
*/