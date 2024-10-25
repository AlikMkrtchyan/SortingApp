package com.sorting_app.ExecutionCycle;

import com.sorting_app.data.DataObject;
import com.sorting_app.strategy.IStrategy;

public class Context {
    //private DataObject dataObject;
    private IStrategy strategy;

    //public Context(DataObject dataObject) {
    //    this.dataObject = dataObject;
    //}

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void commandSelected() {
        strategy.getResult();
    }
}
