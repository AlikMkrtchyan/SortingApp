package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Car;


import java.util.InputMismatchException;
import java.util.Scanner;

public class BinarySearchStrategy implements IStrategy {
    private final DataObject dataObject;

    public BinarySearchStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    private Car carSearch() throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введи модель");
            String model = scanner.nextLine().strip().toUpperCase();
            System.out.println("Введи мощность");
            int power = scanner.nextInt();
            System.out.println("Введи год выпуска");
            int year = scanner.nextInt();
            if (model.isEmpty()) {
                model = null;
            }
            return new Car.CarBuilder().setModel(model)
                    .setPower(power)
                    .setYear(year)
                    .build();
        } catch (InputMismatchException exception) {
            throw new ValidationException("Введен неверный тип данных");
        }
    }

    private void selectBinarySearch() throws ValidationException {
    }


    @Override
    public void getResult() {
        try {
            selectBinarySearch();
        } catch (ValidationException validationException) {
            System.out.println(validationException.getMessage());
        }

    }
}
