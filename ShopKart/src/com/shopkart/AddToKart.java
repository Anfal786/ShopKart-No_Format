package com.shopkart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shopkart.Product;
import com.shopkart.ShopKartDAO;

import oracle.net.aso.q;

/**
 * Servlet implementation class AddToKart
 */
@WebServlet("/AddToKart")
public class AddToKart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToKart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String sql = "select * from Product where productId='"+productId+"'";
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO sp = (ShopKartDAO) context.getBean("eDao");
		ArrayList<Product> productList = sp.getProducts(sql);
		int currentProductQuantity=productList.get(0).getQuantity();
		if(quantity>currentProductQuantity) {
			request.setAttribute("msg", "We Only have "+currentProductQuantity+" Available!!!");
			request.getRequestDispatcher("CustomerHome.jsp").forward(request, response);
			return;
		}	
		sql = "update product set quantity="+(currentProductQuantity-quantity)+" where productId='"+productId+"'";
		sp.updateTable(sql);
		sql="select * from Transaction where ProductId='"+productId+"'";
		ArrayList<Transaction> transList = sp.getTrans(sql);
		if(transList.size()>0) {
			//update
			int currentTransQuantity = transList.get(0).getQuantity()+quantity;
			sql = BusinessObject.getTransQuery(productId, currentTransQuantity, "update");
		}
		else
		{
			//insert			
			sql =BusinessObject.getTransQuery(productId, quantity, "insert");
		}
		sp.updateTable(sql);
		request.setAttribute("msg", "Item Added to Cart");
		request.getRequestDispatcher("CustomerHome.jsp").forward(request, response);
	}

}
