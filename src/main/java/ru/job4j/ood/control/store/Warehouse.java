package ru.job4j.ood.control.store;

import ru.job4j.ood.control.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Warehouse implements Store {

    Predicate<Food> filter;

    public Warehouse(Predicate<Food> filter) {
        this.filter = filter;
    }

    List<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public Predicate<Food> filter() {
        return filter;
    }

    public List<Food> getAll() {
        return foods;
    }
}
