import util.Sortable;
import util.Timer;

public class Merge implements Sortable {     // Расческа тут ширина сравнения от большой к попарной
    /*
    100k - 0.051 sec

    Time: o(n log n)
    Space: o(n)
     */

    public int[] sort(int[] array) {
        return array;
    }

    @Override
    public void sort(int[] array, int min, int max) {
        return;
    }

    @Override
    public void sort(int[] a, int n) {
        if (n < 2)
            return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++)
            l[i] = a[i];

        for (int i = mid; i < n; i++)
            r[i - mid] = a[i];

        sort(l, mid);
        sort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {     // сравниваем 2 элемента из подмассивов
            if (l[i] <= r[j]) {
                a[k++] = l[i++];    // заполняем буфер меньшими
            }
            else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {  // если один из подсписков кончился, остаток копируется в результат
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
        Sortable sort = new Merge();
        System.out.println(Timer.estimateTime(sort, 100_000));
    }
}