package com.sorting_app.ExecutionCycle;

import com.sorting_app.Utils.Printer;
import com.sorting_app.data.DataObject;
import com.sorting_app.strategy.InputConsoleStrategy;
import com.sorting_app.strategy.InputFileStrategy;
import com.sorting_app.strategy.InputRandomStrategy;
import com.sorting_app.strategy.PrintObjectStrategy;

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
//                case 4: {
//                    writeSortedCollectionInFile();
//                    break;
//                }
//                case 5: {
//                    writeFoundElementsInFile();
//                    break;
//                }
                case 4: {
                    printCollection();
                    break;
                }
                case 5: {
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

    public static void sortCollection() {

    }

    public static void findElement() {
        boolean isFound = false;

        // find

        if (isFound) {
            System.out.println("Элемент найден");
            //writeFoundElementInFile();
        } else {
            System.out.println("Элемент не найден");
        }
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
