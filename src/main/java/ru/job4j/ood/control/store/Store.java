package ru.job4j.ood.control.store;

import ru.job4j.ood.control.model.Food;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    void add(Food food);

    Predicate<Food> filter();

    List<Food> getAll();

}
