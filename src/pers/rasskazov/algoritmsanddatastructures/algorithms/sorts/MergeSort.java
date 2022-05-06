package pers.rasskazov.algoritmsanddatastructures.algorithms.sorts;

public final class MergeSort {

    private MergeSort() { }

    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int left, int right) {

        if (left != right) {
            var mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        var leftIterator = 0;
        var rightIterator = 0;
        var sortedArray = new int[right - left + 1];


        while (leftIterator + left <= mid && rightIterator + mid + 1 <= right) {
            if (array[leftIterator + left] > array[rightIterator + mid + 1]) {
                sortedArray[leftIterator + rightIterator] = array[rightIterator + mid + 1];
                rightIterator++;
            } else {
                sortedArray[leftIterator + rightIterator] = array[leftIterator + left];
                leftIterator++;
            }
        }

        while (leftIterator + left <= mid) {
            sortedArray[leftIterator + rightIterator] = array[leftIterator + left];
            leftIterator++;
        }

        while (rightIterator + mid + 1 <= right) {
            sortedArray[leftIterator + rightIterator] = array[rightIterator + mid + 1];
            rightIterator++;
        }

        System.arraycopy(sortedArray, 0, array, left, right - left + 1);
    }
}
