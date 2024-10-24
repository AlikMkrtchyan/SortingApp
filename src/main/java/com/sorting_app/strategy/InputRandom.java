package com.sorting_app.strategy;

import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.RandomInput;

public class InputRandom implements IStrategy{

    RandomInput randomInput = new RandomInput();


    @Override
    public String getResult() {
        try {
            randomInput.selectRandomObject();
        }catch (ValidationException validationException){
            System.out.println(validationException.getMessage());
        }
        return "Рандомный ввод данных в коллекцию выполнен";
    }
}
