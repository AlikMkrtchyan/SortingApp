package com.sorting_app.handler;

import com.sorting_app.model.Car;

public class ExceptionHandler {

    public static boolean handlerEmpty(String field){
        if(field.isEmpty()) {field = null;}
        return true;

    }
}
