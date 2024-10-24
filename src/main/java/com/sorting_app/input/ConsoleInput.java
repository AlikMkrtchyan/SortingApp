package com.sorting_app.input;

import com.sorting_app.handler.ValidationException;

import java.util.InputMismatchException;

public class ConsoleInput {
    private final DataEntry dataEntry;

    public ConsoleInput(DataEntry dataEntry) {
        this.dataEntry = dataEntry;
    }

    public void addItem() {
        try {
            dataEntry.selectObject();
        } catch (ValidationException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
