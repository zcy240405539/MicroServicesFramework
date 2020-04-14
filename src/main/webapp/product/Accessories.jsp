<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accessories</title>
	<link href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>

	<jsp:include page="/layouts/header.jsp" flush="true" />

	<main role="main">
		<br><br>
		<div class="container">
			<div class="card-deck">
				<s:iterator value="allProducts" status="all">
					<div class="card">
						<img class="card-img-top" style="height:100%;width:100%;" src="${picture}" alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">${pname}</h5>
							<p class="card-text">$${price}</p>
						</div>
						<a class="btn btn-info" href="/checkProduct?pid=${pid}">Order</a>
					</div>
				</s:iterator>
			</div>
			<br>
			
		<!-- 
		<div class="card-deck">
			<div class="card">
				<img class="card-img-top" src="<s:property value="pictures[0]" />"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">
						<s:property value="pnames[0]" />
					</h5>
					<p class="card-text">
						<s:property value="prices[0]" />
					</p>
				</div>
				<a class="btn btn-primary" href="/checkProduct?pid=<%= request.getAttribute("pids[0]") %>" >Details</a>
			</div>
		</div>
		-->	
			
		</div>
	</main>
</body>
</html>