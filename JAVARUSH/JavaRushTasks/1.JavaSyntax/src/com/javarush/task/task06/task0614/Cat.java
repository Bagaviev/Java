package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {

    public static int cnt = 0;
    public static ArrayList<Cat> cats = new ArrayList<Cat>();

    public Cat() {
        cnt++;
        //System.out.println("Cat " + cnt + " was created!");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Cat newCat = new Cat();
            cats.add(newCat);
        }
        printCats();
    }

    public static void printCats() {
        for (Cat someCat: cats) {
            System.out.println(someCat);
        }
    }
}
