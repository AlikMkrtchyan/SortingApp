package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;

import java.util.Scanner;

public class PrintObjectStrategy implements IStrategy {
    DataObject dataObject;

    public PrintObjectStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    private void selectPrint() throws ValidationException{
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите цифру от 1 до 3 для вывода объекта\n1 - CAR;  2 - BOOK;  3 - ROOT_VEGETABLE");
            int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        dataObject.printCars();
                        break;
                    case 2:
                        dataObject.printBooks();
                        break;
                    case 3:
                        dataObject.printRootVegetable();
                        break;
                    default:
                        System.out.println("Неверный ввод, введите цифру от 1 до 3");
                        break;
            }
        }catch (Exception e){
            throw new ValidationException("Система вышла из строя вывод объекта не возможен");
        }
    }

    @Override
    public String getResult() {
        try {
            selectPrint();
        }catch (ValidationException validationException){
            System.out.println(validationException.getMessage());
        }
        return "<<<УСПЕШНО ВЫПОЛНЕНО>>>";
    }
}
