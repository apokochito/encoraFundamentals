package com.encora;

import com.encora.algorithm.Order;
import com.encora.algorithm.Tree;
import com.encora.mapper.WineMapper;
import com.encora.model.Wine;
import com.encora.processor.CSVProcessor;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CSVProcessor<Wine> csvProcessor = new CSVProcessor<>(new WineMapper());
        Tree<Wine> tree = csvProcessor.readCSV("C:\\Users\\Diana Elena\\IdeaProjects\\encoraFundamentals\\src\\main\\resources\\wine-dataset.csv");
        tree.display(Order.INORDER);
    }
}
