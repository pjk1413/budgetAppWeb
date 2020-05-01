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
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
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
		HttpSession session = request.getSession(true);
	
		User user = new User(request.getParameter("email"), request.getParameter("password"));
		
		if (UserDB.validateUser(user)) {
			//fill in user data
			user = UserDB.loadUser(user.getEmail());
			
			session.setAttribute("user", user);
			RequestDispatcher rs = request.getRequestDispatcher("user_home.jsp");
			rs.forward(request, response);
		} else {
			request.setAttribute("error", "Incorrect username or password");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);
		}
	}

}
