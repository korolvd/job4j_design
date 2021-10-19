package ru.job4j.serialization;

public class Coontroller {
    private final String name;
    private final int id;

    public Coontroller(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Coontroller{"
                + "name='" + name + '\''
                + ", id=" + id
                + '}';
    }
}
