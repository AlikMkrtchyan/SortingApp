package com.sorting_app.ExecutionCycle;

public class Context {
    private DataObject dataObject;
    private IStrategy strategy;

    public Context(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void commandSelected() {
        strategy.getResult();
    }
}
