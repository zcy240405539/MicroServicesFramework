<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="refresh" content="1; url=/shoppingCart">
<title>Added to Cart</title>
</head>
<body>
<jsp:include page="/layouts/header.jsp" flush="true" />

	<main role="main">
		<br><br>
		<div class="container">
		<h2>Added <s:property value="prodName" /> quantity of <s:property value="prodCount" /></h2>
		<h4>Unit Price: $<s:property value="prodPrice" /></h4>
		<h4>Total Price: $<s:property value="totalPrice" /></h4>
		<br>
		</div>
	</main>
</body>
</html>