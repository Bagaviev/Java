package com.javarush.task.task37.task3702;

public interface AbstractFactory {      // Abstract Fabric with factoryMethods
    public Human getPerson(int age);   // factoryMethod / фабричный метод
}
