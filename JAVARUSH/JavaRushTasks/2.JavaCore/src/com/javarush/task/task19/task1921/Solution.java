package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    public static SimpleDateFormat dateOFormat = new SimpleDateFormat("dd M yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws IOException, ParseException {
        String line;
        String path = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                String date = line.substring(line.length() - 10).trim();
                String name = line.substring(0, line.length() - date.length()).trim();
                PEOPLE.add(new Person(name, dateOFormat.parse(date)));
            }
        }

        for (Person var: PEOPLE) {
            System.out.println(var.getName() + " " + var.getBirthDate());
        }
    }
}