package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RandomInput {
    private final List<Book> loadBookList = new ArrayList<>();
    private final List<Car> loadCarList = new ArrayList<>();
    private final List<RootVegetable> loadRootVegetableList = new ArrayList<>();
    private String line;
    DataObject dataObject;
    static final String FILE_PATH_BOOK = "src\\main\\resources\\KeepBook.csv";
    static final String FILE_PATH_CAR = "src\\main\\resources\\KeepCar.csv";
    static final String FILE_PATH_ROOT_VEGETABLE = "src\\main\\resources\\KeepRootVegetable.csv";


    public RandomInput(DataObject dataObject){this.dataObject = dataObject;}

    public void selectRandomObject() throws ValidationException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выбери тип для рандомного заполнения:\n" +
                    "1 - car, 2 - book, 3 - root vegetable");
            int choose = scanner.nextInt();
            System.out.println("Введите количество создаваемых объектов");
            int count = scanner.nextInt();
            switch (choose) {
                case 1: {
                    loadCarCSV();
                    generateCarList(count);
                    break;
                }
                case 2: {
                    loadBooksCSV();
                    generateBookList(count);
                    break;
                }
                case 3: {
                    loadRootVegetableCSV();
                    generateRootVegetables(count);
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

    public void loadCarCSV() throws ValidationException {
        File file = new File(FILE_PATH_CAR);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
           while (reader.readLine() != null){
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String model = values[0].trim();
                    int power = Integer.parseInt(values[1].trim());
                    int year = Integer.parseInt(values[2].trim());
                    loadCarList.add(new Car.CarBuilder().setModel(model)
                            .setPower(power)
                            .setYear(year)
                            .build());
                }
            }
        } catch (IOException e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }

    public void loadBooksCSV() throws ValidationException {
        File file = new File(FILE_PATH_BOOK);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null){
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String name = values[0].trim();
                    String author = values[1].trim();
                    int pages = Integer.parseInt(values[2].trim());
                    loadBookList.add(new Book.BookBuilder()
                            .setBook(name)
                            .setAuthor(author)
                            .setPages(pages)
                            .build());
                }
            }
        } catch (IOException e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }

    public void loadRootVegetableCSV() throws ValidationException {
        File file = new File(FILE_PATH_ROOT_VEGETABLE);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
           while (reader.readLine() != null){
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String type = values[0].trim();
                    int weight = Integer.parseInt(values[1].trim());
                    String color = values[2].trim();
                    loadRootVegetableList.add(new RootVegetable.RootVegetableBuilder()
                            .setType(type)
                            .setWeight(weight)
                            .setColor(color)
                            .build());
                }
            }
        } catch (IOException e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }

    public void generateCarList(int count) throws ValidationException {
        try {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int randomIndex = random.nextInt(loadCarList.size());
                Car randomeCar = loadCarList.get(randomIndex);
                dataObject.addCar(randomeCar);
            }
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Генерация автомобилей не возможна, проверьте файл на соответствие");
        }
    }

    public void generateBookList(int count) throws ValidationException {
        try {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int randomIndex = random.nextInt(loadBookList.size());
                Book randomeBook = loadBookList.get(randomIndex);
                dataObject.addBook(randomeBook);
            }
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Генерация Книг не возможна, проверьте файл на соответствие");
        }
    }

    public void generateRootVegetables(int count) throws ValidationException {
        try {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int randomIndex = random.nextInt(loadRootVegetableList.size());
                RootVegetable randomeRootVegetable = loadRootVegetableList.get(randomIndex);
                dataObject.addRootVegetable(randomeRootVegetable);
            }
        } catch (IllegalArgumentException e) {
            throw new ValidationException("Генерация корнеплодов не возможна, проверьте файл на соответствие");
        }
    }

}