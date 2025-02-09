package com.qis.CurrencyConvertorProject.model;

import java.util.Map;

public class ExchangeRateResponse {
	private Map<String, Double> rates;

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
}