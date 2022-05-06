package pers.rasskazov.algoritmsanddatastructures.helpers;

public final class ArrayHelpers {
    private ArrayHelpers(){
        // No OP
    }

    public static void swap(int[] array, int i, int j) {

            var temp = array[i];
            array[i] = array[j];
            array[j] = temp;

    }

}
