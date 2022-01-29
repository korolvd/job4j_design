package ru.job4j.ood.menu;

import ru.job4j.ood.menu.model.Item;

public interface Menu {

    boolean add(Item item);

    boolean remove(Item item);

    Item get(String name);
}
