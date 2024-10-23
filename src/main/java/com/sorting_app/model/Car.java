package com.sorting_app.model;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private  String model;
    private  int power;
    private  int year;

    public Car(CarBuilder carBuilder) {
        this.model = carBuilder.model;
        this.power = carBuilder.power;
        this.year = carBuilder.year;
    }

    public Car(String model, int power, int year) {
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Car o) {
        return Comparator.comparing(Car::getModel)
                .thenComparingInt(Car::getPower)
                .thenComparingInt(Car::getYear)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("Модель: %s; Мощность: %d; Год производства: %d",
                model, power, year);
    }

    public static class CarBuilder {
        private String model;
        private int power;
        private int year;

        public CarBuilder() {
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setPower(int power) {
            this.power = power;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
