package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    public static String filename = "";
    private transient FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.filename = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(filename, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("streamSerialize.txt");
        sol.writeObject("message");
        sol.writeObject("message2");

        FileOutputStream fos = new FileOutputStream("streamSave.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(sol);
        sol.close();
        objectOutputStream.close();


        FileInputStream fis = new FileInputStream("streamSave.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);

        Solution sol2 = (Solution) objectInputStream.readObject();

        sol2.writeObject("Данные нового потока.");
        sol2.close();
        objectInputStream.close();
    }
}
