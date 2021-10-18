package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, Path> files = new HashMap<>();
    private final List<Path> duplicates = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.toFile().getName());
        if (files.containsKey(fileProperty)) {
            duplicates.add(file);
            duplicates.add(files.get(fileProperty));
        } else {
            files.put(fileProperty, file);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getDuplicates() {
        return duplicates;
    }
}