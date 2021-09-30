package com.encora;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //CSVProcessor.readCSV("C:\\Users\\Diana Elena\\IdeaProjects\\encoraFundamentals\\src\\main\\resources\\wine-dataset.csv");
        //CSVProcessor.writeCSV();

        CSVProcessor<Wine> csvProcessor = new CSVProcessor<>(new WineMapper());
        Tree<Wine> tree = csvProcessor.readCSV("C:\\Users\\Diana Elena\\IdeaProjects\\encoraFundamentals\\src\\main\\resources\\wine-dataset.csv");
        tree.display(Order.INORDER);
    }
}
