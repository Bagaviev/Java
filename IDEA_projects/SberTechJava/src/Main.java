public class Main {
    // меняем местами без третьей переменной
        /*
        public static void main(String[] args) {
        int a = 56;
        int b = 23;

        a = a ^ b;
        b = b ^ a;      // a ^ b ^ b == a
        a = a ^ b;      // a ^ b ^ a == b

        System.out.println(a);
        System.out.println(b);


        int a = Integer.MAX_VALUE;
        int b = 59;

        a = b + a;
        b = a - b;
        a = a - b;

        System.out.println(a);
        System.out.println(b);
    }
}
*/

    // два потока
    // один пишет пинг другой понг последовательно

    static class Task implements Runnable {
        Object obj;
        String name;

        public Task(Object obj, String name) {
            this.obj = obj;
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (obj) {
                while (true) {
                    try {
                        System.out.println(name + "!");
                        Thread.sleep(500);

                        obj.notify();
                        obj.wait(500);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main (String[]args){
        Object syncObj = new Object();
        new Thread(new Task(syncObj, "Ping")).start();
        new Thread(new Task(syncObj, "Pong")).start();
    }
}