<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Product</title>
</head>
<body>
<%if (session != null) {
				String name = (String) session.getAttribute("userName");
				if (name == null) {
					System.out.print("UserName Not Found!!!");
					response.getWriter().print("Something went Wrong Session<br>Please Login Again<a href=\"Login.html\">Login</a>");
					return;
				}				
			}%><form>
					<button formaction="http://localhost:8081/ShopKart/ProductsServlet">GO
						BACK</button></td></form>
<form action="http://localhost:8081/ShopKart/DeleteProductsServlet" method="post">
<table>
<tr>
<td>Product id</td>
<td><input type="text" name="pid" id="t1"/></td>
</tr>
<tr>
<td colspan="2"><button type="submit" id="b1">REMOVE</button><button type="reset">CLEAR</button></td>
</tr>
</table>
</form>

<% String msg=(String)request.getAttribute("addmsg");%>
<%if(msg!=null)
	{out.println(msg);}%>
</body>
</html>