package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;

import static com.sorting_app.utils.ConstUtil.FILE_PATH;


public class Record {
    private final DataObject dataObject;

    public Record(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public void recordCar() throws ValidationException {

        try {
            Files.writeString(Paths.get(FILE_PATH),
                        "\n-------------------\n" +
                            "Добавленные автомобили:\n" +
                            "Модель, Мощность, Год выпуска\n"
                    ,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            for (Car car : dataObject.getCars()) {
                String line = car.getModel() + "," + car.getPower() + "," + car.getYear() + "\n";
                Files.writeString(Paths.get(FILE_PATH), line, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public void recordCar(List<Car> cars) throws ValidationException {

        try {
            Files.writeString(Paths.get(FILE_PATH),
                    "\n-------------------\n" +
                            "Добавленные автомобили:\n" +
                            "Модель, Мощность, Год выпуска\n"
                    ,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            for (Car car : cars) {
                String line = car.getModel() + "," + car.getPower() + "," + car.getYear() + "\n";
                Files.writeString(Paths.get(FILE_PATH), line, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public void recordBook() throws ValidationException {
        Path pathToFile = Paths.get(FILE_PATH);
        try {
            Files.writeString(Paths.get(FILE_PATH),
                    "\n-------------------\n" +
                            "Добавленные книги:\n" +
                            "Название, Автор, Кол-во страниц\n"
                    ,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            for (Book book : dataObject.getBooks()) {
                String line = book.getBook() + "," + book.getAuthor() + "," + book.getPages() + "\n";
                Files.writeString(pathToFile, line, StandardOpenOption.APPEND);
                System.out.println("Книги записаны в файл " + FILE_PATH);
            }
        } catch (IOException e) {
           throw new ValidationException("Ошибка при записи");
        }
    }

    public void recordBook(List<Book> books) throws ValidationException {

        try {
            Files.writeString(Paths.get(FILE_PATH),
                    "\n-------------------\n" +
                            "Добавленные книги:\n" +
                            "Название, Автор, Кол-во страниц\n"
                    ,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            for (Book book : books) {
                String line = book.getBook() + "," + book.getAuthor() + "," + book.getPages() + "\n";
                Files.writeString(Paths.get(FILE_PATH), line, StandardOpenOption.APPEND);
                System.out.println("Книги записаны в файл " + FILE_PATH);
            }
        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public void recordRootVegetable() throws ValidationException {

        try {
            Files.writeString(Paths.get(FILE_PATH),
                    "\n-------------------\n" +
                            "Добавленные овощи:\n" +
                            "Вид, Вес, Цвет\n"
                    ,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            for (RootVegetable vegetable : dataObject.getRootVegetables()) {
                String line = vegetable.getType() + "," + vegetable.getWeight() + ","
                        + vegetable.getColor() + "\n";
                Files.writeString(Paths.get(FILE_PATH), line, StandardOpenOption.APPEND);
                System.out.println("Книги записаны в файл " + FILE_PATH);
            }
        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public void recordRootVegetable(List<RootVegetable> rootVegetables) throws ValidationException {
        try {
            Files.writeString(Paths.get(FILE_PATH),
                    "\n-------------------\n" +
                            "Добавленные овощи:\n" +
                            "Вид, Вес, Цвет\n"
                    ,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            for (RootVegetable vegetable : rootVegetables) {
                String line = vegetable.getType() + "," + vegetable.getWeight() + ","
                        + vegetable.getColor() + "\n";
                Files.writeString(Paths.get(FILE_PATH), line, StandardOpenOption.APPEND);
                System.out.println("Книги записаны в файл " + FILE_PATH);
            }
        } catch (IOException e) {
            throw new ValidationException("Ошибка при записи");
        }
    }

    public static void clearFile() throws ValidationException {
        try {
            Files.newBufferedWriter(Path.of(FILE_PATH), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new ValidationException("Проверьте наличие файла");
        }
    }
}