package com.sorting_app;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.ConsoleInput;
import com.sorting_app.input.RandomInput;
import com.sorting_app.input.ReadFileInput;


import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        DataObject dataObject = new DataObject();
        ConsoleInput consoleInput = new ConsoleInput(dataObject);
        RandomInput randomInput = new RandomInput(dataObject);
        ReadFileInput readFileInput = new ReadFileInput(dataObject);
        //   DataObject dataObject = new DataObject();


        while (true) {
            try {
                consoleInput.selectObject();
                 randomInput.selectRandomObject();
               readFileInput.selectFileRead();
                dataObject.printCars();
                dataObject.printBooks();
                dataObject.printRootVegetable();


            } catch (ValidationException validationException) {
                System.out.println(validationException.getMessage());
            }

        }
    }
}