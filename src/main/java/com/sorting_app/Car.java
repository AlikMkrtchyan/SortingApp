package com.sorting_app;

public class Car {
    // мощность, л.с.
    private int power;
    // модель
    private String model;
    // год производства
    private int year;

    public Car(){}

    public Car(int power, String model, int year) {
        this.power = power;
        this.model = model;
        this.year = year;
    }

    public CarBuilder builder() {
        return new CarBuilder();
    }


    @Override
    public String toString() {
        return String.format("%d %s %d", power, model, year);
    }
}
