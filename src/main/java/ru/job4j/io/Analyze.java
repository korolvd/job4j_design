package ru.job4j.io;

import java.io.*;

public class Analyze {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            boolean status = true;
            String[] pair;
            while (in.ready()) {
                pair = in.readLine().split("\\s");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}