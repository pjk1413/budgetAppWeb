package com.User;

public class Expense {

	private double expense;
	
	public String writeExpenses() {
		return String.valueOf(expense);
	}
	
	public Expense(double amount) {
		this.expense = amount;
	}
	
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public boolean isReoccurring() {
		return reoccurring;
	}
	public void setReoccurring(boolean reoccurring) {
		this.reoccurring = reoccurring;
	}
	private boolean reoccurring;
	
}
