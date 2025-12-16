package com.toolkit.dataanalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Dataset {
    private Map<String, List<Double>> columns;
    
    public Dataset(String filename) throws FileNotFoundException {
        this.columns = new HashMap<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        if (scanner.hasNextLine()) {
            // Read header line
            String headerLine = scanner.nextLine();
            String[] headers = headerLine.split(",");
            
            // Initialize columns
            for (String header : headers) {
                columns.put(header.trim(), new ArrayList<>());
            }
            
            // Read data lines
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                
                String[] values = line.split(",");
                for (int i = 0; i < headers.length && i < values.length; i++) {
                    try {
                        double value = Double.parseDouble(values[i].trim());
                        columns.get(headers[i].trim()).add(value);
                    } catch (NumberFormatException e) {
                        // Skip non-numeric values
                    }
                }
            }
        }
        scanner.close();
    }
    
    public List<Double> getColumn(String columnName) {
        List<Double> column = columns.get(columnName);
        if (column == null) {
            throw new IllegalArgumentException("Column '" + columnName + "' not found");
        }
        return column;
    }
    
    public List<Double> getData() {
        // Return first column if available
        if (!columns.isEmpty()) {
            return columns.values().iterator().next();
        }
        return new ArrayList<>();
    }
    
    public int size() {
        if (!columns.isEmpty()) {
            return columns.values().iterator().next().size();
        }
        return 0;
    }
}
