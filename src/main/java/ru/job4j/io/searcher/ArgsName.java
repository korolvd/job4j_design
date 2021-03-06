package ru.job4j.io.searcher;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Parameter " + key + " is not exist");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String arg : args) {
            String[] pair = arg.split("=");
            if (pair.length != 2 || pair[0].length() < 2 || pair[0].charAt(0) != '-') {
                throw new IllegalArgumentException("Incorrect parameter " + pair[0] + ". Usage -PARAMETER=VALUE.");
            }
            values.put(pair[0].substring(1), pair[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
