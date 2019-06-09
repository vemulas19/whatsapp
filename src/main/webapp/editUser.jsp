<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update user details</title>
</head>
<body>

   <h3>Update User Details</h3>
<form action="updateUser">
		Name : <input type="text" name="name" value="${userObj.name}"><br> <br>
		Mobile : <input type="text" name="mobile" value="${userObj.mobile}"><br> <br>
		mail id : <input type="text" name="mailid"  readonly="readonly" value="${userObj.mailid}"><br> <br>
		City : <input type="text" name="city" value="${userObj.city}"><br> <br>
		Password :  <input type="text" name="pword" value="${userObj.pword}"><br> <br>
		<input type="submit" value="Update">
	</form>

</body>
</html>