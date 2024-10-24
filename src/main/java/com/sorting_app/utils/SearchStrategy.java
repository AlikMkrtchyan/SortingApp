package com.sorting_app.utils;

import com.sorting_app.data.DataObject;
import com.sorting_app.model.Book;
import com.sorting_app.model.Car;
import com.sorting_app.model.RootVegetable;

import java.util.ArrayList;
import java.util.List;

public class SearchStrategy {
    private DataObject dataObject;
    private String criteria;

    public SearchStrategy(DataObject dataObject, String criteria) {
        this.dataObject = dataObject;
        this.criteria = criteria;
    }

    public List<Book> findBooks() {
        List<Book> result = new ArrayList<>();
        if (dataObject.books != null) {
            for (Book book : dataObject.books) {
                String title = book.getBook();
                String author = book.getAuthor();


                if ((title != null && title.equalsIgnoreCase(criteria)) ||
                        (author != null && author.equalsIgnoreCase(criteria))) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    public List<Car> findCars() {
        List<Car> result = new ArrayList<>();
        if (dataObject.cars != null) {
            for (Car car : dataObject.cars) {
                String model = car.getModel();
                Integer year = car.getYear();


                if ((model != null && model.equalsIgnoreCase(criteria)) ||
                        (year != null && year.toString().equals(criteria))) {
                    result.add(car);
                }
            }
        }
        return result;
    }

    public List<RootVegetable> findRootVegetables() {
        List<RootVegetable> result = new ArrayList<>();
        if (dataObject.rootVegetables != null) {
            for (RootVegetable rootVegetable : dataObject.rootVegetables) {
                String type = rootVegetable.getType();
                Integer weight = rootVegetable.getWeight();
                String color = rootVegetable.getColor();


                if ((type != null && type.equalsIgnoreCase(criteria)) ||
                        (weight != null && weight.toString().equals(criteria)) ||
                        (color != null && color.equalsIgnoreCase(criteria))) {
                    result.add(rootVegetable);
                }
            }
        }
        return result;
    }

    public String getResult() {
        StringBuilder resultBuilder = new StringBuilder();

        List<Book> books = findBooks();
        if (!books.isEmpty()) {
            resultBuilder.append("Найден(ы) книги:\n");
            for (Book book : books) {
                resultBuilder.append(book.toString()).append("\n");
            }
        }

        List<Car> cars = findCars();
        if (!cars.isEmpty()) {
            resultBuilder.append("Найден(ы) машины:\n");
            for (Car car : cars) {
                resultBuilder.append(car.toString()).append("\n");
            }
        }

        List<RootVegetable> rootVegetables = findRootVegetables();
        if (!rootVegetables.isEmpty()) {
            resultBuilder.append("Найден(ы) корнеплоды:\n");
            for (RootVegetable rootVegetable : rootVegetables) {
                resultBuilder.append(rootVegetable.toString()).append("\n");
            }
        }

        if (resultBuilder.length() == 0) {
            return "По заданным критериям ничего не найдено.";
        }

        return resultBuilder.toString();
    }
}