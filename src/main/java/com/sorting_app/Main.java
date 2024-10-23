package com.sorting_app;

import com.sorting_app.input.ItemInputManager;
import com.sorting_app.input.RandomInputManager;
import com.sorting_app.list.ClassesList;
import com.sorting_app.list.WriterCSV;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


//        ClassesList classesList = new ClassesList();
//        ItemInputManager itemInputManager = new ItemInputManager(classesList);
//        WriterCSV writerCSV = new WriterCSV();
//
//        itemInputManager.addItem();
//        itemInputManager.addItem();
//
//        writerCSV.writeCars(classesList.getCarList(), "CARS.csv");
//        classesList.printCars();

        String file = "C:\\Users\\wwwco\\IdeaProjects\\SortingApp\\src\\main\\resources\\KeepCar.csv";

        RandomInputManager randomInputManager = new RandomInputManager(file);
        randomInputManager.generateCarList(3);
        randomInputManager.printCarList();


    }
}