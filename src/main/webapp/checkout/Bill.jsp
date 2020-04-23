<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<link
	href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>

	<c:import url="/layouts/header.jsp" />

	<main role="main">
		<br><br>
		<div class="container">
		<h2><center>Check out</center></h2>
			<br>
			<div id="bill">
				<form action="checkout" method="post">
					<hr>
					<h4><center>Shipping/Billing Address</center></h4>
					<div class="form-row">
						<div class="col-6">
						<label>Street</label> 
						<input type="text" class="form-control" id="streetTextBox" name="street">
						</div>
						<div class="col-2">
						<label>City</label> 
						<input type="text" class="form-control" id="cityTextBox" name="city">
						</div>
						<div class="col-2">
						<label>State</label> 
						<input type="text" class="form-control" id="stateTextBox" name="state">
						</div>
						<div class="col-2">
						<label>Zipcode</label> 
						<input type="text" class="form-control" id="zipcodeTextBox" name="zipcode">
						</div>
					</div>				
				
					<hr>
					<h4><center>Payment Card</center></h4>
					<div class="form-group">
						<label for="cardTextBox">Card Number</label> 
						<input type="number" class="form-control" id="cardTextBox" name="card"> 
					</div>
					<div class="form-group">
						<label for="cardnameTextBox">Name on card</label> 
						<input type="text" class="form-control" id="cardnameTextBox" name="cardname">
					</div>
					<div class="form-row">
						<div class="form-group"><label>Expiration date </label></div>
						<div class="col">
							<input type="number" class="form-control" id="datemonth" name="datemonth" placeholder="MM">
						</div>
						<div class="col">
							<input type="number" class="form-control" id="dateyear" name="dateyear" placeholder="YYYY">
						</div>
					</div>
					<button type="submit" class="btn btn-success" style="margin:20px;">Place Order</button>
				</form>
			</div>	
		
		
			<!-- <a class="btn btn-success" href="/checkout" role="button">Place Order</a> -->
		</div>
		<br><br>
	</main>
</body>
</html>