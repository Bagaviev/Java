package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse: horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse: horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double max = 0;
        Horse maxH = null;

        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > max) {
                max = horses.get(i).getDistance();
                maxH = horses.get(i);
            }
        }
        return maxH;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());
        game.horses.add(new Horse("Старая кляча", 3, 0));
        game.horses.add(new Horse("Молния", 3, 0));
        game.horses.add(new Horse("Стероидная мразь", 3, 0));
        game.run();
        game.printWinner();
    }
}
