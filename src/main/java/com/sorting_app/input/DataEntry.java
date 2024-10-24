package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.util.InputMismatchException;
import java.util.Scanner;


public class DataEntry {
    DataObject dataObject = new DataObject();

    public void selectObject() throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выбери тип для заполнения:\n" +
                    "1 - car, 2 - book, 3 - root vegetable");
            int choosse = scanner.nextInt();
            System.out.println("Введите количество создаваемых объектов");
            int count = scanner.nextInt();
            for (int i = 1; i < count+1; i++){
                System.out.println("Создаваемый объект №"+i);
                switch (choosse) {
                    case 1:
                        inputCar();
                        break;
                    case 2:
                        inputBook();
                        break;
                    case 3:
                        inputRootVegetable();
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

    public void inputCar() throws ValidationException {
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
            Car car = new Car.CarBuilder().setModel(model)
                    .setPower(power)
                    .setYear(year)
                    .build();
            dataObject.addCar(car);
        } catch (InputMismatchException exception) {
            throw new ValidationException("Введен неверный тип данных");
        }

    }

    public void inputBook() throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введи название книги");
            String name = scanner.nextLine();
            System.out.println("Введи автора");
            String autor = scanner.nextLine();
            System.out.println("Введи кол-во страниц");
            int pages = scanner.nextInt();
            if (name.isEmpty()) {
                name = null;
            }
            if (autor.isEmpty()) {
                autor = null;
            }
            Book book = new Book.BookBuilder().setBook(name)
                    .setAuthor(autor)
                    .setPages(pages)
                    .build();
            dataObject.addBook(book);
        } catch (InputMismatchException exception) {
            throw new ValidationException("Введен неверный тип данных");
        }
    }

    public void inputRootVegetable() throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введи тип");
            String type = scanner.nextLine();
            System.out.println("Введи вес");
            int weight = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введи цвет");
            String color = scanner.nextLine();
            if (type.isEmpty()) {
                type = null;
            }
            if (color.isEmpty()) {
                color = null;
            }
            RootVegetable rootVegetable =
                    new RootVegetable.RootVegetableBuilder().setType(type)
                            .setWeight(weight)
                            .setColor(color)
                            .build();
            dataObject.addRootVegetable(rootVegetable);
        } catch (InputMismatchException exception) {
            throw new ValidationException("Введен неверный тип данных");
        }
    }

    //методы вывода данных Объектов
    public void printCars() {
        if (dataObject.getCars().isEmpty()) {
            System.out.println("Нет машин в списке");
        } else {
            for (Car car : dataObject.getCars()) {
                System.out.println(car);
            }
        }
    }

    public void printBooks() {
        if (dataObject.getBooks().isEmpty()) {
            System.out.println("Нет книг в списке");
        } else {
            for (Book book : dataObject.getBooks()) {
                System.out.println(book);
            }
        }
    }

    public void printRootVegetable() {
        if (dataObject.rootVegetables.isEmpty()) {
            System.out.println("Нет корнеплода в списке");
        } else {
            for (RootVegetable rootVegetable : dataObject.rootVegetables) {
                System.out.println(rootVegetable);
            }
        }
    }
}