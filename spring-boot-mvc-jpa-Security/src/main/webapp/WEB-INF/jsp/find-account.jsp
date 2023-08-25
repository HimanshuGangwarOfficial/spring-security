<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Account</title>
</head>
<body>

	<h2>Find Account</h2>
	<jsp:include page="header.jsp"/>
	<form method="post" action="${pageContext.request.contextPath}/account/find.htm" >
		Account No: <input type="text" name="accountNo" /> <br/>
		<input type="submit" value="show">
	</form>
</body>
</html>