<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register</title>

	<!-- Bootstrap CSS -->
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
		<!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.4/examples/cover/cover.css" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/js/account/Register.js"></script>
	
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

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Scott Zhao</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link" href="/">Index</a> 
					<a class="nav-link active"  style="border-bottom:.25rem solid #fff;"  href="/account/login">Account</a> 					
					<a class="nav-link" href="/archive/index.html">Archive</a>
				</nav>
			</div>
		</header>

		<main role="main" class="inner cover">
			<h1 class="cover-heading" id="pageTitle">Register</h1>
			
			<!--  
			<p class="lead">
				<a href="#" class="btn btn-lg btn-secondary">View More</a>
			</p>
			-->
				
			<br>
			
			<div id="register">
				<form action="registerAction" method="post">				
					<div class="form-group">
						<label for="emailTextBoxReg">Email address</label> 
							<input type="email" class="form-control" id="emailTextBoxReg" name="userid"> 
							<small id="emailHelpReg" class="form-text text-danger" style="display:none;"></small>
							<small id="emailHelpReg2" class="form-text text-success" style="display:none;"></small>
					</div>			
					<div class="form-group">
						<label for="passwordTextBoxReg">Password</label> 
						<input type="password" class="form-control" id="passwordTextBoxReg" name="pwd">
						<small id="passwordHelpReg" class="form-text text-danger" style="display:none;">Please do not leave password blank!</small>
					</div>		
					<div class="form-group">
						<label for="usernameTextBoxReg">Your First Name</label> 
							<input type="text" class="form-control" id="usernameTextBoxReg" name="firstname"> 
						<label for="usernameTextBoxReg">Your Last Name</label> 
							<input type="text" class="form-control" id="usernameTextBoxReg" name="lastname"> 
					</div>	
					<div class="form-group">
						<label for="addressTextBoxReg">Your Address</label> 
							<input type="text" class="form-control" id="addressTextBoxReg" name="address"> 
					</div>							
					<button type="submitReg" class="btn btn-success" style="margin:20px;">Submit</button>	
					<a href="/account/login" class="btn btn-primary" style="margin:20px;">Login</a>
				
				</form>
			</div>			
			
		</main>

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>
					Cover template by Scott Zhao</a>.
				</p>
			</div>
		</footer>
	</div>



	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<!-- 
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	-->
		
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