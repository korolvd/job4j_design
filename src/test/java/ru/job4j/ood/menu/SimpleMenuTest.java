package ru.job4j.ood.menu;

import org.junit.Test;
import ru.job4j.ood.menu.action.Action1;
import ru.job4j.ood.menu.model.ActionItem;
import ru.job4j.ood.menu.model.Item;
import ru.job4j.ood.menu.out.TreeFormat;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleMenuTest {

    @Test
    public void addItem() {
        SimpleMenu menu = new SimpleMenu(new TreeFormat());
        Item item = new ActionItem("item 1", new Action1());
        assertTrue(menu.add(item));
    }

    @Test
    public void getItem() {
        SimpleMenu menu = new SimpleMenu(new TreeFormat());
        Item item = new ActionItem("item 1", new Action1());
        menu.add(item);
        assertThat(menu.get(item.getName()), is(item));
    }

    @Test
    public void removeItem() {
        SimpleMenu menu = new SimpleMenu(new TreeFormat());
        Item item = new ActionItem("item 1", new Action1());
        assertTrue(menu.add(item));
        assertTrue(menu.remove(item));
        assertThat(menu.get(item.getName()), is(nullValue()));
    }

    @Test
    public void executeByItem() {
        SimpleMenu menu = new SimpleMenu(new TreeFormat());
        Item item = new ActionItem("item 1", new Action1());
        menu.add(item);
        assertThat(menu.execute(item.getName()), is("execute action 1"));
    }

    @Test
    public void printTree() {
        SimpleMenu menu = new SimpleMenu(new TreeFormat());
        List<Item> list = List.of(
                new ActionItem("item 1", new Action1()),
                new ActionItem("item 1.1", new Action1()),
                new ActionItem("item 1.1.1", new Action1()),
                new ActionItem("item 1.2", new Action1()),
                new ActionItem("item 2", new Action1())
        );
        for (Item item : list) {
            menu.add(item);
        }
        String expect = "item 1" + System.lineSeparator()
                + "---- item 1.1" + System.lineSeparator()
                + "-------- item 1.1.1" + System.lineSeparator()
                + "---- item 1.2" + System.lineSeparator()
                + "item 2" + System.lineSeparator();
        assertThat(menu.print(), is(expect));
    }
}