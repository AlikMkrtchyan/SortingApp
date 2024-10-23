package com.sorting_app;

public class CarBuilder {
    private int power;
    private String model;
    private int year;

    public CarBuilder power(int power) {
        this.power = power;
        return this;
    }

    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder year(int year) {
        this.year = year;
        return this;
    }

    public Car build() {
        return new Car(power, model, year);
    }
}
