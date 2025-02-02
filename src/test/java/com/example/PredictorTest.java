package com.example;

import com.example.model.Stock;
import com.example.util.Predictor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredictorTest {
    @Test
    public void testPredictNextPrice() {
        Predictor predictor = new Predictor();
        Stock stock = new Stock("AAPL", 150.0, 1617123456);
        double predictedPrice = predictor.predictNextPrice(stock);
        assertEquals(151.5, predictedPrice, 0.01);
    }
}
