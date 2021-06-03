package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\1924.txt

/*

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(12, "двенадцать");
        map.put(11, "одиннадцать");
        map.put(10, "десять");
        map.put(9, "девять");
        map.put(8, "восемь");
        map.put(7, "семь");
        map.put(6, "шесть");
        map.put(5, "пять");
        map.put(4, "четыре");
        map.put(3, "три");
        map.put(2, "два");
        map.put(1, "один");
        map.put(0, "ноль");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader filereader = new BufferedReader(new FileReader(reader.readLine()));
        Pattern pattern = Pattern.compile("\\b\\d+\\b");

        while (filereader.ready()) {
            String line = filereader.readLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                int num = Integer.parseInt(matcher.group());
                if (num >= 0 && num <= 12) {
                    line = matcher.replaceFirst(String.valueOf(map.get(num)));
                    matcher = pattern.matcher(line);
                }
            }
            System.out.println(line);
        }
        filereader.close();
        reader.close();
    }
}

*/

//public class Solution {
//    public static Map<Integer, String> map = new HashMap<Integer, String>();
//
//    static {
//        map.put(12, "двенадцать");
//        map.put(11, "одиннадцать");
//        map.put(10, "десять");
//        map.put(9, "девять");
//        map.put(8, "восемь");
//        map.put(7, "семь");
//        map.put(6, "шесть");
//        map.put(5, "пять");
//        map.put(4, "четыре");
//        map.put(3, "три");
//        map.put(2, "два");
//        map.put(1, "один");
//        map.put(0, "ноль");
//    }
//
//    public static void main(String[] args) {
//        String fileName = null;
//
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            fileName = reader.readLine();
//        } catch (IOException ignore) {
//            /* NOP */
//        }
//
//        String fileLine;
//        ArrayList<String> fileContent = new ArrayList<>();
//
//        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
//            while ((fileLine = in.readLine()) != null) {
//                fileContent.add(fileLine);
//            }
//        } catch (IOException ignore) {
//            /* NOP */
//        }
//
//        for (String line : fileContent) {
//            String[] splitedLine = line.split(" ");
//            for (int i = 0; i < splitedLine.length; i++) {
//                for (Map.Entry<Integer, String> entry : map.entrySet()) {
//                    try {
//                        int number = Integer.parseInt(splitedLine[i]);
//                        if (entry.getKey().equals(number))
//                            splitedLine[i] = entry.getValue();
//                    } catch (NumberFormatException ignored) {
//                        /*NOP*/
//                    }
//                }
//            }
//
//            StringBuffer sbLine = new StringBuffer();
//            for (String word : splitedLine) {
//                sbLine.append(word).append(" ");
//            }
//
//            System.out.println(sbLine.toString().trim());
//        }
//    }
//}

public class Solution {

    public static class Person implements Serializable {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return "Age: " + this.age + " Name: " + this.name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person1 = new Person(12, "Masha");
        Person person2 = new Person(24, "Bulat");

        FileOutputStream fos = new FileOutputStream("serializedPerson.bin");
        ObjectOutputStream ous = new ObjectOutputStream(fos);

        ous.writeObject(person1);
        ous.writeObject(person2);

        System.out.println(person1);
        System.out.println(person2);

        FileInputStream fis = new FileInputStream("serializedPerson.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Person person3 = (Person) ois.readObject();
        Person person4 = (Person) ois.readObject();

        System.out.println(person3);
        System.out.println(person4);
    }

}