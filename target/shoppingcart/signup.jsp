<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>"/>
<title>Sign Up</title>
</head>
<body>

	<c:if test = "${user != null}">
		<% response.sendRedirect("shopping.jsp"); %>
	</c:if>
	
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
   	%>
   	<h2 class="title">Virtual Shopping Cart</h2>
   	
   	<div class="loginbox">
   	
		<h2>Sign Up</h2>
		<form action="userControl">
			<span>Username:</span> <input type="text" name="username"> <br>
			<span>Password:</span> <input type="password" name="password"> <br>
			<input type="hidden" name="action" value="signup">
			<input id="button" type="submit" value="Create Account">
		</form>
		
	</div>
	
	<c:if test = "${param.signup == 'failed'}">
   		<p>Account has already been created or invalid username or password</p>
	</c:if>
	
	<a href="login.jsp">Back to Login</a>
</body>
</html>