package com.sorting_app;

import com.sorting_app.data.DataObject;
import com.sorting_app.input.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        DataObject dataObject = new DataObject();
        ConsoleInput consoleInput = new ConsoleInput(dataObject);

        while (true){
            consoleInput.addItem();
            if(!d().isEmpty()){
                System.out.println(classesList.getCarList());
            }
            if(!classesList.getBookList().isEmpty()){
                System.out.println(classesList.getBookList());
            }
            if(!classesList.getKorneplodList().isEmpty()){
                System.out.println(classesList.getKorneplodList());
            }
        }

        //ItemInputManager itemInputManager = new ItemInputManager(classesList);
//        WriterCSV writerCSV = new WriterCSV();
//
//        itemInputManager.addItem();
//        itemInputManager.addItem();
//
//        writerCSV.writeCars(classesList.getCarList(), "CARS.csv");
//        classesList.printCars();

//        String fileCar = "C:\\Users\\wwwco\\IdeaProjects\\SortingApp\\src\\main\\resources\\KeepCar.csv";
//        String fileBook = "C:\\Users\\wwwco\\IdeaProjects\\SortingApp\\src\\main\\resources\\KeepBook.csv";
//        String fileKorneplod = "C:\\Users\\wwwco\\IdeaProjects\\SortingApp\\src\\main\\resources\\KeepKorneplod.csv";
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