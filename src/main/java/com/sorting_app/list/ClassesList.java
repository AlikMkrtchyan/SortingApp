package com.sorting_app.list;

import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.Korneplod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClassesList {
    private List<Car> carList;
    private List<Book> bookList;
    private List<Korneplod> korneplodList;

    public ClassesList() {
        carList = new ArrayList<>();
        bookList = new ArrayList<>();
        korneplodList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Korneplod> getKorneplodList() {
        return korneplodList;
    }

    public void addCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи модель");
        String model = scanner.nextLine();
        System.out.println("Введи мощность");
        int power = scanner.nextInt();
        System.out.println("Введи год выпуска");
        int year = scanner.nextInt();
        if(model.isEmpty()){model = null;}
        Car car = new Car.CarBuilder().setModel(model)
                .setPower(power)
                .setYear(year)
                .build();
        carList.add(car);
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи название книги");
        String name = scanner.nextLine();
        System.out.println("Введи автора");
        String autor = scanner.nextLine();
        System.out.println("Введи кол-во страниц");
        int pages = scanner.nextInt();
        if(name.isEmpty()){name = null;}
        if(autor.isEmpty()){autor = null;}
        Book book = new Book.BookBuilder().setBook(name)
                .setAuthor(autor)
                .setPages(pages)
                .build();
        bookList.add(book);
    }

    public void addKorneplod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи тип");
        String type = scanner.nextLine();
        System.out.println("Введи вес");
        Integer weight = scanner.nextInt();
        System.out.println("Введи цвет");
        String color = scanner.nextLine();
        if(type.isEmpty()){type = null;}
        if(color.isEmpty()){color = null;}
        Korneplod korneplod =
                new Korneplod.KorneplodBuilder().setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();
        korneplodList.add(korneplod);
    }

    //метод для вывода машин
    public void printCars() {
        if (carList.isEmpty()) {
            System.out.println("Нет машин в списке");
        } else {
            for (Car car : carList) {
                System.out.println(car);
            }
        }
    }


    public void printBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Нет книг в списке");
        } else {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

}
