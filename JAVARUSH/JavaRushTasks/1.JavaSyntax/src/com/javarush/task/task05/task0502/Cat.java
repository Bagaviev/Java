package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {

        int this_cnt = 0;
        int opp_cnt = 0;

        if (this.age > anotherCat.age)
            this_cnt++;
        else if (this.age == anotherCat.age) {
            this_cnt++;
            opp_cnt++;
        }
        else
            opp_cnt++;

        if (this.weight > anotherCat.weight)
            this_cnt++;
        else if (this.weight ==anotherCat.weight) {
            this_cnt++;
            opp_cnt++;
        }
        else
            opp_cnt++;

        if (this.strength > anotherCat.strength)
            this_cnt++;
        else if (this.strength == anotherCat.strength) {
            this_cnt++;
            opp_cnt++;
        }
        else
            opp_cnt++;

        if (this_cnt > opp_cnt)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.age = 2;
        cat1.weight = 3;
        cat1.strength = 5;

        Cat cat2 = new Cat();
        cat2.age = 1;
        cat2.weight = 3;
        cat2.strength = 5;

        System.out.println(cat1.fight(cat2));  //false
        System.out.println(cat2.fight(cat1));  //false

        //Integer.compare()
    }
}
