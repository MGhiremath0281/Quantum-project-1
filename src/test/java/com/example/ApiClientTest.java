package com.example;

import com.example.util.ApiClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApiClientTest {
    @Test
    public void testFetchStockData() throws Exception {
        ApiClient apiClient = new ApiClient();
        String data = apiClient.fetchStockData("AAPL");
        assertNotNull(data);
    }
}
