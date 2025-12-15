package com.toolkit.dataanalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dataset {
    private List<Double> data;

    public Dataset(File file) throws FileNotFoundException {
        this.data = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextDouble()) {
            data.add(scanner.nextDouble());
        }
        scanner.close();
    }

    public List<Double> getData() {
        return data;
    }

    public int size() {
        return data.size();
    }
}
