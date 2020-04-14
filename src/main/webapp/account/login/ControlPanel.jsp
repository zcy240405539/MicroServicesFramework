<!DOCTYPE html>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.servlet.http.Cookie"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>Control Panel � <s:property value="userid" /></title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/navbars/">

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


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
<!-- Custom styles for this template -->
<link href="navbar.css" rel="stylesheet">
</head>
<body>

	<c:import url="/layouts/header.jsp" />
	
	<% 
		Cookie[] cookies = request.getCookies();
		String result = null;
		for (Cookie cookie : cookies) {	
			if (cookie.getName().equals("userid")) {
				result = cookie.getValue();
				System.out.println("cookie: "+cookie.getName()+"="+result);
				break;
			}
		}

	%>

	<main role="main">
		<div class="jumbotron">
			<div class="col-sm-8 mx-auto">
				<h1>
					WELCOME - This is control Panel ${sessionScope.userid}
				</h1>
				<p>This example is a quick exercise to illustrate how the navbar
					and its contents work.</p>
				<p>At the smallest breakpoint, the collapse plugin is used to
					hide the links and show a menu button to toggle the collapsed
					content.</p>
				<p>
					<a class="btn btn-primary" href="/account/update/Update.html"
						role="button">Update</a>
				</p>
				<p>
					<a class="btn btn-danger" href="/account/destroy/Destroy.html"
						role="button">Destroy</a>
				</p>
			</div>
		</div>
	</main>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="https://getbootstrap.com/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script src="/docs/4.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
</body>
</html>
