package com.toolkit.dataanalysis;

import java.util.List;

public class AverageStrategy implements AggregationStrategy {
    @Override
    public double execute(List<Double> data) {
        if (data.isEmpty()) return 0;
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.size();
    }
}
