package pers.rasskazov.algoritmsanddatastructures.algorithms.sorts;

public final class InsertionSort {

    private InsertionSort() { }

    public static void sort(int[] array){
        for(var j = 1; j < array.length; j++) {
            var key = array[j];
            var i = j - 1;
            while(i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }
}
