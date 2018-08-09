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
 * Servlet implementation class AddProductsServlet
 */
@WebServlet("/AddProductsServlet")
public class AddProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductsServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg;
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String cat = request.getParameter("cat");
		int price = Integer.parseInt(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int dis = Integer.parseInt(request.getParameter("dis"));
		int tax = Integer.parseInt(request.getParameter("tax"));

		Product p = new Product();
		p.setProductId(pid);
		p.setProductName(pname);
		p.setCategory(cat);
		p.setPrice(price);
		p.setQuantity(qty);
		p.setDiscountPerc(dis);
		p.setTaxRate(tax);

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO uDao = (ShopKartDAO) context.getBean("eDao");
		ArrayList<Product> plist = uDao.getProducts("select * from Product where productId='" + pid + "'");
		if (plist.size() > 0) {
			msg = "Product Id " + pid + " already exists";
		} else {
			int rowaff = uDao.updateTable("INSERT INTO PRODUCT VALUES('" + pid + "','" + pname + "','" + cat + "',"
					+ price + "," + qty + "," + dis + "," + tax + ")");
			if (rowaff > 0) {
				msg = "Product inserted Successfully";
			} else {
				msg = "Product not inserted. Try again";
			}
		}
		request.setAttribute("addmsg", msg);
		request.getRequestDispatcher("AddProducts.jsp").forward(request, response);
	}

}
