package util;

public interface Sortable {
    void sort(int[] array, int min, int max);   // quick
    void sort(int[] array, int n);  // merge
    int[] sort(int [] array);   // all other
}
