<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css">

</head>
<body>
<div class="grey">
	<h1 class="header2">
		<Strong>Welcome</Strong>
	</h1>
	<%-- <p>user id: ${sessionScope.userId }</p> --%>
	<div style="margin:0 auto; width:100%;text-align: center;"><a href="${pageContext.request.contextPath}/index">Home</a></div>
    <br>
</div>
</body>
</html>