package com.javarush.task.task17.task1714;

/* 
Comparable
*/

import java.util.Comparator;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o) {
        int distScore = -1 * Float.compare(this.getDistance(), o.getDistance());
        int qualScore = Integer.compare(this.getQuality(), o.getQuality());
        int summScore = distScore + qualScore;
        return summScore > 0 ? 1 : summScore < 0 ? -1 : 0;
    }

    public static void main(String[] args) {
//        Beach a = new Beach("LowBeach", (float) 4.3, 4);
//        Beach b = new Beach("HiBeach", (float) 7.3, 5);
//        Beach c = new Beach("MedBeach1", (float) 5.3, 4);
//        Beach d = new Beach("MedBeach2", (float) 4.3, 5);
//
//        System.out.println(a.compareTo(b));
//        System.out.println(b.compareTo(c));
//        System.out.println(c.compareTo(d));
//        System.out.println(a.compareTo(c));
//        System.out.println(a.compareTo(d));
//        System.out.println(b.compareTo(d));
    }
}
