package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};             //но это биты, если переводить в десятичную, то 192 усекается
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};  //до диапазона byte и будет 1100 0000, а это число
        byte[] netAddress = getNetAddress(ip, mask);                      //уже интрепретируется как отрицательный int в доп коде
        print(ip);          //11000000 10101000 00000001 00000010           он равен -64 в dec
        print(mask);        //11111111 11111111 11111110 00000000           но тут побитовые операции так что похер
        print(netAddress);  //11000000 10101000 00000000 00000000           делаем то, что на экзе в магу ручками делали (dec to bin)
                                                                          // (&) и затем назад в dec

        System.out.println((byte) 260);
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] addr = new byte[ip.length];

        for (int i = 0; i < ip.length; i++) {
            addr[i] = (byte) (ip[i] & mask[i]);
        }

        return addr;
    }

    public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
//            System.out.print(Integer.toString(bytes[i] + 256, 2) + " ");
            String num = Integer.toString(bytes[i] + 256, 2);
            System.out.print(num.substring(num.length() - 8) + " ");
}
        System.out.println("");
    }
}
