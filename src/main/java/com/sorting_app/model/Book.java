package com.sorting_app.model;


import java.util.Comparator;

public class Book implements Comparable<Book> {
    private final String name;
    private final String author;
    private final int pages;

    private Book(BookBuilder builder) {
        this.name = builder.name;
        this.author = builder.author;
        this.pages = builder.pages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public int compareTo(Book o) {
        return Comparator.comparing(Book::getName)
                .thenComparing(Book::getAuthor)
                .thenComparingInt(Book::getPages)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("Книга: %s; Автор: %s; Страницы: %d",
                name, author, pages);
    }

    public static class BookBuilder {
        public String name;
        private String book;
        private String author;
        private int pages;

        public BookBuilder() {
        }

        public BookBuilder setBook(String name) {
            this.name = name;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
