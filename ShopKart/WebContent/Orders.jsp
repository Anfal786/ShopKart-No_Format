<%@page import="com.shopkart.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%if (session != null) {
				String name = (String) session.getAttribute("userName");
				if (name == null) {
					System.out.print("UserName Not Found!!!");
					response.getWriter().print("Something went Wrong Session<br>Please Login Again<a href=\"Login.html\">Login</a>");
					return;
				}				
			}%>
<table border="1" align="center" cellspacing="0" cellpadding="10px">
<tr>
<th>Order ID</th>
<th>Order Date</th>
<th>Customer Name</th>
<th>Payment Method</th>
<th>Gross Total</th>
<th>Tax</th>
<th>Discount</th>
<th>Net Total</th>
</tr>
<%
	ArrayList<Order> al=(ArrayList<Order>)request.getAttribute("al");
	for(int i=0;i<al.size();i++)
	{
%><tr>
		<td><%=al.get(i).getOrderId()%></td>
		<td><%=al.get(i).getOrderDate()%></td>
		<td><%=al.get(i).getCustomerName()%></td>
		<td><%=al.get(i).getPaymentMethod()%></td>
		<td><%=al.get(i).getGrossTotal()%></td>
		<td><%=al.get(i).getTax()%></td>
		<td><%=al.get(i).getDiscount()%></td>
		<td><%=al.get(i).getNetTotal()%></td>
		</tr>
<%}%>
</table>
<br/>
<br/>
<form>
<button type="submit" formaction="http://localhost:8081/ShopKart/AdminHome.jsp">GO BACK</button>
</form>
</body>
</html>