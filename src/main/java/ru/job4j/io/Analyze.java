package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analyze {

    public void unavailable(String source, String target) {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            lines = in.lines().map(l -> l.split(" ")).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            boolean status = true;
            for (String[] pair : lines) {
                if (Integer.parseInt(pair[0]) > 300) {
                    if (status) {
                        out.print(pair[1] + ";");
                        status = false;
                    }
                } else {
                    if (!status) {
                        out.println(pair[1] + ";");
                        status = true;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analyze analyze = new Analyze();
        analyze.unavailable("log2.txt", "unavailable.csv");
    }
}