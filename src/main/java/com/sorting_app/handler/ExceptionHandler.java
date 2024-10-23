package com.sorting_app.handler;


public class ExceptionHandler {

    public static boolean handlerEmpty(String field){
        if(field.isEmpty()) {field = null;}
        return true;

    }
}