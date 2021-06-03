package com.javarush.task.task35.task3512;

/* 
Генератор объектов
*/
// изза того что стираются типы дженериков, создать объекты такие можно только так, сохряняя их в поле класса
// generic object instance
public class Solution {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Generator<Event> eventGenerator = new Generator<>(Event.class);

        System.out.println(eventGenerator.newInstance().getId());
        System.out.println(eventGenerator.newInstance().getId());
        System.out.println(eventGenerator.newInstance().getId());
    }

}
