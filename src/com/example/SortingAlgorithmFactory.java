package com.example;

import com.example.QuickSortAlgorithm;
import com.example.SortingAlgorithm;

public class SortingAlgorithmFactory {
    public SortingAlgorithm createSortingAlgorithm(String algorithm) {
        if (algorithm.equalsIgnoreCase("quicksort")) {
            return new QuickSortAlgorithm();
        } else if (algorithm.equalsIgnoreCase("timsort")) {
            return new TimSortAlgorithm();
        } else {
            throw new IllegalArgumentException("Invalid sorting algorithm");
        }
    }
}