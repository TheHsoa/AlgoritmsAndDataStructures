package pers.rasskazov.algoritmsanddatastructures.algorithms.search.maximumsubarray;

public final class MaximumSubArrayRecursiveSearch {
    private MaximumSubArrayRecursiveSearch(){ }

    public static MaximumSubArraySearchResult find(int[] array) {

        return findMaximumSubArray(array, 0, array.length - 1);
    }

    private static MaximumSubArraySearchResult findMaximumSubArray(int[] array, int low, int high) {
        if (low == high) return new MaximumSubArraySearchResult(low, high, array[low]);

        var mid = (low + high) / 2;

        var left = findMaximumSubArray(array, low, mid);
        var right = findMaximumSubArray(array, mid + 1, high);
        var cross = findMaximumCrossingSubArray(array, low, mid, high);

        if (left.getSum() >= right.getSum() && left.getSum() >= cross.getSum()) return left;
        if (right.getSum() >= cross.getSum()) return right;
        else return cross;
    }

    private static MaximumSubArraySearchResult findMaximumCrossingSubArray(int[] array, int low, int mid, int high) {
        var sum = array[mid];
        var maxLeftSum = sum;
        var maxLeft = mid;

        for(var i = mid - 1; i >= low; i--) {
            sum += array[i];
            if(sum > maxLeftSum) {
                maxLeftSum = sum;
                maxLeft = i;
            }
        }

        sum = array[mid + 1];
        var maxRightSum = sum;
        var maxRight = mid + 1;

        for(var i = mid + 2; i <= high; i++) {
            sum += array[i];
            if (sum > maxRightSum) {
                maxRightSum = sum;
                maxRight = i;
            }
        }

        return new MaximumSubArraySearchResult(maxLeft, maxRight, maxLeftSum + maxRightSum);
    }
}
