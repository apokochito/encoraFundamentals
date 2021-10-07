package com.encora.service;

import com.encora.algorithm.Order;
import com.encora.algorithm.Tree;
import com.encora.model.Wine;
import com.encora.processor.CSVProcessor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WineService {

    private CSVProcessor<Wine> csvProcessor;

    public WineService(CSVProcessor<Wine> csvProcessor) {
        this.csvProcessor = csvProcessor;
    }

    public List<Wine> retrieveWines() throws IOException {
        Tree<Wine> wines = csvProcessor.readCSV("C:\\Users\\Diana Elena\\IdeaProjects\\encoraFundamentals\\src\\main\\resources\\wine-dataset.csv");
        return wines.display(Order.INORDER);
    }

    public List<Wine> retrieveWineByKind(String kind) throws IOException {
        Tree<Wine> wines = csvProcessor.readCSV("C:\\Users\\Diana Elena\\IdeaProjects\\encoraFundamentals\\src\\main\\resources\\wine-dataset.csv");
        return wines.display(Order.INORDER)
                .stream()
                .filter(wine -> wine.getKind().equals(kind))
                .collect(Collectors.toList());
    }

}
