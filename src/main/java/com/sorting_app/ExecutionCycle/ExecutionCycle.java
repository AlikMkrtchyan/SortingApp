package com.sorting_app.ExecutionCycle;

import com.sorting_app.Utils.Printer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExecutionCycle {
    private static String typeOfCollection = "";
    private static int lengthOfCollection;
    /// длина или размер?
    private static List collectionList;
    private static final Scanner scanner = new Scanner(System.in);
    private static int command;

    public static void executionCycle() {

        boolean isExit = false;

        while (!isExit) {
            Printer.printHelp();
            try {
                System.out.print("Введите команду: ");
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Команда может быть только в числовом виде.");
            }
            switch (command) {
                case 1: {
                    fillCollection();
                    System.out.println();
                    System.out.println("вывод коллекции");
                    break;
                }
                case 2: {
                    sortCollection();
                    break;
                }
                case 3: {
                    findElement();
                    break;
                }
//                case 4: {
//                    writeSortedCollectionInFile();
//                    break;
//                }
//                case 5: {
//                    writeFoundElementsInFile();
//                    break;
//                }
                case 4: {
                    isExit = true;
                    break;
                }
                default: {
                    System.out.println("Неверная команда. Попробуйте заново.");
                    break;
                }
            }
            scanner.nextLine();
        }
        System.out.println("\nПрограмма завершена");
    }

    private static void fillCollection() {
//        typeOfCollection = CollectionAPI.choiceOfTypeCollection();
//        lengthOfCollection = CollectionAPI.setLengthOfCollection();
//        // System.out.println(lengthOfCollection);
//        collectionList = CollectionAPI.initCollection(typeOfCollection, lengthOfCollection);
//        CollectionAPI.addElementsInCollectionFromManually(collectionList, typeOfCollection, lengthOfCollection);
//        //writeSortedCollectionInFile();
    }
    public static void sortCollection(){}
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
