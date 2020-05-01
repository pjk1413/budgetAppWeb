package com.App;

public class Defaults {
	public static final String app_name = "Budget App";
	public boolean signInError;
	
	
	public Defaults() {
		this.signInError = false;
	}
	
	public String returnError() {
		
		if (!this.signInError) {
			return "Incorrect Username or Password";
		} else {
			return "";
		}
	}
	
	public static String nullCheck(String string) {
		if (string.equals("null")) {
			return "";
		} else {
			return string;
		}
		
	}
}
