package com.shopkart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (BusinessObject.isAdmin(userName, password)) {
			HttpSession session=request.getSession(true);
			session.setAttribute("userName","admin");
			request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
		}
		PrintWriter printWriter = response.getWriter();
		ArrayList<Users> list = BusinessObject.getUsers(userName,password); 
		if (list.size() > 0) {
			HttpSession session=request.getSession(true);
			session.setAttribute("userName",userName);
			request.getRequestDispatcher("CustomerHome.jsp").forward(request, response);
		} else {
			printWriter.println("<script>alert('Invalid UserName or Password');</script>");
			printWriter.println("<a href=\"http://localhost:8081/ShopKart/Login.html\">Re-Login</a>");			
		}
	}
}
