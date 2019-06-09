<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function deleteUser(mailId) {
	alert('triggred Delete button ' + mailId);
	//http://localhost:8080/whatsapp/deleteUser?mailIdToDelete='virat@gmail.com'
	document.forms[0].action="${pageContext.request.contextPath}/deleteUser?mailIdToDelete="+mailId;
	document.forms[0].method="post";
	document.forms[0].submit();	
	//submit to deleteUser action from here
}

function editUser(mailId) {
	alert('triggered Edit button' + mailId);
	document.forms[0].action="${pageContext.request.contextPath}/editView?mailId="+mailId;
	document.forms[0].method="post";
	document.forms[0].submit();	
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 
${myUser.name}</br>
${myUser.mobile}</br>
${myUser.mailid}</br>
${myUser.city} --%>
<a href="<cr:url value="/j_spring_security_logout" />" >Logout</a>
	<form action="">
	<!-- Need to writh for each in jsp to iterate userList -->
	<table border="3">
		<tr>
		 	<th>Name</th>
		 	<th>Mobile</th>
		 	<th>Mail</th>
		 	<th>City</th>
		 	<th>Password</th>
		</tr>
		<cr:forEach  var="userObject" items="${uList}">
			<tr>
				<td>${userObject.name}</td>
				<td>${userObject.mobile}</td>
				<td>${userObject.mailid}</td>
				<td>${userObject.city}</td>
				<td>${userObject.pword}</td>
				<td><input type="button" value="Edit"  onclick="editUser('${userObject.mailid}')"/> </td>
				<td><input type="button" value="Delete" onclick="deleteUser('${userObject.mailid}')"/> </td>
			</tr>
		</cr:forEach>
	</table>
	</form>
	
</body>
</html>