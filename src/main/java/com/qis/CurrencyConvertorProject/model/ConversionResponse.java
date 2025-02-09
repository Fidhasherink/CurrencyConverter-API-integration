package com.qis.CurrencyConvertorProject.model;

public class ConversionResponse {
	private String from;
	private String to;
	private double amount;
	private double convertedAmount;

	public ConversionResponse(String from, String to, double amount, double convertedAmount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.convertedAmount = convertedAmount;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public double getAmount() {
		return amount;
	}

	public double getConvertedAmount() {
		return convertedAmount;
	}
}
