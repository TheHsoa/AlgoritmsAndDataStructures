package pers.rasskazov.algoritmsanddatastructures.algorithms.sorts;

import java.util.Arrays;

/**
 * Сортировка подсчетом
 * Предполагается, что каждый из n элементов массива - целове число, принадлежащее интервалу от 0 до k
 * Если k = n, то время работы алгоритма равно Θ(n)
 */
public final class CountingSort {
    private CountingSort() {
    }

    public static void sort(int[] array) {
        if(array.length <= 0) return;

        var max = Arrays.stream(array).max().getAsInt();
        var min = Arrays.stream(array).min().getAsInt();

        var C = new int[max - min + 1];

        for (int anArray : array) {
            C[anArray - min] += 1;
        }

        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }

        var sortedArray = new int[array.length];

        for(var i = array.length - 1; i >= 0; i--) {
            sortedArray[C[array[i] - min] - 1] = array[i];
            C[array[i] - min]--;
        }

        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }
}
