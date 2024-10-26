package com.sorting_app;
import com.sorting_app.model.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookSortByOddEven {
    private final List<Book> list;

    public BookSortByOddEven(List<Book> list) {
        this.list = list;
    }

    private final Comparator<Book> bookComparator = Comparator.comparingInt(Book::getPages);

    public void sort() {
        List<Book> listEven = new ArrayList<>();

        for (Book book : list) {
            if (book.getPages() % 2 == 0) {
                listEven.add(book);
            }
        }

        listEven.sort(bookComparator);

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPages() % 2 != 0) {
                continue;
            }

            list.set(i, listEven.get(count++));
        }
    }
}
