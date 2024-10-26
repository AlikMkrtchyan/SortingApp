package com.sorting_app.ExecutionCycle;

import com.sorting_app.utils.Printer;
import com.sorting_app.data.DataObject;
import com.sorting_app.strategy.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExecutionCycle {
    private static final Scanner scanner = new Scanner(System.in);
    private static int command;
    private DataObject dataObject;
    private Context context;
    private boolean isExit;
    private boolean isCorrect;

    public ExecutionCycle(DataObject dataObject) {
        this.dataObject = dataObject;
        this.context = new Context();
    }

    public void run() {
        isExit = false;
        while (!isExit) {
            Printer.printHelp();
            enterCommand();
            switch (command) {
                case 1: {
                    fillCollection();
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
                case 4: {
                    recordCollectionInFile();
                    break;
                }
//                case 5: {
//                    writeFoundElementsInFile();
//                    break;
//                }
                case 5: {
                    printCollection();
                    break;
                }
                case 6: {
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

    private void fillCollection() {
        isCorrect = false;
        System.out.println("Ведите номер желаемого способа заполнения коллекции:" +
                "\n1 - из файла;" +
                "\n2 - рандом;" +
                "\n3 - вручную.\n");
        while (!isCorrect) {
            enterCommand();
            switch (command) {
                case 1: {
                    context.setStrategy(new InputFileStrategy(dataObject));
                    context.commandSelected();
                    isCorrect = true;
                    break;
                }
                case 2: {
                    context.setStrategy(new InputRandomStrategy(dataObject));
                    context.commandSelected();
                    isCorrect = true;
                    break;
                }
                case 3: {
                    context.setStrategy(new InputConsoleStrategy(dataObject));
                    context.commandSelected();
                    isCorrect = true;
                    break;
                }
                default: {
                    System.out.println("Введите число от 1 до 3.");
                }
            }
        }
    }

    private void sortCollection() {
        isCorrect = false;

        System.out.println("Ведите номер желаемого способа сортировки коллекции:" +
                "\n1 - mergeSort;" +
                "\n2 - сортировка по числовому полю.\n");

        while (!isCorrect) {
            enterCommand();
            switch (command) {
                case 1: {
                    context.setStrategy(new MergeSortStrategy(dataObject));
                    context.commandSelected();
                    isCorrect = true;
                    break;
                }
                case 2: {
//                    context.setStrategy(new (dataObject));
//                    context.commandSelected();
                    isCorrect = true;
                    break;
                }
                default: {
                    System.out.println("Введите число от 1 до 2.");
                }
            }
        }
    }

    public void findElement() {
//        boolean isFound = false;
//
        context.setStrategy(new BinarySearchStrategy(dataObject));// find
        context.commandSelected();
//        if (isFound) {
//            System.out.println("Элемент найден");
//            //writeFoundElementInFile();
//        } else {
//            System.out.println("Элемент не найден");
//        }
    }

    private void recordCollectionInFile() {
        context.setStrategy(new RecordStrategy(dataObject));
        context.commandSelected();
    }

    private void printCollection() {
        context.setStrategy(new PrintObjectStrategy(dataObject));
        context.commandSelected();
    }

    private void enterCommand() {
        try {
            System.out.print("Введите команду: ");
            command = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Команда может быть только в числовом виде.");
        }
    }
}