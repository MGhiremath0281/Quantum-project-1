package com.example.visualization;

import com.example.model.Stock;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;

import java.util.ArrayList;
import java.util.List;

public class Chart {
    public void displayChart(List<Stock> stockData) {
        // Example data for demonstration (replace with real data)
        double[] xData = new double[stockData.size()];
        double[] yData = new double[stockData.size()];

        for (int i = 0; i < stockData.size(); i++) {
            xData[i] = i;
            yData[i] = stockData.get(i).getPrice();
        }

        // Create Chart
        XYChart chart = new XYChart(800, 600);
        chart.setTitle("Stock Price Prediction for Apple Inc. (AAPL)");
        chart.setXAxisTitle("Time Intervals");
        chart.setYAxisTitle("Price");

        // Add Stock Price Series
        XYSeries series = chart.addSeries("Stock Price", xData, yData);
        series.setXYSeriesRenderStyle(XYSeriesRenderStyle.Line);

        // Add Moving Average Series
        double[] movingAverageData = calculateMovingAverage(yData, 3); // 3-interval moving average
        XYSeries maSeries = chart.addSeries("Moving Average", xData, movingAverageData);
        maSeries.setXYSeriesRenderStyle(XYSeriesRenderStyle.Line);
        maSeries.setLineColor(java.awt.Color.RED);

        // Display Chart
        new SwingWrapper<>(chart).displayChart();
    }

    private double[] calculateMovingAverage(double[] data, int interval) {
        double[] result = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            if (i < interval) {
                result[i] = data[i];
            } else {
                double sum = 0;
                for (int j = i - interval + 1; j <= i; j++) {
                    sum += data[j];
                }
                result[i] = sum / interval;
            }
        }
        return result;
    }
}
