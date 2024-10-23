package com.sorting_app.input;

import com.sorting_app.model.Book;
import com.sorting_app.model.Car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInputBook {
    private List<Book> loadBookList = new ArrayList<>();
    private List<Book> generateBook = new ArrayList<>();

    public RandomInputBook(String bookFilePath) {
        loadBooksCSV(bookFilePath);
    }

    //Метод для загрузки данных из файла
    public void loadBooksCSV(String bookFilePath) {
        File file = new File(bookFilePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;//храним строку из файла
            while ((line = reader.readLine()) != null) {
                //разбиваем строку файла на отдельные значения
                //строка разбивается на массив
                String[] values = line.split(",");
                if (values.length == 3) {

                    String name = values[0].trim();
                    String autor = values[1].trim();
                    int pages = Integer.parseInt(values[2].trim());
                    loadBookList.add(new Book.BookBuilder().setBook(name)
                            .setAuthor(autor)
                            .setPages(pages)
                            .build());
                    //Проверка наполнения loadBookList
                    System.out.println("Загружено книг" + loadBookList.size());
                    System.out.println("записанные книги" + loadBookList.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод для рандомной генерации списка книг
    //count - выбор кол-ва книг для добавления
    public void generateBookList(int count) {
        Random random = new Random();
        generateBook.clear();
        System.out.println("Рандомные книги");
        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(loadBookList.size());
            Book randomeBook = loadBookList.get(randomIndex);
            generateBook.add(randomeBook);
        }
    }


    //Метод для вывода списка книг

    public void printBookList() {
        if (generateBook.isEmpty()) {
            System.out.println("Список книг  пустой");
        } else {
            System.out.println("Список книг:");
            for (int i = 0; i < generateBook.size(); i++) {
                System.out.println(generateBook.get(i));
            }
        }
    }
}

