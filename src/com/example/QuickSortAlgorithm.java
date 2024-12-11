package com.example;

import java.util.Collections;
import java.util.List;

public class QuickSortAlgorithm implements SortingAlgorithm {
    @Override
    public void sort(List<Integer> numbers) {
        quicksort(numbers, 0, numbers.size() - 1);
    }

    private void quicksort(List<Integer> numbers, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(numbers, left, right);
            quicksort(numbers, left, pivotIndex - 1);
            quicksort(numbers, pivotIndex + 1, right);
        }
    }

    private int partition(List<Integer> numbers, int left, int right) {
        int pivot = numbers.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (numbers.get(j) < pivot) {
                i++;
                Collections.swap(numbers, i, j);
            }
        }
        Collections.swap(numbers, i + 1, right);
        return i + 1;
    }


    @Override
    public String getName() {
        return "Quicksort";
    }


}