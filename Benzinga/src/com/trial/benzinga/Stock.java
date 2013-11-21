package com.trial.benzinga;

/** Stock class to encapsulate all stock-related information
 * @author: Sumedha Pramod
 * @version: 0.1
 */
public class Stock { 
	public String stock_name, company, price, dollar_change, percent_change;
	
	/** Constructor used each time a new stock is created
	 */
	Stock() {
		stock_name = "AAPL";
		company = "Apple Inc.";
		price = "$523.39";
		dollar_change = "+2.15";
		percent_change = "(+0.41%)";
	}
}