package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class Analyze {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            List<String[]> lines = in.lines().map(l -> l.split(" ")).collect(Collectors.toList());
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
}