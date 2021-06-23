import util.Sortable;
import util.Timer;

public class Quick  implements Sortable {     // Выбирается опорный элемент посередине, далее перестановки слева от него
    /*                                        // остаются элементы меньшие, справа большие. Затем для этих 2 интервалов
    100k -  0.059 sec                               // рекурсивно вызывается этот же метод с новыми границами
                                              // детали тут: http://algolist.ru/sort/quick_sort.php
    Time: o(n^2) - o(n log n)                                 // вроде слегка понятно, но с нуля написать такое
    Space: o(n)
     */

    @Override
    public int[] sort(int[] array) {
        return new int[0];
    }

    @Override
    public void sort(int[] array, int n) {
        return;
    }

    public void sort(int[] array, int min, int max) {
            if (array.length == 0)// условие выхода из рекурсии,  если длина массива равна 0
                return;

            if (min >= max) //выходим, так как нечего уже делить
                return;

            int middle = min + (max - min) / 2;  // выбираем середину
            int middleElement = array[middle];
            int i = min, j = max;

            while (i <= j) {  // относительно элемента middle определяемменьшие элементы слева, большие справа
                while (array[i] < middleElement) {
                    i++;
                }
                while (array[j] > middleElement) {
                    j--;
                }

                if (i <= j) {      //меняем местами
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }

            if (min < j) // запускаем рекурсию с элементами меньшими чем middle
                sort(array, min, j);    // уууу сука https://medium.com/devschacht/nicholas-c-zakas-computer-science-in-javascript-quicksort-afa07c0a47f0

            if (max > i)// запускаем рекурсию с элементами большими чем middle
                sort(array, i, max);    // кароче только благодаря картинке умного чела понял, что после свопа индексы то на шаг бегут еще
                                        // тем самым left переходит за right и берем от min, j (а не min, i)...
    }

    public static void main(String[] args) {
        Sortable sort = new Quick();
        System.out.println(Timer.estimateTime(sort, 100_000));
    }
}
