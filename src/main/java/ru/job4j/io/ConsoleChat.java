package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        List<String> botPhrases = readPhrases();
        List<String> log = new ArrayList<>();
        boolean statusBot = true;
        boolean run = true;
        while (run) {
            System.out.print("user: ");
            String userPhrase = input.nextLine();
            log.add("user: " + userPhrase);
            switch (userPhrase) {
                case CONTINUE -> {
                    statusBot = true;
                }
                case STOP -> {
                    statusBot = false;
                }
                case OUT -> {
                    saveLog(log);
                    run = false;
                }
                default -> {
                    if (statusBot) {
                        String botPhrase = "bot:" + botPhrases.get((int) (Math.random() * botPhrases.size()));
                        System.out.println(botPhrase);
                        log.add(botPhrase);
                    }
                }
            }
        }
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            br.lines().forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("log.txt", "answers.txt");
        cc.run();
    }
}
