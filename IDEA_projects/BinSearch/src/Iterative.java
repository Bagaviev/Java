import java.util.Arrays;

public class Iterative {
    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int med = low + (high - low) / 2;
            if (array[med] < key)
                low = med + 1;
            else if (array[med] > key)
                high = med - 1;
            else // if (array[med] == key)
                return med;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        System.out.println(binarySearch(arr, 70));
    }
}
