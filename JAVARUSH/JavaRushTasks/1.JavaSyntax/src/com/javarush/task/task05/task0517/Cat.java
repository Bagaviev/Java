package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {

    String name;
    int age;
    int weight;
    String address;
    String color;

    public Cat(String name) {
        this.name = name;
        this.age = 4;
        this.weight = 3;
        this.color = "gray";
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "gray";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 5;
        this.color = "gray";
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.name = null;
        this.address = null;
        this.age = 3;
    }

    public Cat(int weight, String color, String address) {
        this.address = address;
        this.weight = weight;
        this.color = color;
        this.age = 3;
    }

    public static void main(String[] args) {

    }
}
