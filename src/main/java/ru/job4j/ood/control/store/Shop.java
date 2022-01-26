package ru.job4j.ood.control.store;

import ru.job4j.ood.control.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Store {

    Predicate<Food> filter;

    public Shop(Predicate<Food> filter) {
        this.filter = filter;
    }

    List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (food.fresh() < 25) {
            food.setDiscount(75);
        }
        foods.add(food);
    }

    @Override
    public Predicate<Food> filter() {
        return filter;
    }

    @Override
    public List<Food> getAll() {
        return foods;
    }
}
