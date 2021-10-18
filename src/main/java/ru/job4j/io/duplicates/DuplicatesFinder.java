package ru.job4j.io.duplicates;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {
    public static void main(String[] args) throws Exception {
        String path = args.length == 0 ? "./" : args[0];
        if (!Path.of(path).toFile().isDirectory()) {
            throw new IllegalArgumentException("Directory " + path + " not found");
        }
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of(path), duplicatesVisitor);
        List<Path> duplicates = duplicatesVisitor.getDuplicates();
        for (Path file : duplicates) {
            System.out.println(file);
        }
    }
}
