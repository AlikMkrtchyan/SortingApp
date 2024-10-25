package com.sorting_app;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.Record;
import com.sorting_app.strategy.InputConsoleStrategy;
import com.sorting_app.strategy.InputFileStrategy;
import com.sorting_app.strategy.InputRandomStrategy;
import com.sorting_app.strategy.PrintObjectStrategy;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        DataObject dataObject = new DataObject();

        InputConsoleStrategy inputConsoleStrategy = new InputConsoleStrategy(dataObject);
        InputRandomStrategy inputRandomStrategy = new InputRandomStrategy(dataObject);
        InputFileStrategy inputFileStrategy = new InputFileStrategy(dataObject);
        PrintObjectStrategy printObjectStrategy = new PrintObjectStrategy(dataObject);
        Record record = new Record();

        //   DataObject dataObject = new DataObject();



            try {
            //    inputFileStrategy.getResult();
               record.recordCar(dataObject);
                record.clear();
             //   inputRandomStrategy.getResult();

               // printObjectStrategy.getResult();

            } catch (ValidationException validationException) {
                System.out.println(validationException.getMessage());

            // inputConsoleStrategy.getResult();


        }
    }
}