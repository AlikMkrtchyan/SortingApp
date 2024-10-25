package com.sorting_app;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;
import com.sorting_app.input.ConsoleInput;
import com.sorting_app.input.RandomInput;
import com.sorting_app.input.ReadFileInput;
import com.sorting_app.strategy.InputConsoleStrategy;
import com.sorting_app.strategy.InputFileStrategy;
import com.sorting_app.strategy.InputRandomStrategy;
import com.sorting_app.strategy.PrintObjectStrategy;


import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        DataObject dataObject = new DataObject();

        InputConsoleStrategy inputConsoleStrategy = new InputConsoleStrategy(dataObject);
        InputRandomStrategy inputRandomStrategy = new InputRandomStrategy(dataObject);
        InputFileStrategy inputFileStrategy = new InputFileStrategy(dataObject);
        PrintObjectStrategy printObjectStrategy = new PrintObjectStrategy(dataObject);

        //   DataObject dataObject = new DataObject();


        while (true) {



                inputConsoleStrategy.getResult();
                inputRandomStrategy.getResult();
                inputFileStrategy.getResult();

                printObjectStrategy.getResult();
        

        }
    }
}