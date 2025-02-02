package com.example;

import com.example.model.Stock;
import com.example.visualization.Chart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ChartTest {
    @Test
    public void testDisplayChart() {
        Chart chart = new Chart();
        List<Stock> stockData = new ArrayList<>();
        stockData.add(new Stock("AAPL", 150.0, System.currentTimeMillis()));
        stockData.add(new Stock("AAPL", 151.5, System.currentTimeMillis() + 60000));
        stockData.add(new Stock("AAPL", 153.0, System.currentTimeMillis() + 120000));

        chart.displayChart(stockData);
    }
}
