package com.sorting_app.utils;

import com.sorting_app.data.DataObject;
import com.sorting_app.strategy.IStrategy;

public class Sort implements IStrategy {
    private DataObject sortedData;


    public Sort(DataObject dataToSort) {
        this.sortedData = dataToSort;
    }

    private void sort() {
        if (sortedData.getCars() != null) {
            MergeSort.mergeSort(sortedData.getCars());
        }
        if (sortedData.getBooks() != null) {
            MergeSort.mergeSort(sortedData.getBooks());
        }
        if (sortedData.getRootVegetables() != null) {
            MergeSort.mergeSort(sortedData.getRootVegetables());
        }
    }


    @Override
    public void getResult() {
        System.out.println("");
    }
}
