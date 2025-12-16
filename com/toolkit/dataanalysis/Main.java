package com.toolkit.dataanalysis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Fixed input: project.csv, column: marks
        String file = "project2.csv";
        String column = "marks";

        try {
            // Dataset reads your CSV and parses columns as List<Double>            Dataset dataset = new Dataset(file) {};
Dataset dataset = new Dataset(file);            // Use your strategies
List<Double> data = dataset.getColumn(column);            int count = data.size();  // number of input records

            double sum = new SumStrategy().execute(data);
            double mean = new AverageStrategy().execute(data);
            double variance = new VarianceStrategy().execute(data);

            // Console output
            System.out.println("File: " + file);
            System.out.println("Column: " + column);
            System.out.println("Number of records = " + count);
            System.out.println("Sum = " + sum);
            System.out.println("Mean = " + mean);
            System.out.println("Variance = " + variance);

            // CSV output
            writeCsv("analysis.csv",
                    "file,column,count,sum,mean,variance",
                    file + "," + column + "," + count + "," + sum + "," + mean + "," + variance);

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
