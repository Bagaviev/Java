package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\20\\testTransient.bin";

        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);

        Solution savedObject = new Solution(-5);
        oos.writeObject(savedObject);

        System.out.println(new Solution(-66));

        Solution loadedObject = (Solution) ois.readObject();
        System.out.println(savedObject);
        System.out.println(loadedObject);

        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
