package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T obj = (T) objectMapper.readValue(new File(fileName), clazz);
        return obj;
    }

    public static void main(String[] args) throws IOException {
        Person person = convertFromJsonToNormal("JSONFile.json", Person.class);
        System.out.println(person);
    }

    static class Person {
        public int age;
        public String name;

        public Person() {}      // если новый конструктор с параметрами дрочишь, то дрочи и этот явно, иначе еррор

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
