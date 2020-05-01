package com.Servlet;

import com.User.UserDB;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.User;

/**
 * Servlet implementation class SetIncomeServlet
 */
@WebServlet("/SetIncomeServlet")
public class SetIncomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetIncomeServlet() {
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
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		user = UserDB.loadUser(user.getEmail());
		
		user.setIncome(Double.parseDouble(request.getParameter("income")));
		
		UserDB.updateUser(user);
		
		session.setAttribute("user", user);
		
		RequestDispatcher rs = request.getRequestDispatcher("income_home.jsp");
		rs.forward(request, response);
	}

}
