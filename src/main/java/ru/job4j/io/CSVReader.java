package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class CSVReader {

    public static void handle(ArgsName argsName) throws Exception {
        try (Scanner scanner = new Scanner(new FileReader(argsName.get("path"), Charset.forName("UTF-8")))) {
            String delimiter = argsName.get("delimiter");
            List<String> fields = List.of(scanner.nextLine().split(delimiter));
            List<String> filters = List.of(argsName.get("filter").split(","));
            List<Integer> indexesOfFilterFields = new ArrayList<>();
            StringJoiner resultString = new StringJoiner("");
            Iterator<String> iteratorFilter = filters.iterator();
            while (iteratorFilter.hasNext()) {
                String filter = iteratorFilter.next();
                indexesOfFilterFields.add(fields.indexOf(filter));
                resultString.add(filter);
                if (iteratorFilter.hasNext()) {
                    resultString.add(delimiter);
                }
            }
            resultString.add(System.lineSeparator());
            while (scanner.hasNext()) {
                String[] strings = scanner.nextLine().split(delimiter);
                Iterator<Integer> iteratorIndex = indexesOfFilterFields.iterator();
                while (iteratorIndex.hasNext()) {
                    resultString.add(strings[iteratorIndex.next()]);
                    if (iteratorIndex.hasNext()) {
                        resultString.add(delimiter);
                    }
                }
                if (scanner.hasNext()) {
                    resultString.add(System.lineSeparator());
                }
            }
            if (argsName.get("out").equals("stdout")) {
                System.out.print(resultString);
            } else {
                try (PrintWriter pw = new PrintWriter(new FileWriter(argsName.get("out"), Charset.forName("UTF-8"), true))) {
                    pw.println(resultString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            throw new IllegalArgumentException("Invalid parameters. "
                    + "Usage java -jar csvreader.jar -path=FILE_NAME -delimiter=DELIMITER -out=stdout or -out=OUTPUT_FILE -filter=FIELD1,FIELD2,...etc");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
