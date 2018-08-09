package com.shopkart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class RegisterCheck
 */
@WebServlet("/RegisterCheck")
public class RegisterCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO uDao = (ShopKartDAO) context.getBean("eDao");
		ArrayList<Users> usList = uDao.getUsers("select * from Users where username='"+userName+"'");
		if(usList.size()>0) {
			request.setAttribute("msg", "User name already exists");
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			return;
		}
		uDao.updateTable("insert into Users values('"+userName+"','"+password+"','"+email+"','"+address+"')");
		request.getRequestDispatcher("Login.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
