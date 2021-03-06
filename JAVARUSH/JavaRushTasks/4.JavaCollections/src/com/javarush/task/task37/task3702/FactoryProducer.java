package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {
    public enum HumanFactoryType {
        MALE,
        FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType type) {   // фабрика фабрик
        AbstractFactory abstractFactory;
        if (type == HumanFactoryType.MALE)
            abstractFactory = new MaleFactory();
        else
            abstractFactory = new FemaleFactory();
        return abstractFactory;
    }
}
