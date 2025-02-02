package com.example.util;

import com.example.model.Stock;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProcessor {
    public List<Stock> processMultipleDataPoints(String jsonData) {
        List<Stock> stockData = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonData);
        String symbol = jsonObject.getJSONObject("Meta Data").getString("2. Symbol");
        JSONObject timeSeries = jsonObject.getJSONObject("Time Series (1min)");
        Iterator<String> keys = timeSeries.keys();

        while (keys.hasNext()) {
            String timestamp = keys.next();
            double price = timeSeries.getJSONObject(timestamp).getDouble("1. open");
            stockData.add(new Stock(symbol, price, System.currentTimeMillis()));
        }

        return stockData;
    }

    public Stock processData(String jsonData) {
        // Single data point processing for comparison
        JSONObject jsonObject = new JSONObject(jsonData);
        String symbol = jsonObject.getJSONObject("Meta Data").getString("2. Symbol");
        JSONObject timeSeries = jsonObject.getJSONObject("Time Series (1min)");
        String lastTimestamp = timeSeries.keys().next();
        double price = timeSeries.getJSONObject(lastTimestamp).getDouble("1. open");
        long timestamp = System.currentTimeMillis();  // For simplicity, use current timestamp
        return new Stock(symbol, price, timestamp);
    }
}
