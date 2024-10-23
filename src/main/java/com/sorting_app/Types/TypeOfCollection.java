package com.sorting_app.Types;

public enum TypeOfCollection {
    CAR("Car"),
    BOOK("Book"),
    ROOTVEGETABLES("RootVegetables");

    private String text;

    TypeOfCollection(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
