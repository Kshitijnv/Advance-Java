<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<%--Invoke all Matching parameters --%>
<jsp:setProperty property="*" name="user" />
<%--Invoke B.L method for voter register --%>
<h4>Route : ${sessionScope.user.registerNewVoter()}</h4>

<body>
<a href = "login.jsp"> Login </a>
</body>
<%session.invalidate(); %>
</html>