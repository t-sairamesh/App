<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in</title>
</head>
<body>
<h3>Sign in</h3>
<table>
	<form action ="signinservlet" method = "post">
	
	   <tr><td>Email : </td><td> <input type="text" name="email"></td></tr>
	   <tr><td>Password :</td><td> <input type ="password" name = "password"></td></tr>
	   <tr><td><input type = "submit" value = "Sign in"></td></tr>
	  
	   
	
	</form>
</table>
    <form action = "Signup.jsp">
        <input type = "submit" value = "Signup">
    </form>
</body>
</html>