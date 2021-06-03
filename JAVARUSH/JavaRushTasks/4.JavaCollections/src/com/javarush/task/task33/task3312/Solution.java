package com.javarush.task.task33.task3312;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/* 
Сериализация зоопарка
*/

public class Solution {
    public static void main(String[] args) throws JsonProcessingException {
        Zoo.Dog dog = new Zoo.Dog("doggy");
        Zoo.Cat cat = new Zoo.Cat("catty");
        Zoo zoo = new Zoo();
        zoo.animals.add(dog);
        zoo.animals.add(cat);

        String result = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(zoo);

        System.out.println(result);
    }
}

/*
{
  "animals" : [ {
    "className" : "com.javarush.task.task33.task3312.Zoo$Dog",
    "name" : "doggy",
    "barkVolume" : 0.0
  }, {
    "className" : "com.javarush.task.task33.task3312.Zoo$Cat",
    "name" : "catty",
    "lives" : 0
  } ]
}
 */