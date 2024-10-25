package com.sorting_app;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.ConsoleInput;
import com.sorting_app.input.RandomInput;
import com.sorting_app.input.ReadFileInput;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ConsoleInput consoleInput = new ConsoleInput();
        RandomInput randomInput = new RandomInput();
        ReadFileInput readFileInput = new ReadFileInput();
        DataObject dataObject = new DataObject();

        while (true) {
            try {
//                randomInput.selectRandomObject();
//                randomInput.printCarList();
//                randomInput.printBookList();
//                randomInput.printRootVegetables();
                readFileInput.selectFileRead();
                readFileInput.printCarsFileRead();
                readFileInput.printBooks();
                readFileInput.printRootVegetable();

            } catch (ValidationException validationException) {
                System.out.println(validationException.getMessage());
            }

        }
    }
}