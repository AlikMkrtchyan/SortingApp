package com.sorting_app.utils;

import com.sorting_app.data.DataObject;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchStrategy {
    private DataObject dataObject;

    public SearchStrategy(DataObject dataObject) {
        this.dataObject = dataObject;
    }
    public List<Book> findBooks() {
        List<Book> result = new ArrayList<>();
        System.out.println("\nПоиск книг в коллекции\n".toUpperCase());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи название книги");
        String name = scanner.nextLine();
        System.out.println("Введи автора");
        String author = scanner.nextLine();
        System.out.println("Введи кол-во страниц");
        int pages = scanner.nextInt();
        if (name.isEmpty()) {
            name = null;
        }
        if (author.isEmpty()) {
            author = null;
        }
        Book book = new Book.BookBuilder().setBook(name)
                .setAuthor(author)
                .setPages(pages)
                .build();
        int count = BinarySearch.binarySearch(dataObject.getBooks(), book);
        if(count >= 0){result.add(dataObject.getBooks().get(count));}
        System.out.println(
                "Всего найдено совпадений: ".toUpperCase() + result.size() + "\n" +
                result);
        return result;
    }

    public List<Car> findСar() {
        List<Car> result = new ArrayList<>();
        System.out.println("\nПоиск машин в коллекции\n".toUpperCase());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи модель");
        String model = scanner.nextLine();
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
        int count = BinarySearch.binarySearch(dataObject.getCars(), car);
        if(count >= 0){result.add(dataObject.getCars().get(count));}
        System.out.println(
                "Всего найдено совпадений: ".toUpperCase() + result.size() + "\n" +
                        result);
        return result;
    }

    public List<RootVegetable> findRootVegetable() {
        List<RootVegetable> result = new ArrayList<>();
        System.out.println("\nПоиск корнеплодов в коллекции\n".toUpperCase());
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
        int count = BinarySearch.binarySearch(dataObject.getRootVegetables(), rootVegetable);
        if(count >= 0) result.add(dataObject.getRootVegetables().get(count));
        System.out.println(
                "Всего найдено совпадений: ".toUpperCase() + result.size() + "\n");
        return result;
    }

/*    public List<Car> findCars() {
        List<Car> result = new ArrayList<>();
        if (dataObject.getCars() != null) {
            for (Car car : dataObject.getCars()) {
                String model = car.getModel();
                Integer year = car.getYear();


                if ((model != null && model.equalsIgnoreCase(criteria)) ||
                        (year != null && year.toString().equals(criteria))) {
                    result.add(car);
                }
            }
        }
        return result;
    }

    public List<RootVegetable> findRootVegetables() {
        List<RootVegetable> result = new ArrayList<>();
        if (dataObject.getRootVegetables() != null) {
            for (RootVegetable rootVegetable : dataObject.getRootVegetables()) {
                String type = rootVegetable.getType();
                Integer weight = rootVegetable.getWeight();
                String color = rootVegetable.getColor();


                if ((type != null && type.equalsIgnoreCase(criteria)) ||
                        (weight != null && weight.toString().equals(criteria)) ||
                        (color != null && color.equalsIgnoreCase(criteria))) {
                    result.add(rootVegetable);
                }
            }
        }
        return result;
    }*/

}