<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Products</title>
</head>
<body>
	<%
		if (session != null) {
			String name = (String) session.getAttribute("userName");
			if (name == null) {
				System.out.print("UserName Not Found!!!");
				response.getWriter().print(
						"Something went Wrong Session<br>Please Login Again<a href=\"Login.html\">Login</a>");
				return;
			}
		}
	%><form>
					<button formaction="http://localhost:8081/ShopKart/ProductsServlet">GO
						BACK</button></td></form>
	<form action="http://localhost:8081/ShopKart/AddProductsServlet"
		method="post">
		<table>
			<tr>
				<td>Product id</td>
				<td><input type="text" name="pid" required /></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="pname" required /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="cat" required /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" name="price" required /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="number" name="qty" required /></td>
			</tr>
			<tr>
				<td>Discount Percentage</td>
				<td><input type="number" name="dis" required /></td>
			</tr>
			<tr>
				<td>Tax Rate</td>
				<td><input type="number" name="tax" required /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">ADD</button>
					<button type="reset">CLEAR</button>
					</form>
					
			</tr>
		</table>

		<%
			String msg = (String) request.getAttribute("addmsg");
		%>
		<%
			if (msg != null) {
				out.println(msg);
			}
		%>
	
</body>
</html>