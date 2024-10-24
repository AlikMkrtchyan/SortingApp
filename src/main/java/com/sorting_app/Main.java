package com.sorting_app;

import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.RandomInput;
import com.sorting_app.strategy.InputAddObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        InputAddObject inputAddObject = new InputAddObject();
        RandomInput randomInput = new RandomInput();

        while (true) {
            try {
                randomInput.selectRandomObject();
            } catch (ValidationException validationException) {
                System.out.println(validationException.getMessage());
            }

        }


        //ItemInputManager itemInputManager = new ItemInputManager(classesList);
//        WriterCSV writerCSV = new WriterCSV();
//
//        itemInputManager.runObject();
//        itemInputManager.runObject();
//
//        writerCSV.writeCars(classesList.getCarList(), "CARS.csv");
//        classesList.printCars();

//        String fileCar = "C:\\Users\\wwwco\\IdeaProjects\\SortingApp\\src\\main\\resources\\KeepCar.csv";
//        String fileBook = "C:\\Users\\wwwco\\IdeaProjects\\SortingApp\\src\\main\\resources\\KeepBook.csv";
//        String fileKorneplod = "C:\\Users\\wwwco\\IdeaProjects\\SortingApp\\src\\main\\resources\\KeepRootVegetable.csv";
//        String fileTest = "C:\\Users\\wwwco\\IdeaProjects\\SortingApp\\src\\main\\resources\\TestFile.csv";

        //Запись рандомных машин
//        RandomInputCar randomInputManager = new RandomInputCar(fileCar);
//        randomInputManager.generateCarList(3);
//        randomInputManager.printCarList();

        //Запись рандомных книг
//        RandomInputBook randomInputBook = new RandomInputBook(fileBook);
//        randomInputBook.generateBookList(3);
//        randomInputBook.printBookList();

        //Запись рандомных овощей
//        RandomInputKorneplod randomInputKorneplod = new RandomInputKorneplod(fileKorneplod);
//        randomInputKorneplod.generateKorneplodList(3);
//        randomInputKorneplod.printKorneplodsList();

        //Чтение из файла
//        ReadFileInput readFileInput = new ReadFileInput();
//        readFileInput.readFile(fileTest);
//        readFileInput.printData(fileTest);
    }
}