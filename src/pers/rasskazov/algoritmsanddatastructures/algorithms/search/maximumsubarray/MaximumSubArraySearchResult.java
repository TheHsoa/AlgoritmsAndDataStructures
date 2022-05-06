package pers.rasskazov.algoritmsanddatastructures.algorithms.search.maximumsubarray;

public final class MaximumSubArraySearchResult {
    public int getLow() {
        return Low;
    }

    public int getHigh() {
        return High;
    }

    public int getSum() {
        return Sum;
    }

    private int Low;
    private int High;
    private int Sum;

    MaximumSubArraySearchResult(int low, int high, int sum) {
        Low = low;
        High = high;
        Sum = sum;
    }
}
