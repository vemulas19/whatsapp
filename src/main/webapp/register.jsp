<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">${message}</font>
	<form action="saveUser">
		Name : <input type="text" name="name"><br> <br>
		Mobile : <input type="text" name="mobile"><br> <br>
		mail id : <input type="text" name="mailid"><br> <br>
		City : <input type="text" name="city"><br> <br>
		Password :  <input type="text" name="pword"><br> <br>
		<input type="submit" value="Register">
	</form>
	<a href="login.jsp">Click Here</a> for login page
	<form action="test">
	   <input type="submit" value="test">
	
	</form>
	
</body>
</html>