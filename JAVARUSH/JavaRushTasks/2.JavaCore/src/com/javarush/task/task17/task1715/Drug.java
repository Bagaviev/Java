package com.javarush.task.task17.task1715;

public class Drug {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public synchronized void setDescription(String description) {
        this.description = description;
    }
}
