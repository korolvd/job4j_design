package ru.job4j.ood.menu.model;

import ru.job4j.ood.menu.action.Action;

public interface Item {

    String getName();

    void setName(String name);

    Action getAction();

    void setAction(Action action);

}
