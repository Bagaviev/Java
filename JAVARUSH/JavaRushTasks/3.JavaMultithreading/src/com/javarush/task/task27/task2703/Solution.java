package com.javarush.task.task27.task2703;

/* 
Создаем deadlock
*/

public class Solution {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + " bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " bowed back to me!%n",
                    this.name, bower.getName());

            /*  stream API
            List<String> result  = stream
                    .filter(line -> line.startsWith("Как"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
            result.forEach(System.out::println);
             */

            /*  список файлов в директории
        File folder = new File("D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\IDEA_projects\\File_dirs");
        for (File file : folder.listFiles()) {
            System.out.println(file.getName());
        }
             */
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }
}
