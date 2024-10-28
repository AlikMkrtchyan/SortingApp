package com.sorting_app;

import com.sorting_app.execution_cycle.ExecutionCycle;

public class Main {
    public static void main(String[] args) {

        DataObject dataObject = new DataObject();

        ExecutionCycle executionCycle = new ExecutionCycle(dataObject);

        executionCycle.run();


    }
}