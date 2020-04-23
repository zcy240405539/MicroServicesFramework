<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
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
			<s:if test="%{allItems.size()>0}" >
			<ul class="list-group">
				<div class="row">
						<div class="col-sm-4">
							<h4>Shopping Cart</h4>
						</div>
						<!-- 
						<div class="col-sm-8">
							<h4 style="float:right;">Price</h4>
						</div>
						-->
				</div>
				<s:iterator value="allItems" status="all">
					<li class="list-group-item">
					<div class="row">
						<div class="col-sm-4">
							<img class="card-img-top" style="height:180px;width:150px;" src="${prodPicture}" alt="Card image cap">
						</div>
						<div class="col-sm-6">
							<h2>${prodName}</h2>
							<br>
							<h5>Quantity: ${prodCount}</h5>
							<h5>Unit Price: $${prodPrice}</h5>
						</div>
						
						<div class="col-sm-2">
							<h4 id="totalPriceBox" style="color:#ff0000;padding-bottom: 10px;"><a style="color:#000000;">Price: </a>$${totalPrice}</h4>							
							<a class="btn btn-danger btn-sm" href="destroyItem?prodID=${prodID}" role="button">Delete</a>					
							<br><br>
							<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#itemModal">Change Quantity</button>
							
							<div class="modal fade" id="itemModal" tabindex="-1" role="dialog" aria-labelledby="itemModal" aria-hidden="true">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							    <form action="updateItem" method="post">
							      <div class="modal-body">
								      	<input type="text" id="prodIDBox" name="prodID" value="${prodID}" style="display:none;"> 
								      	<label for="prodIDBox">Quantity</label> 
								      	<input type="number" class="form-control" id="prodCountBox" name="prodCount" style="width:100px;"value="${prodCount}">
								     
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							        <button type="submit" class="btn btn-warning" >Save changes</button>
							      </div>
							    </form>
							    </div>
							  </div>
							</div>
							<br>
							
						</div>
						
					</div>
					</li>

				</s:iterator>
			</ul>
			<br><br>
			<div class="row">
				<div class="col">
					<a class="btn btn-success" href="/bill" role="button">Process to Checkout</a>
				</div>
				<div class="col">
					<h4 style="float:right;">Subtotal: <b id="subTotalPriceBox" style="color:#ff0000;">$${subTotal}</b> </h4>
				</div>
			</div>
					
			</s:if>
			
			<s:if test="%{allItems.size()<=0}" >
				<h1><b>Your Shopping Cart is empty.</b></h1>
			</s:if>
			</div>
			
			<br>
	</main>

</body>
</html>