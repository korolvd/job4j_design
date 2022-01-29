package ru.job4j.ood.menu;

import ru.job4j.ood.menu.action.Action;
import ru.job4j.ood.menu.model.Item;
import ru.job4j.ood.menu.out.Out;
import ru.job4j.ood.menu.out.OutFormat;

import java.util.ArrayList;
import java.util.List;

public class SimpleMenu implements Menu, Out, Action {

    List<Item> items = new ArrayList<>();
    OutFormat format;

    public SimpleMenu(OutFormat format) {
        this.format = format;
    }

    @Override
    public boolean add(Item item) {
        if (!validate(item)) {
            throw new IllegalArgumentException("incorrect name");
        }
        return items.add(item);
    }

    @Override
    public boolean remove(Item item) {
        return items.remove(item);
    }

    @Override
    public Item get(String name) {
        int index = indexByName(name);
        return index >= 0 ? items.get(index) : null;
    }

    @Override
    public String print() {
        return format.generate(items);
    }

    @Override
    public String execute(String name) {
        return get(name).getAction().execute("");
    }

    private boolean validate(Item item) {
        String[] name = item.getName().split(" ");
        return name.length > 1 && name[name.length - 1].matches("^\\d*[\\d.]*\\d$");
    }

    private int indexByName(String name) {
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }
}
