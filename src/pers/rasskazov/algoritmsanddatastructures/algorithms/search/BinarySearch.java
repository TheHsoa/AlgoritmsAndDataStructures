package pers.rasskazov.algoritmsanddatastructures.algorithms.search;

import java.util.Arrays;

public final class BinarySearch {

    public BinarySearch() { }

    public static int find(int[] array, int value) {
        Arrays.sort(array);

        var low = 0;
        var high = array.length;

        while(low < high) {
            var mid = (low + high) / 2;

            if(array[mid] == value)
                return mid;

            if(array[mid] < value) {
                low = mid + 1;
            }
            else high = mid;
        }

        return -1;
    }
}
