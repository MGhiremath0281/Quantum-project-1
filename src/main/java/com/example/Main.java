package com.example;

import com.example.model.Stock;
import com.example.util.ApiClient;
import com.example.util.DataProcessor;
import com.example.util.Predictor;
import com.example.visualization.Chart;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Real-Time Stock Prediction and Visualization Project!");

        try {
            ApiClient apiClient = new ApiClient();
            DataProcessor dataProcessor = new DataProcessor();
            Predictor predictor = new Predictor();
            Chart chart = new Chart();

            String jsonData = apiClient.fetchStockData("AAPL");
            System.out.println("Fetched Data: " + jsonData);  // Verify data fetching

            List<Stock> stockData = dataProcessor.processMultipleDataPoints(jsonData);
            System.out.println("Processed Data: " + stockData);  // Verify data processing

            List<Stock> predictedStockData = new ArrayList<>();
            for (Stock stock : stockData) {
                double predictedPrice = predictor.predictNextPrice(stock);
                stock.setPrice(predictedPrice);
                predictedStockData.add(stock);
            }

            chart.displayChart(predictedStockData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
