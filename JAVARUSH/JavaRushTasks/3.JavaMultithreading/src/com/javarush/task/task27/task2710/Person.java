package com.javarush.task.task27.task2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            synchronized (mail) {       // берет монитор свободный, ждет 1000 сек не отпуская его и срет сообщение, отпускает монитор. Нет дедлока
                mail.setText("Person [" + name + "] wrote an email 'AAA'");
                mail.notify();      // тут надо у майл вызывать, тк оповещаем мы не персон, а обхект юзющий майл - сервер. В прошлом примере сам transferObj юзался как нотифаер
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
