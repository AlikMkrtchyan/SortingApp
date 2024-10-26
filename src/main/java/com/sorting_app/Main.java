package com.sorting_app;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.strategy.*;
import com.sorting_app.input.SearchInputData;

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

        //   DataObject dataObject = new DataObject();


        search.getResult();



    }
}