public class Garbage_Collector {
    int х;
    Garbage_Collector(int i) {
        х = i;
    }
    protected void finalize() {
            System.out.println("Финaлизaция " + х);
    }
    void generator(int i) {
        Garbage_Collector о = new Garbage_Collector(i);
    }
        static class Finalize {
            public static void main(String args[]) {
                int count;
                Garbage_Collector ob = new Garbage_Collector(0);
                for (count = 1; count < 1000000; count++) ob.generator(count);
            }
    }
}