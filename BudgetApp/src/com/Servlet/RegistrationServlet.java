package com.Servlet;

import com.User.UserDB;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.Address;
import com.User.Investment;
import com.User.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setFirstName(request.getParameter("firstName")); 
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setIncome(Double.parseDouble(request.getParameter("income")));
		user.setFilingStatus(request.getParameter("filingStatus"));
		user.setDefaultFrequency();
		
		Address address = new Address();
		address.setStreet(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setZipcode(request.getParameter("zipcode"));
		
		user.setAddress(address);
		
		ArrayList<Investment> investments = new ArrayList<Investment>();
		investments.add(new Investment(0.0));
		
		ArrayList<Double> expenses = new ArrayList<Double>();
		expenses.add(0.0);
		
		user.setInvestments(investments);
		user.setExpenses(expenses);
		
		UserDB.writeUser(user);
		//-----
		
		
		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);
		
		RequestDispatcher rs = request.getRequestDispatcher("user_home.jsp"); //brings to a new page
		rs.forward(request, response);
	}

}
