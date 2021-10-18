package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFile(List<Path> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path file : source) {
                zip.putNextEntry(new ZipEntry(file.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file.toFile()))) {
                    zip.write(out.readAllBytes());
                }
                System.out.println(file.toAbsolutePath() + " added");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        Path sours = Paths.get(argsName.get("d"));
        if (!sours.toFile().isDirectory()) {
            throw new IllegalArgumentException("Directory \"" + sours + "\" is not found");
        }
        String exclude = argsName.get("e");
        File target = new File(argsName.get("o"));
        Search search = new Search();
        List<Path> list = search.search(sours, p -> p.toFile().isFile());
        List<Path> filterList = list.stream().filter(p -> !p.toFile().getName().endsWith(exclude)).collect(Collectors.toList());
        packFile(filterList, target);
        System.out.println("ZIP SUCCESS");
    }
}
