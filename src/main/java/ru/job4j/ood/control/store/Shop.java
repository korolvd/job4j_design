package ru.job4j.ood.control.store;

import ru.job4j.ood.control.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Store {

    private Predicate<Food> filter = f -> getFreshPercent(f) <= 75 && getFreshPercent(f) > 0;
    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }
        boolean rsl = filter.test(food);
        if (rsl) {
            if (getFreshPercent(food) < 25) {
                food.setDiscount(75);
            }
            foods.add(food);
        }
        return rsl;
    }

    @Override
    public Predicate<Food> filter() {
        return filter;
    }

    @Override
    public List<Food> getAll() {
        return List.copyOf(foods);
    }
}
