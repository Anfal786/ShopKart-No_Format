<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base>
<script type="text/javascript">
<%if (!(request.getAttribute("msg") == null)) {%>
alert('<%out.print(request.getAttribute("msg"));%>
	');
<%}%></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8081/ShopKart/RegisterCheck"
		method="post">
		User Name:<input type="text" name="userName" required> Email:<input
			type="email" name="email" required> Password:<input
			type="text" name="password" required> Address:
		<textarea cols=20 row=4 name="address"></textarea>
		<input type="submit" value="Register">
	</form>
</body>
</html>