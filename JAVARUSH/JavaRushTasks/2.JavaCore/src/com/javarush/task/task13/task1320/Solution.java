package com.javarush.task.task13.task1320;

/* 
Neo
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(Matrix.NEO);
    }

    static class Matrix {
//        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
          public static User NEO = (User) new User().initializeIdAndName(1, "Neo");

        // тут идет от общего к частному (можно присвоить ссылку интерфейсного типа объекту класса, реализующего этот интерфейс)
        // это как
        // List<String> list = new ArrayList<String>();
        // расширение типа
        // наоборот потребовалось бы приведение типов

        // в случае же наследования: животное = новое домашнее животное()
        // домашее животное != новое животное()

        // кароче DBObject более общий абстратная сущность, чем User. Поэтому присвоение как животное = новое домашнее животное()
        // иначе нужно кастить
    }

    interface DBObject {
        DBObject initializeIdAndName(long id, String name);
    }

    static class User implements DBObject {
        long id;
        String name;

//        public User initializeIdAndName(long id, String name) {
//            this.id = id;
//            this.name = name;
//            return this;
//        }

        public DBObject initializeIdAndName(long id, String name) {
            this.id = id;
            this.name = name;
            return this;
        }

        @Override
        public String toString() {
            return String.format("The user's name is %s, id = %d", name, id);
        }
    }
}
