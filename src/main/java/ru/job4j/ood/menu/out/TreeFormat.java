package ru.job4j.ood.menu.out;

import ru.job4j.ood.menu.model.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TreeFormat implements OutFormat {
    @Override
    public String generate(List<Item> items) {
        StringBuilder rsl = new StringBuilder();
        items.sort(Comparator.comparing(i ->
                i.getName().split(" ")[i.getName().split(" ").length - 1]));
        for (Item item : items) {
            String[] line = item.getName().split(" ");
            String[] numbers = line[line.length - 1].split("\\.");
            if (numbers.length > 1) {
                rsl.append("----".repeat(numbers.length - 1));
                rsl.append(" ");
            }
            rsl.append(item.getName()).append(System.lineSeparator());
        }
        return rsl.toString();
    }
}
