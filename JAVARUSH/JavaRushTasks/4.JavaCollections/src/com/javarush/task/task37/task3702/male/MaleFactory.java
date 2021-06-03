package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {
    public Human getPerson(int age) {   // factoryMethod / фабричный метод
        Human human;
        // logic changed
            human = new KidBoy();
            human = new TeenBoy();
            human = new Man();
        return human;
    }
}
