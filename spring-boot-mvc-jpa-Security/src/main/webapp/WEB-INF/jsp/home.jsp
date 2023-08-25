<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home Page</h1>
	<jsp:include page="header.jsp"/>
	<p style="font-size: 12px">
		Welcome to HDFC Bank Netbanking. 
		You can search for the Account by
		click <a href="${pageContext.request.contextPath}/account/find.htm">here</a>
	</p>
</body>
</html>