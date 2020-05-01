package com.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

enum Frequency {
	Weekly,
	BiWeekly,
	SemiMonthly,
	Monthly
}
public class User {
	
	
	public static final String d = UserDB.d;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double income;
	private String filingStatus;
	private Address address;
	private Frequency payCheckFrequency;
	private ArrayList<Investment> investments;
	private ArrayList<Double> expenses;
	
	//first last email password income filingstatus address paycheckfrequency investments expenses
	
	//Constructors
	public User() {}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	
	//****************************************************************************************************************
	
	
	/**
	 * Overides toString method and places user into a parsable string
	 */
	public String toString() {
		return this.firstName+d+this.lastName+d+this.email+d+this.password+d+this.income+d+this.filingStatus+d+
				this.address.writeAddress()+d+this.payCheckFrequency.toString()+d+writeInvestments()
				+d+writeExpenses();
	}
	
	
	/**
	 * Simply used by toString method
	 * Values separated by *
	 * @return String of expenses
	 */
	private String writeExpenses() {
		String str ="";
		String E = "E";
		
		for (Double e : expenses) {
			str += String.valueOf(e) + E;
		}
		
		return str;
	}
	
	
	/**
	 * Used by toString method
	 * Values seperated by ^
	 * @return String of investment objects
	 */
	private String writeInvestments() {
		String str = "";
		String T = "T";
		for (Investment investment : investments) {
			str += investment.writeInvestments() + T;
		}
		
		return str;
	}
	
	
	
	
	
	public ArrayList<Double> taxesPaid() {
		ArrayList<Double> tax = new ArrayList<Double>();
		
		//Calcualte taxes on income here
		
		
		return tax;
	}
	
	
	
	// ******* Getters and Setters
	public String getTotalFederalTaxesString() {
		return "$8,345.65";
	}
	
	public ArrayList<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(ArrayList<Investment> investments) {
		this.investments = investments;
	}

	public ArrayList<Double> getExpenses() {
		return expenses;
	}

	public void setExpenses(ArrayList<Double> expenses) {
		this.expenses = expenses;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getIncome() {
		return income;
	}
	
	public String getIncomeString() {
		System.out.println(this.income);
		if (this.income != 0.0 || income != 0) {
			return "$" + String.valueOf(income);
		}
		else {
			return "No Income Recorded";
		}
	}
	
	public void setIncome(double income) {
		this.income = income;
	}

	public String getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(String filingStatus) {
		this.filingStatus = filingStatus;
	}

	public Frequency getPayCheckFrequency() {
		return payCheckFrequency;
	}

	public void setPayCheckFrequency(Frequency payCheckFrequency) {
		this.payCheckFrequency = payCheckFrequency;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void addInvestment(double amount, boolean reoccurring, double rate) {
		Investment investment = new Investment(amount, reoccurring, rate);
		this.investments.add(investment);
		
	}
	
	public void removeInvestment(Investment investment) {
		int index = 0;
		for (Investment i : this.investments) {
			if (i.getAmount() == investment.getAmount()) {
				index = this.investments.indexOf(i);
			}
		}
		
		this.investments.remove(index);
	}
	
	public String getTotalExpenseString() {
		double total = 0.0;
		for (Double expense : expenses) {
			total += expense;
		}
		return "-$" + String.valueOf(total);
	}
 	
	public String getTotalInvestmentString() {
		double total = 0.0;
		for (Investment investment : investments) {
			total += investment.getAmount();
		}
		return "$" + String.valueOf(total);
	}
	
	public void setDefaultFrequency() {
		this.payCheckFrequency = Frequency.Monthly;
	}
	
}