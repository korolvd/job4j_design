package ru.job4j.ood.menu.out;

import ru.job4j.ood.menu.model.Item;

import java.util.List;

public interface OutFormat {

    String generate(List<Item> items);
}
