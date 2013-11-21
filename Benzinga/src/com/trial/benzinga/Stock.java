package com.trial.benzinga;

public class Stock { 
	public String stock_name, company, price, dollar_change, percent_change;
	
	Stock(int i) {
		stock_name = "AAPL";
		company = "Apple Inc.";
		price = "$523.39";
		dollar_change = "+2.15";
		percent_change = "(+0.41%)";
	}
}