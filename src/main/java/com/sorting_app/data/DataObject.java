package com.sorting_app.data;

import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.util.ArrayList;
import java.util.List;

public class DataObject {

    public List<Book> books;
    public List<Car> cars;
    public List<RootVegetable> rootVegetables;

    public DataObject(List<Book> books, List<Car> cars, List<RootVegetable> rootVegetables) {
        this.books = books;
        this.cars = cars;
        this.rootVegetables = rootVegetables;
    }

    public DataObject() {
        this.books = new ArrayList<>();
        this.cars = new ArrayList<>();
        this.rootVegetables = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<RootVegetable> getRootVegetables() {
        return rootVegetables;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addRootVegetable(RootVegetable rootVegetable) {
        rootVegetables.add(rootVegetable);
    }

/*    public void add(Object object) {
        if (object instanceof Book)
            add((Book) object);
        else if (object instanceof Car)
            add((Car) object);
        else if (object instanceof RootVegetable)
            add((RootVegetable) object);
    }

    public void add(List<Object> list) {
        list.forEach(this::add);
    }*/


}
