package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.ReadFileInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputFileStrategy implements IStrategy{
    DataObject dataObject;

    public InputFileStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    ReadFileInput readFileInput = new ReadFileInput(dataObject);

    public void selectFileRead() throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выбери тип для заполнения из файла:\n" +
                    "1 - car, 2 - book, 3 - root vegetable");
            int choose = scanner.nextInt();
            System.out.println("Введите количество создаваемых объектов");
            int count = scanner.nextInt();
            switch (choose) {
                case 1: {
                    readFileInput.loadCarCSV(count);
                    break;
                }
                case 2: {
                    readFileInput.loadBooksCSV(count);
                    break;
                }
                case 3: {
                    readFileInput.loadRootVegetableCSV(count);
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
            selectFileRead();
        }catch (ValidationException validationException){
            System.out.println(validationException.getMessage());
        }

        return "";
    }
}
