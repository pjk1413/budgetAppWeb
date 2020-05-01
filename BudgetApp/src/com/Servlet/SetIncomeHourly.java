package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.User;
import com.User.UserDB;

/**
 * Servlet implementation class SetIncomeHourly
 */
@WebServlet("/SetIncomeHourly")
public class SetIncomeHourly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetIncomeHourly() {
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
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		user = UserDB.loadUser(user.getEmail());
		
		double hours = Double.parseDouble(request.getParameter("hours"));
		double wage = Double.parseDouble(request.getParameter("wage"));
		user.setIncome((hours * wage) * 52);
		
		UserDB.updateUser(user);
		
		session.setAttribute("user", user);
		
		RequestDispatcher rs = request.getRequestDispatcher("income_home.jsp");
		rs.forward(request, response);
	}

}
