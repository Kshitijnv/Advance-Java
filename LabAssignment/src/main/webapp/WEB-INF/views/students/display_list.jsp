<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Student List</h2>

<table border="1">
    <tr>
        <th>Roll Number</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Course</th>
        <th>City</th>
    </tr>

    <c:forEach var="student" items="${requestScope.listOfStu}">
        <tr>
            <td>${student.rollNo}</td>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.courseName}</td>
            <td>${student.city}</td>
        </tr>
    </c:forEach>
</table>

	<spring:url var="url" value="/"></spring:url>
	<a href="${url}">go to home page</a>
</body>
</html>