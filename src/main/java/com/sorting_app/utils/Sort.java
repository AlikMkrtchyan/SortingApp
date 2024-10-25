package com.sorting_app.utils;

import com.sorting_app.data.DataObject;
import com.sorting_app.strategy.IStrategy;

import java.util.List;
import java.util.Objects;

public class Sort implements IStrategy {
    private DataObject sortedData;

    public Sort(DataObject dataToSort) {
        this.sortedData = dataToSort;
    }

    private void sort() {
        if (sortedData.cars != null) {
            MergeSort.mergeSort(sortedData.cars);
        }
        if (sortedData.books != null) {
            MergeSort.mergeSort(sortedData.books);
        }
        if (sortedData.rootVegetables != null) {
            MergeSort.mergeSort(sortedData.rootVegetables);
        }
    }

    @Override
    public String getResult() {
        this.sort();
        return "Коллекция успешно отсортирована.";
    }
}
