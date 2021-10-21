package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> files = new HashMap<>();
    private final List<Path> duplicates = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());
        if (files.containsKey(fileProperty)) {
            files.get(fileProperty).add(file);
        } else {
            List<Path> path = new ArrayList<>();
            path.add(file);
            files.put(fileProperty, path);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getDuplicates() {
        for (FileProperty file : files.keySet()) {
            List<Path> paths = files.get(file);
            if (paths.size() > 1) {
                duplicates.addAll(paths);
            }
        }
        return duplicates;
    }
}
