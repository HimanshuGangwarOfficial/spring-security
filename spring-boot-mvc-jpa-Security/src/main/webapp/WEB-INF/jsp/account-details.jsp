<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="security"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>Account Details</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h2>Account Details</h2>
	
	<p> Account No: ${account.accountNo}</p>
	<p> Account Holder Name: ${account.accountHolderName}</p>
	<p> Account type: ${account.accountType}</p>
	<p> IFSC Code: ${account.ifscCode}</p>
	<p> Balance: ${account.balance}</p>
	
	<%-- <security:authorize access="hasAnyRole('clerk', 'manager')">
		<p> Status: ${account.status}</p>
	</security:authorize>--%>
</body>
</html>