package com.encora;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

class CSVProcessor<T> {
    List<Node<T>> readCSV(String url) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(url));
        CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);
        List<Node<T>> nodes = new LinkedList<>();
        // Orika Mapper
        for (CSVRecord record : csvParser.getRecords()) {
            String name = record.get(0);
            String kind = record.get(1);
            String ph = record.get(2);
            String alcohol = record.get(3);
            String quality = record.get(4);

            System.out.println(name + " " + kind + " " + ph + " " + alcohol + " " + quality);
        }
        return nodes;
    }

    void writeCSV(String url) throws IOException {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(url));
        try (CSVPrinter csvPrinter = CSVFormat.DEFAULT.withHeader("Name", "Kind", "PH", "Alcohol", "Quality")
                .print(bufferedWriter)) {
            csvPrinter.printRecord("test1", "test2", "test3", "test4", "test5");
            csvPrinter.printRecord("test1", "test2", "test3", "test4", "test5");
        }
    }
}
