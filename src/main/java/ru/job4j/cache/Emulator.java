package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        AbstractCache<String, String> cache = null;
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            try {
                if (cache == null) {
                    System.out.println("Enter the directory");
                    cache = new DirFileCache(scanner.nextLine());
                    continue;
                }
                System.out.println("Enter file name or E for exit");
                String file = scanner.nextLine();
                if ("E".equals(file)) {
                    run = false;
                    continue;
                }
                System.out.println(cache.get(file));
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
