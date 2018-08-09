<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin View</title>
</head>
<body>
<form>
<button type="submit" formaction="http://localhost:8081/ShopKart/ProductsServlet" method="post">View Product Details</button>
<button type="submit" formaction="http://localhost:8081/ShopKart/OrdersServlet" method="post">View Order details</button>
<button type="submit" formaction="http://localhost:8081/ShopKart/LogoffServlet">Logoff</button>
</form>
</body>
</html>