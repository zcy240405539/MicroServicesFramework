<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accessories</title>
<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Scott Zhao</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample04" aria-controls="navbarsExample04"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample04">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/ControlPanel">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/checkCategory?category=Phone">Phone</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/checkCategory?category=Accessories">Accessories</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Shopping
						Cart</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/account/delCookie?">Logout</a></li>
			</ul>

		</div>
	</nav>

	<main role="main">
	<div class="col-md-12 mx-auto">
	<br>
		<div class="card-deck">

			<div class="card">
				<img class="card-img-top" src="<s:property value="pictures[0]" />"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">
						<s:property value="pnames[0]" />
						&nbsp$<s:property value="prices[0]" />
					</h5>
					<p class="card-text">
						<s:property value="details[0]" />
					</p>
					<p class="card-text">
						<s:property value="category[0]" />
						</small>
					</p>
				</div>
			</div>

			<div class="card">
				<img class="card-img-top" src="<s:property value="pictures[1]" />"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">
						<s:property value="pnames[1]" />
						&nbsp$<s:property value="prices[1]" />
					</h5>
					<p class="card-text">
						<s:property value="details[1]" />
					</p>
					<p class="card-text">
						<s:property value="category[1]" />
						</small>
					</p>
				</div>
			</div>

			<div class="card">
				<img class="card-img-top" src="<s:property value="pictures[2]" />"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">
						<s:property value="pnames[2]" />
						&nbsp$<s:property value="prices[2]" />
					</h5>
					<p class="card-text">
						<s:property value="details[2]" />
					</p>
					<p class="card-text">
						<s:property value="category[2]" />
						</small>
					</p>
				</div>
			</div>

			<div class="card">
				<img class="card-img-top" src="<s:property value="pictures[3]" />"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">
						<s:property value="pnames[3]" />
						&nbsp$<s:property value="prices[3]" />
					</h5>
					<p class="card-text">
						<s:property value="details[3]" />
					</p>
					<p class="card-text">
						<s:property value="category[3]" />
						</small>
					</p>
				</div>
			</div>

		</div>
		<br>
	</div>
	</main>
</body>
</html>