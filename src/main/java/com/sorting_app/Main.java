package com.sorting_app;

import com.sorting_app.ExecutionCycle.ExecutionCycle;
import com.sorting_app.data.DataObject;
import com.sorting_app.strategy.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DataObject dataObject = new DataObject();
        ExecutionCycle executionCycle = new ExecutionCycle(dataObject);
        executionCycle.run();

    }
}