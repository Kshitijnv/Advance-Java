<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
*{
font-size:25px;}
</style>
</head>
<body>
	<!-- localHost:8080/employees/addEmployee -->
	<center><h4>Add Employee Form</h4></center>
	<form action="show" method="post" style="background-color: white; margin:10px; ">
		<table style="background-color: lightgrey; margin: auto; border-radius: 5px; padding: 10px; border: 2px solid black;">
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="fn" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="ln" /></td>
			</tr>
			<tr>
				<td>Enter city</td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td>Select Company</td>
				<td><select name="myCompany">
						<option>CDAC</option>
						<option>HCL</option>
						<option>TCS</option>
				</select></td>
			</tr>
			<tr>
			<td></td>
				<td><input type="submit" value="Add A Employee" /></td>
			</tr>
		</table>
	</form>
</body>


</html>