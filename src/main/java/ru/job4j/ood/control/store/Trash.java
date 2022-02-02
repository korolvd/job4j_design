package ru.job4j.ood.control.store;

import ru.job4j.ood.control.model.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Trash implements Store {

    private Predicate<Food> filter = f -> getFreshPercent(f) <= 0;
    List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }
        boolean rsl = filter.test(food);
        if (rsl) {
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

    @Override
    public long getFreshPercent(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Object is NULL");
        }
        long shelfLife = food.getCreateDate().until(food.getExpiryDate(), ChronoUnit.DAYS);
        long daysUntilExpiry = LocalDate.now().until(food.getExpiryDate(), ChronoUnit.DAYS);
        double percent = (double) daysUntilExpiry / shelfLife * 100;
        return (long) percent;
    }
}
