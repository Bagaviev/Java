package com.javarush.task.task14.task1421;

public class Singleton {
    private static Singleton instance;
    static int cnt = 0;

    private Singleton() {
//        this.instance = new Singleton();  stackoverflow heh dodik
        cnt++;
    }

    public static Singleton getInstance() {
        if (cnt != 0)
            return instance;
        else
            instance = new Singleton();
            return instance;
    }
}

/* like esli tupoi
public class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    private Singleton() {
    }
}
 */