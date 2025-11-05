package com.neotox.currencyconverter.service;

import com.neotox.currencyconverter.model.ConversionHistory;
import com.neotox.currencyconverter.repository.ConversionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    private ConversionHistoryRepository historyRepository;

    private static final String API_URL = "https://api.frankfurter.app/latest?amount={amount}&from={from}&to={to}";

    public Map<String, Object> convert(String from, String to, double amount) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> result = new HashMap<>();

        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(API_URL, Map.class, amount, from, to);
            Map<String, Object> body = response.getBody();

            result.put("from", from);
            result.put("to", to);
            result.put("amount", amount);

            if (body != null && body.containsKey("rates")) {
                Map<String, Object> rates = (Map<String, Object>) body.get("rates");
                Object rateObj = rates.get(to);

                double converted = 0.0;
                if (rateObj instanceof Number) {
                    converted = ((Number) rateObj).doubleValue();
                }

                result.put("convertedAmount", converted);

                // Save to DB
                ConversionHistory history = new ConversionHistory(from, to, amount, converted);
                historyRepository.save(history);
            } else {
                result.put("convertedAmount", "Error fetching conversion");
            }

            return result;

        } catch (Exception e) {
            result.put("error", "Failed to fetch conversion: " + e.getMessage());
            return result;
        }
    }

    public java.util.List<ConversionHistory> getAllHistory() {
        return historyRepository.findAll();
    }
}
