package com.javarush.task.task05.task0509;

/* 
Создать класс Friend
*/

public class Friend {

    public String name;
    public int age;
    public char sex;

    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void initialize(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {
        Friend fr1 = new Friend();
        fr1.initialize("leha", 23, 'm');
        System.out.println(fr1.sex + " " + fr1.name + " " + fr1.age);
    }
}
