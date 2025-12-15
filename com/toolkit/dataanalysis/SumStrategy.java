package com.toolkit.dataanalysis;

import java.util.List;

public class SumStrategy implements AggregationStrategy {
    @Override
    public double execute(List<Double> data) {
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return sum;
    }
}
