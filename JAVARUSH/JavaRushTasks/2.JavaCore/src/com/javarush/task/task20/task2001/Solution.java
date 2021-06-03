package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/


public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
//        System.out.println(System.getProperty("java.io.tmpdir"));

        try {
            File your_file_name = File.createTempFile("manualSerialize", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name = "";
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(this.name);
            writer.newLine();

            if (this.assets.size() > 0) {
                for (Asset current : this.assets) {
                    writer.write(current.getName());
                    writer.newLine();
                    writer.write(String.valueOf(current.getPrice()));
                    writer.newLine();
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            this.name = reader.readLine();

            while (reader.ready()) {
                assets.add(new Asset(reader.readLine(), Double.parseDouble(reader.readLine())));
            }

            reader.close();
        }
    }
}


// lel edition (almost worked)
/*
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
//        System.out.println(System.getProperty("java.io.tmpdir"));

        try {
            File your_file_name = File.createTempFile("manualSerialize", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name = "";
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            outputStream.write(this.name.getBytes());
            outputStream.write(11);


            for (int i = 0; i < assets.size(); i++) {
                outputStream.write(assets.get(i).getName().getBytes());
                outputStream.write(11);
                outputStream.write(String.valueOf(assets.get(i).getPrice()).getBytes());
                outputStream.write(11);
                outputStream.write(12);
            }
        }

        public void load(InputStream inputStream) throws Exception {
            int symbol;
            String Aname = "";
            String Aprice = "";

            while ((symbol = inputStream.read()) != 11) {
                this.name += "" + (char) symbol;
            }

            while (inputStream.available() > 0) {

                while ((symbol = inputStream.read()) != 12) {
                    while (symbol != 11) {
                        Aname += "" + (char) symbol;
                        symbol = inputStream.read();
                    }

                    while ((symbol = inputStream.read()) != 11) {
                        Aprice += "" + (char) symbol;               // тут бага какая-то ебаная после 999.999
                        inputStream.read();
                    }
                }
                this.assets.add(new Asset(Aname, Integer.parseInt(Aprice)));
            }
        }
    }
}
*/