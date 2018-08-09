package com.shopkart;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.javafx.geom.CubicApproximator;

import oracle.net.aso.p;
import oracle.net.aso.q;

public class BusinessObject {
	public static boolean isAdmin(String userName, String password) {
		if (userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
			return true;
		else
			return false;
	}

	public static ArrayList<Users> getUsers(String userName, String password) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO uDao = (ShopKartDAO) context.getBean("eDao");
		return uDao.getUsers("select * from Users where userName='" + userName + "' and password='" + password + "'");
	}

	public static String getTransQuery(String productId, int quantity, String qType) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO pDao = (ShopKartDAO) context.getBean("eDao");
		ArrayList<Product> lst = pDao.getProducts("select * from Product where productId='" + productId + "'");
		int price = lst.get(0).getPrice() * quantity;
		int taxRate = lst.get(0).getTaxRate();
		int discountPerc = lst.get(0).getDiscountPerc();
		int discountAmt = price * discountPerc / 100;
		int taxAmt = price * taxRate / 100;
		int netAmt = price + taxAmt - discountAmt;
		String sql = null;
		if (qType.equalsIgnoreCase("insert"))
			sql = "insert into transaction values('" + productId + "'," + quantity + "," + discountAmt + "," + netAmt
					+ ")";
		else
			sql = "update transaction set Quantity=" + quantity + ", DiscountAmt=" + discountAmt + ", NetAmt=" + netAmt
					+ " where ProductId='" + productId + "'";
		return sql;
	}

	public static String getProductName(String productId) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO pDao = (ShopKartDAO) context.getBean("eDao");
		ArrayList<Product> lst = pDao.getProducts("select * from Product where productId='" + productId + "'");
		return lst.get(0).getProductName();
	}
	public static int getProductPrice(String productId) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO pDao = (ShopKartDAO) context.getBean("eDao");
		ArrayList<Product> lst = pDao.getProducts("select * from Product where productId='" + productId + "'");
		return lst.get(0).getPrice();
	}

	public static int getProductTax(String productId) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO pDao = (ShopKartDAO) context.getBean("eDao");
		ArrayList<Product> lst = pDao.getProducts("select * from Product where productId='" + productId + "'");
		return lst.get(0).getTaxRate();
	}

	public static void insertOrder(String payMethod, String userName) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO pDao = (ShopKartDAO) context.getBean("eDao");
		ArrayList<Transaction> transactionList = pDao.getTrans("select * from Transaction");
		String orderId = Integer.toString(pDao.getOrderId());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		int gross=0,tax=0,discount=0,net=0;
		String orderdate = formatter.format(date);
		for (Transaction trans : transactionList) {
			gross+=trans.getQuantity()*getProductPrice(trans.getProductId());
			tax+=gross*getProductTax(trans.getProductId())/100;
			discount+=trans.getDistcountAmt();
			net+=trans.getNetAmt();
		}
		String sql = "insert into orderdetails values('"+orderId+"','"+orderdate+"','"+userName+"','"+payMethod+"',"+gross+","+tax+","+discount+","+net+")";
		pDao.updateTable(sql);		
	}
	public static void deleteTrans() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO pDao = (ShopKartDAO) context.getBean("eDao");
		pDao.updateTable("delete from Transaction");
	}
	
	public static void revertTrans() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ShopKartDAO pDao = (ShopKartDAO) context.getBean("eDao");
		ArrayList<Transaction> transactionList = pDao.getTrans("select * from Transaction");
		for (Transaction trans : transactionList) {
			int quantity = trans.getQuantity();
			String productId = trans.getProductId();			
			ArrayList<Product> prArrayList = pDao.getProducts("select * from Product where Productid='"+productId+"'");
			quantity+=prArrayList.get(0).getQuantity();
			String sql = "update Product set Quantity="+quantity+" where productId='"+productId+"'";
			pDao.updateTable(sql);
		}
		deleteTrans();
	}
}
