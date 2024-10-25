package com.sorting_app.strategy;

import com.sorting_app.data.DataObject;
import com.sorting_app.handler.ValidationException;

public class MergeSortStrategy implements  IStrategy{
private final DataObject object;

    public MergeSortStrategy(DataObject object) {
        this.object = object;
    }

    private void selectMergeSort()throws ValidationException {
        try {

        } catch (Exception e){
            throw new ValidationException("Данные в коллекции не соответствуют требованиям");
        }
    }

    @Override
    public void getResult() {
    }


}
