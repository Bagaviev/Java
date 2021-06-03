package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandPaName = reader.readLine();  //Вася
        Cat grandPa = new Cat(grandPaName);

        String grandBaName = reader.readLine();  //Мурка
        Cat grandBa = new Cat(grandBaName);

        String PaName = reader.readLine();  //Котофей
        Cat Pa = new Cat(grandPa, PaName);

        String MaName = reader.readLine();  //Василиса
        Cat Ma = new Cat(MaName, grandBa);

        String SonName = reader.readLine();  //Мурчик
        Cat Son = new Cat(SonName, Ma, Pa);

        String DauName = reader.readLine();  //Пушинка
        Cat Dau = new Cat(DauName, Ma, Pa);

        System.out.println(grandPa);
        System.out.println(grandBa);
        System.out.println(Pa);
        System.out.println(Ma);
        System.out.println(Son);
        System.out.println(Dau);
    }

    public static class Cat {
        String s = "";
        String ss = new String("");


        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
            this.mother = null;
            this.father = null;
        }

        Cat(String name, Cat mother) {
            this.name = name;
            this.mother = mother;
            this.father = null;
        }

        Cat(Cat father, String name) {
            this.name = name;
            this.mother = null;
            this.father = father;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            if (mother == null & father == null)
                return "The cat's name is " + name + ", no mother, no father";
            else if (mother == null)
                return "The cat's name is " + name + ", no mother" + ", father is " + father.name;
            else if (father == null)
                return "The cat's name is " + name + ", mother is " + mother.name + ", no father";
            else
                return "The cat's name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }
}
