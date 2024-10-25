package com.sorting_app.input;

import com.sorting_app.model.Car;
import com.sorting_app.model.Book;
import com.sorting_app.model.RootVegetable;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterCSV {

    //Запись машин. Берем список машин созданный.
    public void writeCars(List<Car> carList, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //Заголовок списка
            writer.write("Модель, Мощность, Год выпуска \n");

            for (Car car : carList) {
                writer.write(car.getModel() +
                        "," + car.getPower() + "," + car.getYear());
                writer.newLine();
            }
            System.out.println("Записали в " + fileName);

        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи автомобилей в файл");
           // e.printStackTrace();
        }
    }

    //Запись книг
    public void writeBooks(List<Book> bookList, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //Заголовок списка
            writer.write("Название, Автор, Кол-во страниц \n");

            for (Book book : bookList) {
                writer.write(book.getBook() +
                        "," + book.getAuthor() + "," + book.getPages());
                writer.newLine();
            }
            System.out.println("Записали в " + fileName);

        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи автомобилей в файл");
           // e.printStackTrace();
        }
    }

//    Запись корнеплодов
    public void writeKorneplods(List<RootVegetable> korneplodList, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //Заголовок списка
            writer.write("Вид, Вес, Цвет \n");

            for (RootVegetable korn : korneplodList) {
                writer.write(korn.getType() +
                        "," + korn.getWeight() + "," + korn.getColor());
                writer.newLine();
            }
            System.out.println("Записали в " + fileName);

        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи автомобилей в файл");
           // e.printStackTrace();
        }
    }
}



