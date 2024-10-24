package com.sorting_app.strategy;

import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.ConsoleInput;

public class InputAddObject implements IStrategy{

    ConsoleInput consoleInput = new ConsoleInput();


    @Override
    public String getResult() {
        try {
            consoleInput.selectObject();
        }catch (ValidationException validationException){
            System.out.println(validationException.getMessage());
        }
        return "Ввод данных в коллекцию выполнен";
    }
}