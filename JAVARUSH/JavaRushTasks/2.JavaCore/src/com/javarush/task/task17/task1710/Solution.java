package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateIFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat dateOFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

/*
    -c name sex bd
    -u id name sex bd
    -d id
    -i id
 */


    public static void main(String[] args) throws IOException, ParseException {
        if (args == null || args.length < 1)
            throw new RuntimeException();

        if(args[0].contains("-c")) {
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], dateIFormat.parse(args[3])));
                System.out.println(allPeople.size() - 1);
            } else if (args[2].equals("ж")) {
                allPeople.add(Person.createFemale(args[1], dateIFormat.parse(args[3])));
                System.out.println(allPeople.size() - 1);
            } else {
                System.out.println("Неверный пол");
//                System.out.println(args[2] == "ж");  hmmm
            }
        } else if (args[0].contains("-u")) {
            if (args[3].equals("м"))
                updateList(Integer.parseInt(args[1]), args[2], Sex.MALE, dateIFormat.parse(args[4]));
            else if (args[3].equals("ж"))
                updateList(Integer.parseInt(args[1]), args[2], Sex.FEMALE, dateIFormat.parse(args[4]));
            else
                System.out.println("Неверный пол");
        } else if (args[0].contains("-d")) {
            removeList(Integer.parseInt(args[1]));
        } else if (args[0].contains("-i")) {
            printList(Integer.parseInt(args[1]));
        } else
            System.out.println("Неверный формат");

//        printList(allPeople.size() - 1);
    }

    public static void printList(int id) {
        if (allPeople.get(id).getSex() == Sex.MALE)
            System.out.println(allPeople.get(id).getName() + " м " + dateOFormat.format(allPeople.get(id).getBirthDate()));
        else if (allPeople.get(id).getSex() == Sex.FEMALE)
            System.out.println(allPeople.get(id).getName() + " ж " + dateOFormat.format(allPeople.get(id).getBirthDate()));
        else
            System.out.format("%d, %s, %s, %s", id, null, null, null);
    }

    public static void updateList(int id, String name, Sex sex, Date birthDate) {
        allPeople.get(id).setName(name);
        allPeople.get(id).setSex(sex);
        allPeople.get(id).setBirthDate(birthDate);
    }

    public static void removeList(int id) {
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDate(null);
    }
}

/*
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


    public static void main(String[] args) throws Exception {
        if (args == null || args.length < 1)
            throw new RuntimeException();

        Date birthdayDate = new Date();
        Person person;
        switch (args[0]) {
            case "-c":
                birthdayDate = simpleDateFormat.parse(args[3]);

                if (args[2].equals("м"))
                    person = Person.createMale(args[1], birthdayDate);
                else
                    person = Person.createFemale(args[1], birthdayDate);

                allPeople.add(person);
                System.out.println(allPeople.size() - 1);
                break;
            case "-u":
                birthdayDate = simpleDateFormat.parse(args[4]);
                int id = Integer.parseInt(args[1]);
                person = allPeople.get(id);
                if (person == null)
                    throw new IllegalArgumentException();
                person.setSex(getSex(args[3]));
                person.setBirthDate(birthdayDate);
                person.setName(args[2]);
                allPeople.set(id, person);
                break;
            case "-d":
                Person currentPerson = allPeople.get(Integer.valueOf(args[1]));
                currentPerson.setName(null);
                currentPerson.setSex(null);
                currentPerson.setBirthDate(null);
                break;
            case "-i":
                person = allPeople.get(Integer.parseInt(args[1]));
                if (person != null)
                    System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + simpleDateFormat2.format(person.getBirthDate()));
                break;
        }

    }

    private static Sex getSex(String sexParam) {
        return sexParam.equals("м") ? Sex.MALE : Sex.FEMALE;
    }
}
*/