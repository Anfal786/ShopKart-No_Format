<%@page import="com.shopkart.BusinessObject"%>
<%@page import="com.shopkart.Transaction"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.shopkart.Product"%>
<%@page import="com.shopkart.ShopKartDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">

    <%if (session != null) {
				String name = (String) session.getAttribute("userName");
				if (name == null) {
					System.out.print("UserName Not Found!!!");
					response.getWriter().print("Something went Wrong Session<br>Please Login Again<a href=\"Login.html\">Login</a>");
					return;
				}				
			}%>
<%if(!(request.getAttribute("msg") == null )){%>
	alert('<%out.print(request.getAttribute("msg"));%>');
	<%}%>
	</script>
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Product Name</th>
			<th>Quantity</th>
			<th>Discount</th>
			<th>Net Amount</th>
		</tr>
		<%
			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
			ShopKartDAO sp = (ShopKartDAO) context.getBean("eDao");
			ArrayList<Transaction> transList = sp.getTrans("select * from Transaction");
			for (Transaction trans : transList) {
				String productName = BusinessObject.getProductName(trans.getProductId());
		%>
		<tr>
			<%
				out.print("<td>" + productName + "</td>");
					out.print("<td>" + trans.getQuantity() + "</td>");
					out.print("<td>" + trans.getDistcountAmt() + "</td>");
					out.print("<td>" + trans.getNetAmt() + "</td>");
			%>
		</tr>
		<%
			}
		%>
	</table>
	<form action="http://localhost:8081/ShopKart/AddToKart" method="post">
		<%
			ArrayList<Product> productList = sp.getProducts("select * from Product");
		%>
		<select name="productId">
			<%
				for (Product p : productList) {
			%>
			<option value="<%out.print(p.getProductId());%>">
				<%
					out.print(p.getProductName());
				%>
			</option>
			<%
				}
			%>
		</select> Quantity:<input type="number" name="quantity" required> <input
			type="submit" value="Add to Cart">
	</form>
	<form action="http://localhost:8081/ShopKart/CancelServlet">
		<input type="submit" value="Cancel">
	</form>
	<form action="http://localhost:8081/ShopKart/PaymentServlet">
		<input type="submit" value="Shop">
	</form>
	<form action="http://localhost:8081/ShopKart/LogoffServlet">
		<input type="submit" value="LogOff">
	</form>
</body>
</html>