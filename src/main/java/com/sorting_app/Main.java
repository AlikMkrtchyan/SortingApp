package com.sorting_app;

import com.sorting_app.data.DataObject;
import com.sorting_app.strategy.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DataObject dataObject = new DataObject();

        InputConsoleStrategy inputConsoleStrategy = new InputConsoleStrategy(dataObject);
        InputRandomStrategy inputRandomStrategy = new InputRandomStrategy(dataObject);
        InputFileStrategy inputFileStrategy = new InputFileStrategy(dataObject);
        PrintObjectStrategy printObjectStrategy = new PrintObjectStrategy(dataObject);
        RecordStrategy record = new RecordStrategy(dataObject);
        BinarySearchStrategy search = new BinarySearchStrategy(dataObject);
        SortByEvenStrategy sortByEvenStrategy = new SortByEvenStrategy(dataObject);
        MergeSortStrategy mergeSortStrategy = new MergeSortStrategy(dataObject);

        inputFileStrategy.getResult();
        search.getResult();


    }
}