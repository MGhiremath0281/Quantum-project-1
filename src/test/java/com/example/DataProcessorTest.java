package com.example;

import com.example.model.Stock;
import com.example.util.DataProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataProcessorTest {
    @Test
    public void testProcessData() {
        DataProcessor processor = new DataProcessor();
        String jsonData = "{ \"Meta Data\": { \"2. Symbol\": \"AAPL\" }, \"Time Series (1min)\": { \"2025-02-02 13:30:00\": { \"1. open\": 150.0 } } }";
        Stock stock = processor.processData(jsonData);
        assertEquals("AAPL", stock.getSymbol());
        assertEquals(150.0, stock.getPrice());
    }
}
