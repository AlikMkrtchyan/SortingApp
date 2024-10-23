package com.sorting_app;


import com.sorting_app.handler.ValidationException;
import com.sorting_app.list.ClassesList;

public class Main {
    public static void main(String[] args) {
        ClassesList list = new ClassesList();
        while (true){
            try {
                list.InputBook();
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
            list.printBooks();
        }


    }
}