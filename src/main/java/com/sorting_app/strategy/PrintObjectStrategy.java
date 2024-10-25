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
            System.out.println("\nВыберите цифру от 1 до 4 для вывода объекта\n\n" +
                    "1 - АВТОМОБИЛЬ;  " +
                    "2 - КНИГИ;  " +
                    "3 - КОРНЕПЛОД  " +
                    "4 - ВЫВЕСТИ ВСЕ ОБЪЕКТЫ");
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
                    case 4: {
                        dataObject.printCars();
                        dataObject.printBooks();
                        dataObject.printRootVegetable();
                        break;
                    }
                    default:
                        System.out.println("Неверный ввод, введите цифру от 1 до 4");
                        break;
            }
        }catch (Exception e){
            throw new ValidationException("Система вышла из строя вывод объекта не возможен");
        }
    }

    @Override
    public void getResult() {
        try {
            selectPrint();
        }catch (ValidationException validationException){
            System.out.println(validationException.getMessage());
        }
        System.out.println("\n<<<УСПЕШНО ВЫПОЛНЕНО>>>\n");
    }
}