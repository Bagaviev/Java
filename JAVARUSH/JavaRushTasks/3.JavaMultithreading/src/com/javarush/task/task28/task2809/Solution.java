package com.javarush.task.task28.task2809;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/* 
Plants vs Zombies
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());
        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        final Phaser phaser = new Phaser(characters.size());            // ???

        for (final Character character : characters) {
            final String member = character.toString();
            System.out.println(member + " присоединился к игре");

            new Thread(() -> {
                System.out.println(member + " готовится играть");
                phaser.arriveAndAwaitAdvance();     // пока все треды не дойдут до сюда, ждем

                if (!isEveryoneReady) {
                    isEveryoneReady = true;
                    System.out.println("Игра началась!");
                }

                character.run();
            }).start();
        }
//        phaser.arriveAndDeregister();       // ???
    }
}

/*
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser();
        // Вызывая метод register, мы регистрируем текущий поток (main) как участника
        phaser.register();
        System.out.println("Phasecount is " + phaser.getPhase());
        testPhaser(phaser);
        testPhaser(phaser);
        testPhaser(phaser);
        // Через 3 секунды прибываем к барьеру и снимаемся регистрацию. Кол-во прибывших = кол-во регистраций = пуск
        Thread.sleep(3000);
        phaser.arriveAndDeregister();
        System.out.println("Phasecount is " + phaser.getPhase());
    }

    private static void testPhaser(final Phaser phaser) {
        // Говорим, что будет +1 участник на Phaser
        phaser.register();
        // Запускаем новый поток
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " arrived");
            phaser.arriveAndAwaitAdvance(); //threads register arrival to the phaser.
            System.out.println(name + " after passing barrier");
        }).start();
    }
}
*/