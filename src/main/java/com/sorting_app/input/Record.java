package com.sorting_app.input;

import com.sorting_app.data.DataObject;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Record {
    private static final String FILE_PATH = "src/main/resources/Record.csv";

    //Запись машин
    public void recordCar(DataObject dataObject) {
        Path pathToFile = Paths.get(FILE_PATH);

        try {
            //Добавляю заголовок каждый раз при записи нового списка
            Files.writeString(pathToFile, "\n-------------------\nДобавленные автомобили:\n" +
                            "Модель, Мощность, Год выпуска\n"
                    , StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            for (Car car : dataObject.getCars()) {
                String line = car.getModel() + "," + car.getPower() + "," + car.getYear() + "\n";
                Files.writeString(pathToFile, line, StandardOpenOption.APPEND);
                System.out.println("Автомобили записаны в файл " + FILE_PATH);
            }

        } catch (IOException e) {
            System.out.println("Ошибка при записи");
        }
    }

    //Запись книг
    public void recordBook(DataObject dataObject) {
        Path pathToFile = Paths.get(FILE_PATH);

        try {
            //Добавляю заголовок каждый раз при записи нового списка
            Files.writeString(pathToFile, "\n-------------------\nДобавленные книги:\n" +
                            "Название, Автор, Кол-во страниц\n"
                    , StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            for (Book book : dataObject.getBooks()) {
                String line = book.getBook() + "," + book.getAuthor() + "," + book.getPages() + "\n";
                Files.writeString(pathToFile, line, StandardOpenOption.APPEND);
                System.out.println("Книги записаны в файл " + FILE_PATH);
            }

        } catch (IOException e) {
            System.out.println("Ошибка при записи");
        }
    }

    //Запись овощей
    public void recordRootVagetable(DataObject dataObject) {
        Path pathToFile = Paths.get(FILE_PATH);

        try {
            //Добавляю заголовок каждый раз при записи нового списка
            Files.writeString(pathToFile, "\n-------------------\nДобавленные овощи:\n" +
                            "Вид, Вес, Цвет\n"
                    , StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            for (RootVegetable vegetable : dataObject.getRootVegetables()) {
                String line = vegetable.getType() + "," + vegetable.getWeight() + ","
                        + vegetable.getColor() + "\n";
                Files.writeString(pathToFile, line, StandardOpenOption.APPEND);
                System.out.println("Книги записаны в файл " + FILE_PATH);
            }

        } catch (IOException e) {
            System.out.println("Ошибка при записи");
        }
    }

    //Удаление файла
    public void deleteFile() {
        Path pathToFile = Paths.get(FILE_PATH);

        try {
            Files.delete(pathToFile);
        } catch (IOException e) {
            //deleting file failed
            e.printStackTrace();
        }
    }


}
