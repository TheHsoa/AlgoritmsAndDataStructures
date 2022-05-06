package pers.rasskazov.algoritmsanddatastructures.algorithms.sorts;

public final class ShellSort {
    private ShellSort() { }

    public static void sort(int[] array) {
        var d = calculateDistance(array.length);
        while(d > 0) {
            for(int i = d; i < array.length; i++) {
                var j = i - d;
                var key = array[i];
                while (j >= 0 && array[j] > key) {
                    array[j + d] = array[j];
                    j -= d;
                }
                array[j + d] = key;
            }

            d = (d - 1) / 3;
        }
    }

    private static int calculateDistance(int arrayLength) {
        var d = 1;
        while (d < arrayLength / 3)
            d = 3 * d + 1;
        return d;
    }
}
