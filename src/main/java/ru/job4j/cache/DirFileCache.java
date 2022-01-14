package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cacheDir;

    public DirFileCache(String cacheDir) {
        File dir = new File(cacheDir);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Directory %s is not found", cacheDir)
            );
        }
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                put(file.getName(), null);
            }
        }
        this.cacheDir = cacheDir;
    }

    @Override
    protected String load(String key) {
        StringJoiner data = new StringJoiner(System.lineSeparator());
        File file = new File(cacheDir + "\\\\" + key);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("File %s is not found", key));
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException(String.format("Incorrect file %s", key));
        }
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file, StandardCharsets.UTF_8))
        ) {
            reader.lines().forEach(data::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}
