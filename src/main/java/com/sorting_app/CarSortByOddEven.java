package com.sorting_app;

import com.sorting_app.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarSortByOddEven {
    private final List<Car> list;

    public CarSortByOddEven(List<Car> list) {
        this.list = list;
    }

    private final Comparator<Car> carComparator = Comparator.comparingInt(Car::getPower);

    public void sort() {
        List<Car> listEven = new ArrayList<>();

        for (Car car : list) {
            if (car.getPower() % 2 == 0) {
                listEven.add(car);
            }
        }

        listEven.sort(carComparator);

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPower() % 2 != 0) {
                continue;
            }

            list.set(i, listEven.get(count++));
        }
    }
}
