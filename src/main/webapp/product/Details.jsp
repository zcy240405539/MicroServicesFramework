<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:property value="pname" />: Product Detail</title>	<link href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>

	<jsp:include page="/layouts/header.jsp" flush="true" />

	<main role="main">
		<br><br>
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<img class="card-img-top" src="<s:property value="picture" />"
						alt="Card image cap">
				</div>
				<div class="col-sm-8">
					<h2><s:property value="pname" /></h2>
					<h5>$<s:property value="price" /></h5>
					<br>
									
					<form action="addItem" method="post">
					<div class="form-group">
						<input type="text" id="prodIDBox" name="prodID" value="<s:property value='pid' />" style="display:none;"> 
						<input type="text" id="prodNameBox" name="prodName" value="<s:property value='pname' />" style="display:none;"> 
						<input type="text" id="prodPictureBox" name="prodPicture" value="<s:property value='picture' />" style="display:none;"> 
						<label for="prodCountBox">Quantity</label> 
						<input type="number" class="form-control" id="prodCountBox" name="prodCount" style="width:100px;">
						<input type=text id="prodPriceBox" name="prodPrice" value="<s:property value='price' />" style="display:none;"> 
					</div>
					<button type="submit" class="btn btn-warning" >Add to Cart</button>
				</form>
				
				
				</div>
				<br>
			</div>

			<br><hr><hr><br>
			
			<div class="row">
				<h5>
					<b>Details</b><br>
					<p><s:property value="detail" /></p>
				</h5>
			</div>
		</div>
	</main>

</body>
</html>