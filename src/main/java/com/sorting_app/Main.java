package com.sorting_app;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.Record;
import com.sorting_app.strategy.*;
import com.sorting_app.utils.SearchStrategy;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        DataObject dataObject = new DataObject();

        InputConsoleStrategy inputConsoleStrategy = new InputConsoleStrategy(dataObject);
        InputRandomStrategy inputRandomStrategy = new InputRandomStrategy(dataObject);
        InputFileStrategy inputFileStrategy = new InputFileStrategy(dataObject);
        PrintObjectStrategy printObjectStrategy = new PrintObjectStrategy(dataObject);
        RecordStrategy record = new RecordStrategy(dataObject);
        SearchStrategy search = new SearchStrategy(dataObject);

        //   DataObject dataObject = new DataObject();



inputFileStrategy.getResult();
printObjectStrategy.getResult();
//search.findBooks();
        //search.findСar();
search.findRootVegetable();
//record.getResult();
/*            try {
            //    inputFileStrategy.getResult();
               //record.getResult();
            //    record.clear();
             //   inputRandomStrategy.getResult();

               // printObjectStrategy.getResult();

            } catch (ValidationException validationException) {
                System.out.println(validationException.getMessage());*/

            // inputConsoleStrategy.getResult();



    }
}