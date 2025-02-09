package com.qis.CurrencyConvertorProject.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qis.CurrencyConvertorProject.exception.CurrencyNotFoundException;
import com.qis.CurrencyConvertorProject.exception.ExternalApiException;
import com.qis.CurrencyConvertorProject.model.ExchangeRateResponse;

@Service
public class CurrencyService {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Double> getExchangeRates(String base) {
        String url = API_URL + base;
        try {
            ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
            if (response == null || response.getRates() == null) {
                throw new ExternalApiException("Failed to fetch exchange rates. Please try again later.");
            }
            return response.getRates();
        } catch (Exception e) {
            throw new ExternalApiException("Error connecting to external API: " + e.getMessage());
        }
    }
                                  //USD          //INR        //100
    public double convertCurrency(String from, String to, double amount) {
        Map<String, Double> rates = getExchangeRates(from);
        if (!rates.containsKey(to)) {
            throw new CurrencyNotFoundException("Invalid currency code: " + to);
        }
               //100  * 87.68 =8768
        return amount * rates.get(to); 
    }
    
}


