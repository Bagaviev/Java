package com.javarush.task.task03.task0314;

/* 
Таблица умножения Ӏ Java Syntax: 3 уровень, 6 лекция
*/

/*
1 2 3 4
2 4 6 8
3 6 9 12
4 8 12 16
 */

public class Solution {
    public static void main(String[] args) {

        int arr[][] = new int[10][10];

        for (int k=0; k < arr[0].length; k++) {              // инициализация 1-ой строки / столбца
            arr[k][0] = k+1;
            arr[0][k] = k+1;
        }

        for (int i=1; i < arr[0].length; i++) {             // заполнение

            for(int j=1; j < arr[1].length; j++) {
                arr[i][j] = arr[i][0] * arr[0][j];
            }
        }

        for (int a = 0; a < arr[0].length; a++) {          // вывод
            for (int b = 0; b < arr[1].length; b++) {
                System.out.print(arr[a][b] + " ");
            }
            System.out.println();
        }
    }
}


// 11: arr[1][0] * arr[0][1]   12: arr[1][0] * arr[0][2]
// 21: arr[2][0] * arr[0][1]   22: arr[2][0] * arr[0][2]
/*
for (int i=1; i < 4; i++) {
    for(int j=1; j < 4; j++) {
        arr[i][j] = arr[i][j-1] * arr[i-1][j];
        }
}
 */
// GG боже как я хорош. Но чувствую что это какая то чересчур хитровыебанная версия. Умные люди сделали бы проще.