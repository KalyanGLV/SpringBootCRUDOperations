<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form method="POST" action="/login">


		Please login with you credentials: <br> <br> UserName:<input
			type="text" name="userNmae" /><br />
		<br /> Password :<input type="password" name="password" /><br />
		<br /> <input type="submit" value="login" /> <input type="reset"
			value="Reset">



	</form>
</body>
</html>
