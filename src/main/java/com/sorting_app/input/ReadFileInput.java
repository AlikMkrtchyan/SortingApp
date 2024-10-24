package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Car;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadFileInput {
    RandomInput randomInput = new RandomInput();
    DataObject dataObject = new DataObject();

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
                    randomInput.loadCarCSV(dataObject.getCars(), count);
                    break;
                }
                case 2: {
                    randomInput.loadBooksCSV(dataObject.getBooks());
                    break;
                }
                case 3: {
                    randomInput.loadRootVegetableCSV(dataObject.getRootVegetables());
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

    public void printCarsFileRead() {
        if (dataObject.getCars().isEmpty()) {
            System.out.println("Нет машин в списке");
        } else {
            for (Car car : dataObject.getCars()) {
                System.out.println(car);
            }
        }
    }
}
