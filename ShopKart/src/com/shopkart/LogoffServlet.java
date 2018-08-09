package com.shopkart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoffServlet
 */
@WebServlet("/LogoffServlet")
public class LogoffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoffServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			String name = (String) session.getAttribute("userName");
			if(name == null) {
				response.getWriter().print("Something went Wrong Session<br>Please Login Again<a href=\"Login.html\">Login</a>");
				return;
			}
			if (!name.equals("") ) {
				session.removeAttribute("userName");
				session.invalidate();
				PrintWriter pw = response.getWriter();
				pw.println("Successfully logged out....");
				pw.println("To login, click <a href=\"http://localhost:8081/ShopKart/Login.html\">Login</a>");
				return;
			}
		}
		response.getWriter().print("Something went Wrong Session<br>Please Login Again<a href=\"Login.html\">Login</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
