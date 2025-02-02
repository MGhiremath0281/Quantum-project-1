package com.example.util;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiClient {
    private static final Config config = new Config();
    private static final String API_URL = config.getProperty("api.url");
    private static final String API_KEY = config.getProperty("api.key");

    public String fetchStockData(String symbol) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String url = API_URL + "?function=TIME_SERIES_INTRADAY&symbol=" + symbol + "&interval=1min&apikey=" + API_KEY;
            HttpGet request = new HttpGet(url);
            return EntityUtils.toString(httpClient.execute(request).getEntity());
        }
    }
}
