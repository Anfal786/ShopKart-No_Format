package com.shopkart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class DeleteProductsServlet
 */
@WebServlet("/DeleteProductsServlet")
public class DeleteProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pid=request.getParameter("pid");
		
		Product p=new Product();
		p.setProductId(pid);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO uDao = (ShopKartDAO) context.getBean("eDao");		
		int rowaff=uDao.updateTable("DELETE FROM PRODUCT WHERE PRODUCTID='"+pid+"'");
		String msg;
		if(rowaff>0)
		{
			msg="Product deleted Successfully";
		}
		else
		{
			msg="Product not Found. Try Again";
		}
		request.setAttribute("addmsg",msg);
		request.getRequestDispatcher("DeleteProducts.jsp").forward(request, response);
	}

}
