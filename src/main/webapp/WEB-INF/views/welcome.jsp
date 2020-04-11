<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/CSS/style.css">

</head>
<body>
	<div class="grey card">
		<h1 class="header2">
			<Strong>Success</Strong>
		</h1>
		<div style="margin: 0 auto; width: 100%; text-align: center;">
			<c:choose>
				<c:when test="${sessionScope.accountType=='Company' }">
					<a href="${pageContext.request.contextPath}/index">Home</a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/index">Home</a>
				</c:otherwise>
			</c:choose>
		</div>
		<br>
	</div>
</body>
</html>