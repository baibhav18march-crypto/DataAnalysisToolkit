package com.toolkit.dataanalysis;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Fixed input: project2.csv
        String file = "project2.csv";

        try {
            // Dataset reads your file and gets data as List<Double>
            Dataset dataset = new Dataset(new File(file));
            List<Double> data = dataset.getData();

            // Use your strategies
            double sum = new SumStrategy().execute(data);
            double mean = new AverageStrategy().execute(data);
            double variance = new VarianceStrategy().execute(data);

            // Print results
            System.out.println("Sum: " + sum);
            System.out.println("Mean: " + mean);
            System.out.println("Variance: " + variance);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
