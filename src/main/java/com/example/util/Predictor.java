package com.example.util;

import com.example.model.Stock;

public class Predictor {
    public double predictNextPrice(Stock stock) {
        // Simple prediction logic (replace with a more advanced algorithm)
        return stock.getPrice() * 1.01;
    }
}
