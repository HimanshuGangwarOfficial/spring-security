<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h2>Login Page</h2>
	<p style="color:red;">
		<c:if test="${param.error eq '' }">
			Bad Credentials
		</c:if>
	</p>
	<form method="post" action="${pageContext.request.contextPath}/login.htm">
		Email: <input type="email" name="j_username"><br/>
		Password: <input type="password" name="j_password">
		<input type="submit" name="Login">
	</form>
	
</body>
</html>