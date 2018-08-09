<%@page import="com.shopkart.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center" cellspacing="0" cellpadding="10px">
<tr>
<th>Product ID</th>
<th>Product Name</th>
<th>Category</th>
<th>Price</th>
<th>Quantity</th>
<th>Discount %</th>
<th>Tax Name</th>
</tr>
<%
	ArrayList<Product> al=(ArrayList<Product>)request.getAttribute("al");
	for(int i=0;i<al.size();i++)
	{
%><tr>
		<td><%=al.get(i).getProductId()%></td>
		<td><%=al.get(i).getProductName()%></td>
		<td><%=al.get(i).getCategory()%></td>
		<td><%=al.get(i).getPrice()%></td>
		<td><%=al.get(i).getQuantity()%></td>
		<td><%=al.get(i).getDiscountPerc()%></td>
		<td><%=al.get(i).getTaxRate()%></td>
		</tr>
<%}%>
</table>
<br/>
<br/>
<form>
<button type="submit" name="addprod" formaction="http://localhost:8081/ShopKart/AddProducts.jsp">Add Products</button>
<button type="submit" name="updprod" formaction="http://localhost:8081/ShopKart/UpdateProducts.jsp">Update Products</button>
<button type="submit" name="remprod" formaction="http://localhost:8081/ShopKart/DeleteProducts.jsp">Remove Products</button>
<button type="submit" formaction="http://localhost:8081/ShopKart/AdminHome.jsp">GO BACK</button>
</form>
</body>
</html>