package pers.rasskazov.algoritmsanddatastructures.algorithms.search.maximumsubarray;

public final class MaximumSubArrayLinearSearch {
    private MaximumSubArrayLinearSearch() { }

    public static MaximumSubArraySearchResult find(int[] array) {

        var maxSubArray = 0;
        var currentMaxSubArray = 0;
        var low = -1;
        var high = -1;
        var tempLow = 0;

        for(int i = 0; i < array.length; i ++) {
            currentMaxSubArray += array[i];

            if (maxSubArray < currentMaxSubArray) {
                maxSubArray = currentMaxSubArray;
                low = tempLow;
                high = i;
            }

            if (currentMaxSubArray < 0) {
                currentMaxSubArray = 0;
                tempLow = i + 1;
            }

        }

        if(low == -1) return findMaxArrayNumber(array);

        return new MaximumSubArraySearchResult(low, high, maxSubArray);
    }

    private static MaximumSubArraySearchResult findMaxArrayNumber(int[] array) {
        var max = array[0];
        var index = 0;
        for(var i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
                index = i;
            }
        }


        return new MaximumSubArraySearchResult(index, index, max);
    }
}
