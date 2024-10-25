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
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadFileInput {
    private final DataObject dataObject;

    public ReadFileInput(DataObject dataObject){this.dataObject = dataObject;}

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
                   loadCarCSV(count);
                    break;
                }
                case 2: {
                   loadBooksCSV(count);
                    break;
                }
                case 3: {
                    loadRootVegetableCSV(count);
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

    public void loadBooksCSV(int count) throws ValidationException {
        File file = new File(RandomInput.FILE_PATH_BOOK);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            for(int i = 0; i < count; i++){
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String name = values[0].trim();
                    String author = values[1].trim();
                    int pages = Integer.parseInt(values[2].trim());
                    dataObject.addBook(new Book.BookBuilder()
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

    public void loadCarCSV(int count) throws ValidationException {
        File file = new File(RandomInput.FILE_PATH_CAR);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            //храним строку из файла
            for(int i = 0; i < count; i++){
                line = reader.readLine();
                //разбиваем строку файла на отдельные значения
                //строка разбивается на массив
                String[] values = line.split(",");
                if (values.length == 3) {
                    String model = values[0].trim();
                    int power = Integer.parseInt(values[1].trim());
                    int year = Integer.parseInt(values[2].trim());
                    dataObject.addCar(new Car.CarBuilder().setModel(model)
                            .setPower(power)
                            .setYear(year)
                            .build());
                }
            }
        } catch (IOException e) {
            throw new ValidationException("Проверьте файл на соответствие");
        }
    }

    public void loadRootVegetableCSV(int count) throws ValidationException {
        File file = new File(RandomInput.FILE_PATH_ROOT_VEGETABLE);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for(int i = 0; i < count; i++){
                String line;
                line = reader.readLine();
                String[] values = line.split(",");
                if (values.length == 3) {
                    String type = values[0].trim();
                    int weight = Integer.parseInt(values[1].trim());
                    String color = values[2].trim();
                    dataObject.addRootVegetable(new RootVegetable.RootVegetableBuilder()
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

}