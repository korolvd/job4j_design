package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Unit {
    private final String type;
    private final long id;
    private final boolean run;
    private final Coontroller controller;
    private final String[] users;

    public Unit(String type, long id, boolean run, Coontroller controller, String[] users) {
        this.type = type;
        this.id = id;
        this.run = run;
        this.controller = controller;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Unit{"
                + "type='" + type + '\''
                + ", id=" + id
                + ", run=" + run
                + ", controller=" + controller
                + ", users=" + Arrays.toString(users)
                + '}';
    }

    public static void main(String[] args) {
        Unit unit = new Unit("ESP", 20000521553L, true, new Coontroller("Novomet", 214125), new String[]{"Ivanov", "Sidorov"});
        System.out.println(unit);
        final Gson gson = new GsonBuilder().create();
        final String unitToJson = gson.toJson(unit);
        System.out.println(unitToJson);
        Unit jsonToUnit = gson.fromJson(unitToJson, Unit.class);
        System.out.println(jsonToUnit);
    }
}
