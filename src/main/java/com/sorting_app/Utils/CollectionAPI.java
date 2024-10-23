package com.sorting_app.Utils;

import com.sorting_app.Book;
import com.sorting_app.Car;
import com.sorting_app.RootVegetables;
import com.sorting_app.Types.TypeOfCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionAPI {
    private static Scanner scanner = new Scanner(System.in);

    public static String choiceOfTypeCollection() {
        boolean correct = false;
        String typeOfCollection = "";
        while (!correct) {
            System.out.println("Укажите тип коллекции: Car, Book, RootVegetables.");
            typeOfCollection = scanner.nextLine();

            if (isCorrectTypeOfCollection(typeOfCollection)) {
                correct = true;
            }
            else {
                System.out.println("Неверный тип. Попробуйте заново");
            }
        }
        return typeOfCollection;
    }

    /// /// длина или размер? добавить обработку для нечислового значения
    public static Integer setLengthOfCollection() {
        boolean correct = false;
        Integer lengthOfCollection = 0;
        while (!correct) {
            System.out.println("Укажите длину коллекции(целое число, не больше 100)"); /// ?
            lengthOfCollection = scanner.nextInt();
            if (lengthOfCollection > 100) {
                System.out.println("Длина не может быть больше 100 элементов. Попробуйте заново.");
            }

            correct = true;
        }
        return lengthOfCollection;
    }

    public static boolean isCorrectTypeOfCollection(String typeOfCollection) {
        return typeOfCollection.equals(TypeOfCollection.CAR.toString())
                || typeOfCollection.equals(TypeOfCollection.BOOK.toString())
                || typeOfCollection.equals(TypeOfCollection.ROOTVEGETABLES.toString());
    }


    /// изменить на необходимую коллекцию
    public static List initCollection(String typeOfCollection, Integer lengthOfCollection) {
        if (typeOfCollection.equals(TypeOfCollection.CAR.toString())) {
            return new ArrayList<Car>(lengthOfCollection);
        }
        else if (typeOfCollection.equals(TypeOfCollection.BOOK.toString())) {
            return new ArrayList<Book>(lengthOfCollection);
        }
        else {
            return new ArrayList<RootVegetables>(lengthOfCollection);
        }
    }

    public static void addElementsInCollectionFromFile() {

    }

    public static void addElementsInCollectionFromRandom() {

    }

    public static void addElementsInCollectionFromManually(List collectionList, String typeOfCollection, Integer lengthOfCollection) {
        int i = 0;
        boolean stop = false;

        if (typeOfCollection.equals(TypeOfCollection.CAR.toString())) {

            int power;
            String model;
            int year;

            while ((i < lengthOfCollection) && (!stop)) {
                Car car = new Car();
                System.out.println("Введите мощность автомобиля(от 0 до 2300): ");
                power = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Введите модель автомобиля: ");
                model = scanner.nextLine();
                System.out.println("Введите год производства автомобиля: ");
                year = scanner.nextInt();
                scanner.nextLine();

                collectionList.add(car.builder()
                        .power(power)
                        .model(model)
                        .year(year)
                        .build());
                i++;
                if (i != lengthOfCollection){
                    System.out.println("Для того, чтобы прекратить добавления элементов в коллекцию напишите stop.");
                    if (scanner.nextLine().equals("stop")) {
                        stop = true;
                    }
                }
            }
        }
        else if (typeOfCollection.equals(TypeOfCollection.BOOK.toString())) {

        }
        else if (typeOfCollection.equals(TypeOfCollection.ROOTVEGETABLES.toString())) {

        }
        else {
            System.out.println("Не работает");
        }
    }
}
