package com.example;

import com.example.SortingAlgorithm;

import java.util.Collections;
import java.util.List;

public class TimSortAlgorithm implements SortingAlgorithm {
    @Override
    public void sort(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    @Override
    public String getName() {
        return "Timsort";
    }


}