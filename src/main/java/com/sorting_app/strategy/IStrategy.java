package com.sorting_app.strategy;

import java.util.List;
import java.util.Objects;

public interface IStrategy {
    Objects getResult(List<Objects> obj);
}