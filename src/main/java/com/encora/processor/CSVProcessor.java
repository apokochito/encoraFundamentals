package com.encora.processor;

import com.encora.algorithm.BinarySearchTree;
import com.encora.algorithm.Tree;
import com.encora.mapper.Mapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class CSVProcessor<T extends Comparable<T>> {

    CSVProcessor(Mapper<T> mapper) {
        this.mapper = mapper;
    }

    private Mapper<T> mapper;

    public Tree<T> readCSV(String url) throws IOException {
        Tree<T> tree = new BinarySearchTree<>();
        Reader reader = new FileReader(url);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord record : csvParser) {
            tree.add(mapper.fromRecord(record));
        }
        return tree;
    }

    public void writeCSV(String url) throws IOException {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(url));
        try (CSVPrinter csvPrinter = CSVFormat.DEFAULT.withHeader("Name", "Kind", "PH", "Alcohol", "Quality")
                .print(bufferedWriter)) {
            csvPrinter.printRecord("test1", "test2", "test3", "test4", "test5");
            csvPrinter.printRecord("test1", "test2", "test3", "test4", "test5");
        }
    }
}
