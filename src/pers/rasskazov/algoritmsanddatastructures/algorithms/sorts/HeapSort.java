package pers.rasskazov.algoritmsanddatastructures.algorithms.sorts;

import pers.rasskazov.algoritmsanddatastructures.helpers.ArrayHelpers;
import pers.rasskazov.algoritmsanddatastructures.datastructure.Heap;

public final class HeapSort {
    private HeapSort() { }

    public static void sort(int[] array) {
        int heapEnd = array.length - 1;
        Heap.buildMaxHeap(array);

        while(heapEnd >= 0) {
            ArrayHelpers.swap(array, 0, heapEnd);
            heapEnd--;

            Heap.buildHeapToEnd(array, 0, heapEnd);
        }
    }

}
