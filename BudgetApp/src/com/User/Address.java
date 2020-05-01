package com.User;

public class Address {
	public static final String a = "%";
	private String street;
	private String state;
	private String city;
	private String zipcode;

	
public Address() {}

public Address(String str) {
	String[] addList = str.split(a);
	Address address = new Address();
	address.street = addList[0];
	address.city = addList[1];
	address.state = addList[2];
	address.zipcode = addList[3];
}

	public String writeAddress() {
		return this.street+a+this.city+a+this.state+a+this.zipcode;
	}

	public static Address parseAddress(String str) {
		String[] addList = str.split(a);
		Address address = new Address();
		address.street = addList[0];
		address.city = addList[1];
		address.state = addList[2];
		address.zipcode = addList[3];
		
		return address;
	}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getZipcode() {
	return zipcode;
}

public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}

}

