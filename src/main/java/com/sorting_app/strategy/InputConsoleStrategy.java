package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.ConsoleInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputConsoleStrategy implements IStrategy {
    DataObject dataObject;

    public InputConsoleStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }


    private void selectObject() throws ValidationException {
        ConsoleInput consoleInput = new ConsoleInput(dataObject);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выбери тип для заполнения:\n" +
                    "1 - car, 2 - book, 3 - root vegetable");
            int choose = scanner.nextInt();
            System.out.println("Введите количество создаваемых объектов");
            int count = scanner.nextInt();
            for (int i = 1; i < count + 1; i++) {
                System.out.println("Создаваемый объект №" + i);
                switch (choose) {
                    case 1:
                        consoleInput.inputCar();
                        break;
                    case 2:
                        consoleInput.inputBook();
                        break;
                    case 3:
                        consoleInput.inputRootVegetable();
                        break;
                    default:
                        System.out.println("Неверный ввод, введите цифру от 1 до 3");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            throw new ValidationException("Введен неверный тип данных");
        }
    }

    @Override
    public String getResult() {
        try {
           selectObject();
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }
        return "<<<Добавление данных в коллекцию в ручном режиме выполнен>>>".toUpperCase();
    }
}