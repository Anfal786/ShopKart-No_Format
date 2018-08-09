<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	
<%if (session != null) {
				String name = (String) session.getAttribute("userName");
				if (name == null) {
					System.out.print("UserName Not Found!!!");
					response.getWriter().print(
							"Something went Wrong Session<br>Please Login Again<a href=\"Login.html\">Login</a>");
					return;
				}
			}%>
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Please Select the Payment Method:</h2>
	<form action="http://localhost:8081/ShopKart/BuyServlet" method="post">
		<h3>
			<input type="radio" name="mode" value="Cash">By Cash <input
				type="radio" name="mode" value="Card">By Card<br> <input
				type="submit" value="Pay">
		</h3>
	</form>
</body>
</html>