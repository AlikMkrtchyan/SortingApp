package com.sorting_app;

import com.sorting_app.model.RootVegetable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RootVegetableSortByOddEven {
    private final List<RootVegetable> list;

    public RootVegetableSortByOddEven(List<RootVegetable> list) {
        this.list = list;
    }

    Comparator<RootVegetable> rootVegetableComparator = Comparator.comparing(RootVegetable::getWeight);

    public void sort() {
        List<RootVegetable> listEven = new ArrayList<>();

        for (RootVegetable rv : list) {
            if (rv.getWeight() % 2 == 0) {
                listEven.add(rv);
            }
        }

        listEven.sort(rootVegetableComparator);

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWeight() % 2 != 0) {
                continue;
            }

            list.set(i, listEven.get(count++));
        }
    }
}
