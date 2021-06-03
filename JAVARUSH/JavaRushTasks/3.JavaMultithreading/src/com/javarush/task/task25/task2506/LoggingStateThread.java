package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        State newState;
        State currentState = target.getState();
        System.out.println(currentState);

        while (!currentState.equals(State.TERMINATED)) {
            if ((newState = target.getState()) != currentState) {
                currentState = newState;
                System.out.println(currentState);
            }
        }
    }
}
