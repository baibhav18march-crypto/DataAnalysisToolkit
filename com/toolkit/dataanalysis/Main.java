package com.toolkit.dataanalysis;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Fixed input: project.csv, column: marks
        String file = "project2.csv";
        String column = "marks";

        try {
            // Dataset reads your CSV and parses columns as double[]
            Dataset dataset = new Dataset(file) {};

            // Use your strategies
            double[] data = dataset.getColumn(column);
            double sum = new SumStrategy().execute(data);
            double mean = new AverageStrategy().execute(data);
            double variance = new VarianceStrategy().execute(data);

            // Console output
            System.out.println("File: " + file);
            System.out.println("Column: " + column);
            System.out.println("Sum = " + sum);
            System.out.println("Mean = " + mean);
            System.out.println("Variance = " + variance);

            // CSV output
            writeCsv("analysis.csv",
                    "file,column,sum,mean,variance",
                    file + "," + column + "," + sum + "," + mean + "," + variance);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void writeCsv(String fileName, String header, String row) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(header);
            fw.write(System.lineSeparator());
            fw.write(row);
        } catch (IOException e) {
            System.err.println("Could not write to " + fileName + ": " + e.getMessage());
        }
    }
}
