package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class Matrix {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        int[][] matrix = multiple(9);
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int[] s : matrix) {
                out.write(Arrays.toString(s).getBytes());
                out.write(System.lineSeparator().getBytes());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
