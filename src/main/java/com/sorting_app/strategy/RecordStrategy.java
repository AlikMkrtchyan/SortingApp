package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.Record;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecordStrategy implements IStrategy {
    private final DataObject dataObject;

    public RecordStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public void selectedRecord() throws ValidationException {
        Record record = new Record(dataObject);
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nВыберите цифру от 1 до 4 для записи объекта в файл\n" +
                    "1 - АВТОМОБИЛЬ;  " +
                    "2 - КНИГИ;  " +
                    "3 - КОРНЕПЛОД  " +
                    "4 - ЗАПИСЬ ВСЕХ ОБЪЕКТОВ");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    record.recordCar();
                    break;
                }
                case 2: {
                    record.recordBook();
                    break;
                }
                case 3: {
                    record.recordRootVegetable();
                    break;
                }
                case 4: {
                    record.recordCar();
                    record.recordBook();
                    record.recordRootVegetable();
                    break;
                }
                default:
                    System.out.println("Неверный ввод, введите цифру от 1 до 4");
            }
        } catch (InputMismatchException e) {
            throw new ValidationException("Неверный ввод, введите цифры от 1 до 4");
        } catch (Exception e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }


    @Override
    public void getResult() {
        try {
            selectedRecord();
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }
    }
}
