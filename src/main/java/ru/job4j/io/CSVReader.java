package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    public StringJoiner readCSVByParameters(Map<String, List<String>> args) throws Exception {
        StringJoiner resultString = new StringJoiner("");
        try (Scanner scanner = new Scanner(new FileReader(args.get("path").get(0), Charset.forName("UTF-8")))) {
            String delimiter = args.get("delimiter").get(0);
            List<String> fields = List.of(scanner.nextLine().split(delimiter));
            List<String> filters = args.get("filter");
            List<Integer> indexesOfFilterFields = new ArrayList<>();
            if (filters == null) {
                filters = new ArrayList<>(fields);
            }
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public void printTo(String key, StringJoiner data) {
        if ("stdout".equals(key)) {
            System.out.print(data);
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(key, Charset.forName("UTF-8"), true))) {
                pw.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, List<String>> parsingArgs(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Invalid parameters. "
                    + "Usage java -jar csvreader.jar -path=FILE_NAME -delimiter=DELIMITER -out=stdout or -out=OUTPUT_FILE. Optional -filter=FIELD1,FIELD2,...etc");
        }
        ArgsName argsName = ArgsName.of(args);
        Map<String, List<String>> parsingArgs = new HashMap<>();
        String path = argsName.get("path");
        if (!Path.of(path).toFile().getName().endsWith("csv")) {
            throw new IllegalArgumentException("Invalid type of " + path
                    + ". File must have csv extension");
        }
        parsingArgs.put("path", List.of(path));
        parsingArgs.put("delimiter", List.of(argsName.get("delimiter")));
        parsingArgs.put("out", List.of(argsName.get("out")));
        if (args.length == 4) {
            parsingArgs.put("filter", List.of(argsName.get("filter").split(",")));
        } else {
            parsingArgs.put("filter", null);
        }
        return parsingArgs;
    }

    public static void main(String[] args) throws Exception {
        CSVReader csvReader = new CSVReader();
        Map<String, List<String>> parsingArgs = csvReader.parsingArgs(args);
        StringJoiner result = csvReader.readCSVByParameters(parsingArgs);
        csvReader.printTo(parsingArgs.get("out").get(0), result);
    }
}
