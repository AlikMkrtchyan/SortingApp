package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;

public class PrintObject implements IStrategy {
    DataObject dataObject;

    public PrintObject(DataObject dataObject) {
        this.dataObject = dataObject;
    }


    @Override
    public String getResult() {

        return "";
    }
}
