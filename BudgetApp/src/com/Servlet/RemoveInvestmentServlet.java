package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.Investment;
import com.User.User;
import com.User.UserDB;


/**
 * Servlet implementation class RemoveInvestmentServlet
 */
@WebServlet("/RemoveInvestmentServlet")
public class RemoveInvestmentServlet extends HttpServlet {
	private static final long serialVersionUID= 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveInvestmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		ArrayList<Investment> investments = new ArrayList<Investment>();
		
		User user = (User)session.getAttribute("user");
		user = UserDB.loadUser(user.getEmail());
		
		investments = user.getInvestments();
		
		double amount = UserDB.nullDouble(request.getParameter("removeAmount"));
		double rate = UserDB.nullDouble(request.getParameter("removeRateOfReturn"));
		
		Investment investment = new Investment();
		investment.setAmount(amount);
		investment.setRateOfReturn(rate);
		
		for (Investment i : user.getInvestments()) {
			if (i.getAmount() == amount && i.getRateOfReturn() == rate) {
				investment = i;
			}
		}
		
		investments.remove(investment);
		
		user.setInvestments(investments);
		
		UserDB.updateUser(user);
		
		session.setAttribute("user", user);
		
		RequestDispatcher rs = request.getRequestDispatcher("income_manage_investments.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
