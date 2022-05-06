package pers.rasskazov.algoritmsanddatastructures.datastructure;

import pers.rasskazov.algoritmsanddatastructures.helpers.ArrayHelpers;

public final class Heap {

    private Heap() { }

    public static void buildHeapToEnd(int[] array, int i, int heapEnd) {
        int largest = i;

        while(i <= heapEnd) {
            var left = getLeft(i);
            var right = getRight(i);

            if(left <= heapEnd && array[left] > array[largest]) largest = left;
            if(right <= heapEnd && array[right] > array[largest]) largest = right;

            if(largest == i) return;

            ArrayHelpers.swap(array, i, largest);
            i = largest;
        }
    }

    public static void buildMaxHeap(int[] array) {
        for(var i = array.length / 2; i > 0; i--) {
            buildHeapToEnd(array, i - 1, array.length - 1);
        }
    }

    private static int getLeft(int i) {
        return 2 * i + 1;
    }

    private static int getRight(int i) {
        return 2 * i + 2;
    }

    private static int getParent(int i) { return (i + 1) / 2 + 1; }
}
