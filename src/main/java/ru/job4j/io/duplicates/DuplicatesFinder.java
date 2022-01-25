package ru.job4j.io.duplicates;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {

    public String getPath(String[] args) {
        String path = args.length == 0 ? "./" : args[0];
        if (!Path.of(path).toFile().isDirectory()) {
            throw new IllegalArgumentException("Directory " + path + " not found");
        }
        return path;
    }

    public void printConsole(List<Path> duplicates) {
        for (Path file : duplicates) {
            System.out.println(file);
        }
    }

    public static void main(String[] args) throws Exception {
        DuplicatesFinder finder = new DuplicatesFinder();
        DuplicatesVisitor duplicates = new DuplicatesVisitor();
        Files.walkFileTree(Path.of(finder.getPath(args)), duplicates);
        finder.printConsole(duplicates.getDuplicates());
    }
}
