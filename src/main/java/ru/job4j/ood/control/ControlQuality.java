package ru.job4j.ood.control;

import ru.job4j.ood.control.model.Food;
import ru.job4j.ood.control.store.Store;

import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void sort(List<Food> foods) {
        for (Store store : stores) {
            foods.forEach(store::add);
        }
    }
}
