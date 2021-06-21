import util.Sortable;
import util.Timer;

public class Heap implements Sortable {        //
    /*
    100k - 0.023 sec

    Time: o(n log(n))
    Space: o(1)
     */

    public int[] sort(int[] array) {
        int n = array.length;                       // PriorityQueue можно было сделать на всроенном, но это как то всрато

        // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--)    // почему не с начала загадка, но ок
            heapify(array, n, i);                   // бежим с середины элтов вверх рекурсивно, а остатки вниз потом (которые тоже наверх бегут)

        // One by one extract an element from heap   / нашли максимум массива и вытолкали его наверх
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end     / взяли его и поменяли с минимальным индексом (не значением) типа
            int temp = array[0];            // получается суть в том, что самый малый не обязат оказывается последним, но он меняется с первым
            array[0] = array[i];            // который был максимальным точно, после чего макс удаляют из рассмотрения, т.о. крутясь и находя максимумы
            array[i] = temp;                // и удаляя их, можно отсортировать все до конца. Спасибо я кончил.

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
        return array;
    }

    void heapify(int arr[], int n, int i)       // geekforgeeks ok ponyatno dopustim
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    @Override
    public void sort(int[] array, int min, int max) {
        return;
    }

    public static void main(String[] args) {
        Sortable sort = new Heap();
        System.out.println(Timer.estimateTime(sort, 100000));
    }
}
