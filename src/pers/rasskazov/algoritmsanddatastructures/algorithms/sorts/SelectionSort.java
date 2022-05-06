package pers.rasskazov.algoritmsanddatastructures.algorithms.sorts;

public final class SelectionSort {

    private SelectionSort() { }

    public static int[] sort(int[] array) {
        for(var i = 0; i < array.length - 1; i++) {
            var min = array[i];
            var indexOfMinElement = i;

            for (var j = i + 1; j< array.length; j ++) {
                if(min > array[j]) {
                    min = array[j];
                    indexOfMinElement = j;
                }
            }

            if(indexOfMinElement != i) {
                array[indexOfMinElement] = array[i];
                array[i] = min;
            }
        }
        return array;
    }
}
