package com.sorting_app.input;

import com.sorting_app.data.DataObject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {
    private final DataObject dataObject;

    public ConsoleInput(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public void addItem () {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выбери тип для заполнения:\n" +
                    "1- car,2 - book,3 - korneplod");
            int choosse = scanner.nextInt();
            scanner.nextLine();

            if (choosse == 1) {
                dataObject.getCars();
            }else if (choosse == 2) {
                dataObject.getBooks();
            }else if (choosse == 3) {
                dataObject.getRootVegetables();
            } else  {
                System.out.println("Неверный ввод");
            }
        } catch (InputMismatchException e){
            System.out.println("Неверный ввод");
        }

    }
}
