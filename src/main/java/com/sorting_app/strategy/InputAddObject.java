package com.sorting_app.strategy;

import com.sorting_app.input.ConsoleInput;
import com.sorting_app.input.DataEntry;

public class InputAddObject implements IStrategy{

    DataEntry dataEntry = new DataEntry();
    ConsoleInput consoleInput = new ConsoleInput(dataEntry);


    @Override
    public String getResult() {
        consoleInput.runObject();
        return "Ввод данных в коллекцию выполнен";
    }
}