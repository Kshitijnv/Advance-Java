<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Management</title>
</head>
<body>
    <h1>Course Management</h1>
    <a href="/add">Add Course</a>
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Duration</th>
            <th>Fee</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses}" var="course">
        
            <tr>
                <td>${course.name}</td>
                <td>${course.type}</td>
                <td>${course.duration}</td>
                <td>${course.fee}</td>
                <td>
                    <a href="/edit/${course.id}">Edit</a>
                    <a href="/delete/${course.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>