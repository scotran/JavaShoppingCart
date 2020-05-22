<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/resources/css/navbar.css'/>"/>
<link rel="stylesheet" href="<c:url value='/resources/css/shopping.css'/>"/>
<title>Shopping</title>
</head>
<body>
	
	<c:if test="${user == null}">
		<c:redirect url="login.jsp"/>
	</c:if>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
   	%>
	
	<ul>
		<li><a class="active" href="shopping.jsp">Shop</a></li>
		<li><a href="cart.jsp">Cart</a></li>
		<li><a href="inventory.jsp">Inventory</a></li>
		<li id="balanceli"><span id="balance">Current Balance: $<c:out value="${user.getBalance()}"/></span></li>
		<li><a href="userControl?action=logout">Logout</a></li>
	</ul>
	
	<div class="main">
	
	<div class="container">
		<img src="<c:url value='/resources/images/sneakers.jpg'/>" alt="Sneakers">
		<span class="title">New Balance 574 Sneakers</span>
		<span>$80.00</span>
		<form action="inventoryControl">
			<input type="hidden" name="action" value="add">
			<input type="hidden" name="item" value="item1">
			<div><span>Quantity: </span><input type="text" name="quantity"></div>
			<input type="submit" value="Add to cart">
		</form>
	</div>
	
	<div class="container">
		<img src="<c:url value='/resources/images/laptop.jpg'/>" alt="Laptop">
		<span class="title">Apple Macbook Pro</span>
		<span>$1000.00</span>
		<form action="inventoryControl">
			<input type="hidden" name="action" value="add">
			<input type="hidden" name="item" value="item2">
			<div><span>Quantity: </span><input type="text" name="quantity"></div>
			<input type="submit" value="Add to cart">
		</form>
	</div>
	
	<div class="container">
		<img src="<c:url value='/resources/images/keyboard.jpg'/>" alt="Keyboard">
		<span class="title">Vortex POK3R Mechanical Keyboard</span>
		<span>$150.00</span>
		<form action="inventoryControl">
			<input type="hidden" name="action" value="add">
			<input type="hidden" name="item" value="item3">
			<div><span>Quantity: </span><input type="text" name="quantity"></div>
			<input type="submit" value="Add to cart">
		</form>
	</div>
	
	<div class="container">
		<img src="<c:url value='/resources/images/book.jpg'/>" alt="Book">
		<span class="title">The Richest Man in Babylon</span>
		<span>$8.00</span>
		<form action="inventoryControl">
			<input type="hidden" name="action" value="add">
			<input type="hidden" name="item" value="item4">
			<div><span>Quantity: </span><input type="text" name="quantity"></div>
			<input type="submit" value="Add to cart">
		</form>
	</div>
	
	<div class="container">
		<img src="<c:url value='/resources/images/ring.jpg'/>" alt="Ring">
		<span class="title">Cartier Diamond Wedding Band</span>
		<span>$6650.00</span>
		<form action="inventoryControl">
			<input type="hidden" name="action" value="add">
			<input type="hidden" name="item" value="item5">
			<div><span>Quantity: </span><input type="text" name="quantity"></div>
			<input type="submit" value="Add to cart">
		</form>
	</div>
	
	<div class="container">
		<img src="<c:url value='/resources/images/banana.jpg'/>" alt="Banana">
		<span class="title">Mystical Banana</span>
		<span>$2000.00</span>
		<form action="inventoryControl">
			<input type="hidden" name="action" value="add">
			<input type="hidden" name="item" value="item6">
			<div><span>Quantity: </span><input type="text" name="quantity"></div>
			<input type="submit" value="Add to cart">
		</form>
	</div>
	
	</div>
	
</body>
</html>