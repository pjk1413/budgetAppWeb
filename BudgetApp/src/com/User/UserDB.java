package com.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDB {
	
	public static final String path = "C:\\users\\pjk14\\desktop\\java\\DataFiles\\userlist.txt";
	public static final String d = ";";
	
	

	/**
	 * Loads a user based on an email address of a user
	 * @param String email
	 * @return
	 */
	public static User loadUser(String email) {
		ArrayList<User> userList = loadAllUsers();
		
		for (User u : userList) {
			if (u.getEmail().contentEquals(email)) {
				return u;
			}
		}
		
		return new User();
	}

	
	/**
	 * Write user data to file in a parsable string
	 * @param user object - must be completed or throws an error
	 */
	public static void writeUser(User user) {
		//first last email password income filingstatus address paycheckfrequency investments expenses
		//**** Order of parameters in string for storing data
		try {
			
			File file = new File(path);
			FileWriter fr = new FileWriter(file, true);
			fr.write(user.toString());
			fr.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Updates the current user in the database by deleting and rewriting all data
	 * @param user - must contain at least an email
	 */
	public static void updateUser(User user) {
		deleteUser(user.getEmail());
		writeUser(user);
	}
	
	
	/**
	 * Given an email, will remove user from the database
	 * @param <String> email 
	 */
	public static void deleteUser(String email) {
		ArrayList<User> userList = loadAllUsers();
		User user = new User();
		for (User us : userList) {
			if (us.getEmail().contentEquals(email)) {
				user = us;
			}
		}
		userList.remove(user);
		
		File file = new File(path);
		
		System.out.println(file.delete());
		
		for (User u : userList) {
			writeUser(u);
		}
	}
	
	
	/**
	 * Determines if a double value is valid
	 * @param str takes a string
	 * @return a double
	 */
	public static double nullDouble(String str) {
		System.out.println(str);
		if (null == str || str.contentEquals("null")) {
			return 0.0;
		}
		
		return Double.parseDouble(str);
	}
	
	
	/**
	 * Creates a user from a string fed by the database
	 * @param str provided from db
	 * @return a user
	 */
	public static User readUser(String str) {
		//first last email password income filingstatus address paycheckfrequency investments expenses
		User user = new User();
		
		String[] s = str.split(d);
		user.setFirstName(s[0]);
		user.setLastName(s[1]);
		user.setEmail(s[2]);
		user.setPassword(s[3]);
		user.setIncome(nullDouble(s[4]));
		user.setFilingStatus(s[5]);
		user.setAddress(new Address(s[6]));
	
		user.setPayCheckFrequency(parseFrequency(s[7]));
		user.setInvestments(parseInvestments(s[8]));
		user.setExpenses(parseExpenses(s[9]));
		
		return user;
	}
	
	
	/**
	 * Used by readUser to create a user from DB
	 * @param str
	 * @return
	 */
	private static ArrayList<Double> parseExpenses(String str) {
		ArrayList<Double> expenseList = new ArrayList<Double>();
		
		if (str.length()-1 == str.indexOf("E")) {
			str = str.replace('E', ' ').trim();
			
			expenseList.add(Double.parseDouble(str));
			return expenseList;
		} 
		
		
		String[] i = str.split("E");
		for (String e : i) {
			expenseList.add(Double.parseDouble(e));
		}
		
		return expenseList;	
	}
	
	
	/**
	 * Used by readUser to create a user from DB
	 * @param str
	 * @return 
	 */
	private static ArrayList<Investment> parseInvestments(String str) {
		ArrayList<Investment> investmentList = new ArrayList<Investment>();
		String[] i = str.split("T");
		
		for (String s : i) {
			Investment investment = new Investment();
			String[] l = s.split("#");
			
			investment.setAmount(Double.parseDouble(l[0]));
			investment.setRecurring(Boolean.parseBoolean(l[1]));
			investment.setRateOfReturn(nullDouble(l[2].replace('^', ' ').trim()));
			
			investmentList.add(investment);
		}
		
		return investmentList;
	}
	
	
	/**
	 * Used by readerUser to find the enum frequency
	 * @param str
	 * @return
	 */
	private static Frequency parseFrequency(String str) {
		for (Frequency f : Frequency.values()) {
			if (f.toString().contentEquals(str.trim())) {
				return f;
			}
		}
		return Frequency.Monthly;
	}
	
	
	/**
	 * determines if a user exists in the system when being validated
	 * @return
	 */
	public static boolean validateUser(User user) {
		ArrayList<User> userList = loadAllUsers();
		
		for (User u : userList) {
			if (u.getEmail().contentEquals(user.getEmail()) && u.getPassword().contentEquals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	
	/**
	 * Loads all users into an arraylist from the database
	 * @return arrayList of users
	 */
	public static ArrayList<User> loadAllUsers() {
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			Scanner read = new Scanner(new File(path));
			
			if (read.hasNextLine()) {
				String userString = read.nextLine();
				
				User user = readUser(userString);
				userList.add(user);
			}
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			//Place an exception that can be thrown to the screen
			
			e.printStackTrace();
		}
		
		//User user1 = new User("pjk1413@gmail.com", "394508Google");
		//User user2 = new User("lma7663@gmail.com", "12345678");
		//User user3 = new User("tyler.world@hotmail.com", "0987654321");
		
		//userList.add(user1);
		//userList.add(user2);
		//userList.add(user3);
		
		return userList;
	}
}
