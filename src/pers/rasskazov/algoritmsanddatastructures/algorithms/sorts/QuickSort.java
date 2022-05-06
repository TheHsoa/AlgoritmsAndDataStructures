package pers.rasskazov.algoritmsanddatastructures.algorithms.sorts;

import pers.rasskazov.algoritmsanddatastructures.helpers.ArrayHelpers;

public final class QuickSort {
    private QuickSort() { }

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int p, int r) {
        if(p < r) {
            var q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    private static int partition(int[] array, int p, int r) {
        for(int i = p; i < r; i ++) {
            if(array[i] <= array[r]) {
                ArrayHelpers.swap(array, i, p);
                p++;
            }
        }

        ArrayHelpers.swap(array, p, r);
        return p;
    }
}
