public class Recursive {
    public static int binarySearch(int[] array, int key, int low, int high) {
        int med = low + (high - low) / 2;

        if (low >= high) {
            return -1;
        }

        if (array[med] == key)
            return med;
        else if (array[med] < key)
            return binarySearch(array, key,med + 1, high);
        else // if (array[med] > key)
            return binarySearch(array, key, low, med - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        System.out.println(binarySearch(arr, 90, 0, arr.length - 1));
    }
}
