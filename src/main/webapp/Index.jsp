<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scott Zhao - Index</title>
<link
	href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link
	href="https://getbootstrap.com/docs/4.3/scss/utilities/flex.scss"
	rel="stylesheet">
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

<style>
.product-device {
	position: absolute;
	right: 10%;
	bottom: -30%;
	width: 300px;
	height: 540px;
	background-color: #333;
	border-radius: 21px;
	-webkit-transform: rotate(30deg);
	transform: rotate(30deg);
}

.product-device::before {
	position: absolute;
	top: 10%;
	right: 10px;
	bottom: 10%;
	left: 10px;
	content: "";
	background-color: rgba(255, 255, 255, .1);
	border-radius: 5px;
}

.product-device-2 {
	top: -25%;
	right: auto;
	bottom: 0;
	left: 5%;
	background-color: #e5e5e5;
}

	@media (max-width:768px) {
		#homesubbox1{
			width: 100% !important;
		}
		#homesubbox2{
			width: 100% !important;
		}
	}
</style>

</head>
<body>
	<jsp:include page="/layouts/header.jsp" flush="true"/>
	<main role="main">
		<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light" style="margin: 0rem !important;">
			<div class="col-md-5 p-lg-5 mx-auto my-5">
				<h1 class="display-4 font-weight-normal">Welcome to Scotty's Store!</h1>
				<p class="lead font-weight-normal">${sessionScope.userid}</p>
				<a class="btn btn-outline-secondary" href="/archive">Read More</a>
			</div>
			<div class="product-device shadow-sm d-none d-md-block"></div>
			<div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
		</div>

		<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3" style="padding-left: 0rem !important; margin-bottom: 0rem !important;">
			<div class="bg-dark mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden" style="width: 50%" id="homesubbox1">
				<div class="my-3 py-3">
					<h2 class="display-5">Phone</h2>
					<p class="lead">Check out our newest phone!</p>
				</div>
				<a class="nav-link" href="/checkCategory?category=Phone">
					<div class="bg-light shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
				</a>
			</div>
			<div class="bg-light mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden" style="margin-right: 0rem !important;width: 50%"  id="homesubbox2">
				<div class="my-3 p-3">
					<h2 class="display-5">Accessories</h2>
					<p class="lead">Check out other accessories!</p>
				</div>
				<a class="nav-link" href="/checkCategory?category=Accessories">
					<div class="bg-dark shadow-sm mx-auto" style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;"></div>
				</a>
			</div>
		</div>
	</main>

</body>
</html>