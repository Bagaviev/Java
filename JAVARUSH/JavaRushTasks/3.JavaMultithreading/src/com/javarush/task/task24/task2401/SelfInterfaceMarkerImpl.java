package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    public void kek() {
        System.out.println("smth");
    }

    public String printer(String msg) {
        String result = msg + "123";
        return result;
    }
}
