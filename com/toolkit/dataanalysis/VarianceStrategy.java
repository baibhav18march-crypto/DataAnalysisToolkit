package com.toolkit.dataanalysis;

import java.util.List;

public class VarianceStrategy implements AggregationStrategy {
    @Override
    public double execute(List<Double> data) {
        if (data.isEmpty()) return 0;
        double mean = new AverageStrategy().execute(data);
        double sumSquaredDiff = 0;
        for (double value : data) {
            sumSquaredDiff += Math.pow(value - mean, 2);
        }
        return sumSquaredDiff / data.size();
    }
}
