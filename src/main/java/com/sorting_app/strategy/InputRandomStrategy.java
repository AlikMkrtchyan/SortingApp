package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.RandomInput;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InputRandomStrategy implements IStrategy{
    DataObject dataObject;

    public InputRandomStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    RandomInput randomInput = new RandomInput(dataObject);

    private void selectRandomObject() throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выбери тип для рандомного заполнения:\n" +
                    "1 - car, 2 - book, 3 - root vegetable");
            int choose = scanner.nextInt();
            System.out.println("Введите количество создаваемых объектов");
            int count = scanner.nextInt();
            switch (choose) {
                case 1: {
                    randomInput.loadCarCSV();
                    randomInput.generateCarList(count);
                    break;
                }
                case 2: {
                    randomInput.loadBooksCSV();
                    randomInput.generateBookList(count);
                    break;
                }
                case 3: {
                    randomInput.loadRootVegetableCSV();
                    randomInput.generateRootVegetables(count);
                    break;
                }
                default:
                    System.out.println("Неверный ввод, введите цифру от 1 до 3");
            }
        } catch (InputMismatchException e) {
            throw new ValidationException("Неверный ввод, введите цифры от 1 до 3");
        } catch (Exception e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }


    @Override
    public String getResult() {
        try {
           selectRandomObject();
        }catch (ValidationException validationException){
            System.out.println(validationException.getMessage());
        }
        return "<<<Выборочное добавление данных в коллекцию выполнено>>>";
    }
}
