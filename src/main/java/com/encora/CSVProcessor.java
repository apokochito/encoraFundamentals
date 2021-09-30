package com.encora;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class CSVProcessor<T extends Comparable<T>> {

    CSVProcessor(Mapper<T> mapper) {
        this.mapper = mapper;
    }

    private Mapper<T> mapper;

    Tree<T> readCSV(String url) throws IOException {
        Reader reader = new FileReader(url);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
        Tree<T> tree = new BinarySearchTree<>();
        for (CSVRecord record : records) {
            tree.add(mapper.fromRecord(record));
        }
        return tree;
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
