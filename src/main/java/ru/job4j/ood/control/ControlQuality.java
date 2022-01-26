package ru.job4j.ood.control;

import ru.job4j.ood.control.model.Food;
import ru.job4j.ood.control.store.Store;

import java.util.List;

public class ControlQuality {

    public void sort(List<Store> stores, List<Food> foods) {
        for (Store store : stores) {
            foods.stream().filter(store.filter()).forEach(store::add);
        }
    }
}
