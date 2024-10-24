package com.sorting_app;

import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.RandomInput;
import com.sorting_app.strategy.InputConsole;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        InputConsole inputAddObject = new InputConsole();
        RandomInput randomInput = new RandomInput();

        while (true) {
            try {
                randomInput.selectRandomObject();
                randomInput.printCarList();
                randomInput.printBookList();
                randomInput.printRootVegetables();
            } catch (ValidationException validationException) {
                System.out.println(validationException.getMessage());
            }

        }
    }
}