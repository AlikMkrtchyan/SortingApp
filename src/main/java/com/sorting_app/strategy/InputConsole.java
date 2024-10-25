package com.sorting_app.strategy;

import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.ConsoleInput;

public class InputConsole implements IStrategy{

    ConsoleInput consoleInput;


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