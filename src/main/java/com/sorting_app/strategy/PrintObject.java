package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;

import java.util.Scanner;

public class PrintObject implements IStrategy {
    DataObject dataObject;

    public PrintObject(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    private void selectPrint() throws ValidationException{

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите цифру от 1 до 3 для вывода объекта\n1 - CAR;  2 - BOOK;  3 - ROOT_VEGETABLE");

        }catch (Exception e){
            throw new ValidationException("");
        }
    }


    @Override
    public String getResult() {

        return "";
    }
}
