<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<!-- Custom styles for this template -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/account/Register.js"></script>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


</head>
<body class="text-center">

	<c:import url="/layouts/header.jsp" />

	<main role="main" class="inner cover">
		<br>
		<br>
		<div class="container">
			<h1 class="cover-heading" id="pageTitle">Update</h1>
			<br>

			<div id="update">
				<form action="updateAction" method="post">
					<div class="form-group">
						<label for="passwordTextBoxReg">Current Password</label> <input
							type="password" class="form-control" id="passwordTextBoxReg"
							name="currentpwd"> <small id="passwordHelpReg"
							class="form-text text-danger" style="display: none;">Please
							do not leave password blank!</small>
					</div>
					<div class="form-group">
						<label for="passwordTextBoxReg">New Password</label> <input
							type="password" class="form-control" id="passwordTextBoxReg"
							name="pwd"> <small id="passwordHelpReg"
							class="form-text text-danger" style="display: none;">Please
							do not leave password blank!</small>
					</div>
					<div class="form-group">
						<label for="usernameTextBoxReg">Your First Name</label> <input
							type="text" class="form-control" id="usernameTextBoxReg"
							name="firstname"> <label for="usernameTextBoxReg">Your
							Last Name</label> <input type="text" class="form-control"
							id="usernameTextBoxReg" name="lastname">
					</div>
					<div class="form-group">
						<label for="addressTextBoxReg">Your Address</label> <input
							type="text" class="form-control" id="addressTextBoxReg"
							name="address">
					</div>
					<button type="submitReg" class="btn btn-success"
						style="margin: 20px;">Submit</button>
					<br>
					<a class="btn btn-danger" style="margin:20px;" href="/destroyAction"
						role="button">Destroy</a>

				</form>
			</div>
		</div>
		<br>
		<br>
	</main>


	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>