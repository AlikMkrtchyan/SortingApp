package com.sorting_app;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.*;
import com.sorting_app.model.Car;
import com.sorting_app.strategy.InputConsole;


import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, ValidationException {
        Record record = new Record();
        WriterCSV writerCSV = new WriterCSV();
        DataObject dataObject = new DataObject();
        ConsoleInput consoleInput = new ConsoleInput(dataObject);
        consoleInput.selectObject();
        dataObject.printCars();
        record.recordCar(dataObject);

        consoleInput.selectObject();
        dataObject.printBooks();
        record.recordBook(dataObject);


        consoleInput.selectObject();
        dataObject.printRootVegetable();
        record.recordRootVagetable(dataObject);






//        RandomInput randomInput = new RandomInput(dataObject);
//        ReadFileInput readFileInput = new ReadFileInput(dataObject);
        //   DataObject dataObject = new DataObject();







        //ConsoleInput consoleInput = new ConsoleInput();


//        while (true) {
//            try {
//                consoleInput.selectObject();
//                 randomInput.selectRandomObject();
//               readFileInput.selectFileRead();
//                dataObject.printCars();
//                dataObject.printBooks();
//                dataObject.printRootVegetable();
//
//
//            } catch (ValidationException validationException) {
//                System.out.println(validationException.getMessage());
//            }

        }
    }
