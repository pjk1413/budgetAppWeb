package com.User;

public class Investment {

	private double amount;
	private boolean recurring;
	private double rateOfReturn;
	
	public Investment() {}
	
	public String writeInvestments() {
		String t = "#";
		return String.valueOf(amount)+t+String.valueOf(recurring)+t+String.valueOf(rateOfReturn);
	}
	
	
	public Investment(double amount, boolean reoccurring, double rate) {
		this.amount = amount;
		this.recurring = reoccurring;
		this.rateOfReturn = rate;
	}
	
	public Investment(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean getRecurring() {
		return recurring;
	}
	public void setRecurring(boolean reoccuring) {
		this.recurring = reoccuring;
	}
	public double getRateOfReturn() {
		return rateOfReturn;
	}
	public void setRateOfReturn(double rateOfReturn) {
		this.rateOfReturn = rateOfReturn;
	}
	
	
	
}
