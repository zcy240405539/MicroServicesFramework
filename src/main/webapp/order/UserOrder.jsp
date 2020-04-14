<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Order</title>
<link
	href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/layouts/header.jsp" flush="true" />

	<main role="main">
		<br><br>
		<div class="container">
			<s:iterator value="orders" status="all">
				<div class="row" style="border:1px #ddd solid;">
					<div class="container" style="background-color:#f6f6f6 !important;border:1px #ddd solid;">
						<p>Order Placed: ${orderTime}</p>
						<p>Total Price: $${totalPrice}</p>
						<p>Order# ${orderid}</p>
					
					</div>
					
					<div class="container" style="border:1px #ddd solid;">
						<s:iterator value="item" status="all">
							<div class="row" style="border:1px #ddd solid;padding:10px;">
							<div class="col-sm-4">
								<img class="card-img-top" src="${product.picture}" alt="Card image cap" style="width:100px;height:100px;">
							</div>
							<div class="col-sm-8">
								<h5><b>${product.pname}</b></h5>
								<h6>Price: $${product.price}</h6>
								<h6>OrderID: ${orderid}</h6>
								<h6>Quantity: ${quantity}</h6>
							</div>
							</div>
						</s:iterator>

					</div>
				</div>
			</s:iterator>
			<hr>
		</div>
		<br><br>
	</main>

</body>
</html>