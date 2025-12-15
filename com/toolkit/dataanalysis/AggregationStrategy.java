package com.toolkit.dataanalysis;

import java.util.List;

public interface AggregationStrategy {
    double execute(List<Double> data);
}
