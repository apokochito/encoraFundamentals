package com.encora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello world");
        /*CSVProcessor<Wine> csvProcessor = new CSVProcessor<>(new WineMapper());
        Tree<Wine> tree = csvProcessor.readCSV("C:\\Users\\Diana Elena\\IdeaProjects\\encoraFundamentals\\src\\main\\resources\\wine-dataset.csv");
        tree.display(Order.INORDER);*/
    }
}
