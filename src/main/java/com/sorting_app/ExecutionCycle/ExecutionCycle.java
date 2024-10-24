package com.sorting_app.ExecutionCycle;

import com.sorting_app.Utils.Printer;

import java.util.List;
import java.util.Scanner;

public class ExecutionCycle {
    private static String typeOfCollection = "";
    private static Integer lengthOfCollection; /// длина или размер?
    private static List collectionList;
    private static final Scanner scanner = new Scanner(System.in);
    private static String command;

    public static void executionCycle() {
        Printer.printHelp();
        boolean isExit = false;

        while (!isExit) {
            System.out.print("Введите команду: ");
            command = scanner.nextLine();

            switch (command) {
                case "fill": {
                    fillCollection();
                    System.out.println();
                    System.out.println("вывод коллекции");
                    for(Object c: collectionList) {
                        System.out.println(c);
                    }
                    break;
                }
                case "find": {
                    findElement();
                    break;
                }
//                case "help": {
//                    Printer.printHelp();
//                    break;
//                }
                case "exit": {
                    isExit = true;
                    break;
                }
                default: {
                    System.out.println("Неверная команда. Попробуйте заново.");
                    break;
                }
            }
            Printer.printHelp();
        }
        System.out.println("Программа завершена");
    }

    private static void fillCollection() {
//        typeOfCollection = CollectionAPI.choiceOfTypeCollection();
//        lengthOfCollection = CollectionAPI.setLengthOfCollection();
//        // System.out.println(lengthOfCollection);
//        collectionList = CollectionAPI.initCollection(typeOfCollection, lengthOfCollection);
//        CollectionAPI.addElementsInCollectionFromManually(collectionList, typeOfCollection, lengthOfCollection);
//        //writeSortedCollectionInFile();
    }

    public static void findElement() {
        boolean isFound = false;

        // find

        if (isFound) {
            System.out.println("Элемент найден");
            //writeFoundElementInFile();
        }
        else {
            System.out.println("Элемент не найден");
        }
    }
}
