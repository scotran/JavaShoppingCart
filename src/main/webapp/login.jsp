<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<html>
<head>
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>"/>
<title>Log In</title>
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
	
		<h2>Login</h2>
		<form action="userControl">
			<span>Username:</span> <input type="text" name="username"> <br>
			<span>Password:</span> <input type="password" name="password"> <br>
			<input type="hidden" name="action" value="login">
			<input id="button" type="submit" value="Login"> 
		</form>
	
	</div>
	
	<c:if test = "${param.login == 'failed'}">
	   	<p>Incorrect username or password</p>
	</c:if>
	<c:if test = "${param.signup == 'successful'}">
	   	<p>You account has been created</p>
	</c:if>
	
	<a href="signup.jsp">Create Account</a>
	
</body>
</html>
