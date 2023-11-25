<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Team</title>
</head>
<jsp:useBean id="play" class="beans.Player" scope="session"/>

<body>
	<table>
		<form action="AddPlayerValidation.jsp">
			<tr>
				<td><label>Select a team abbreviation</label></td>
				<td><!-- <input type="text" name="abbreviation" /> -->
				<select name="teamabbreviation">
				<option>CSK</option>
				<option>GT</option>
				<option>KKR</option> 
				</select>
				</td>

			</tr>
			<tr>
				<td><label for="fname">First Name</label></td>
				<td><input type="text" id="fname" name="fname" /></td>
			</tr>
			<tr>
				<td><label for="lname">Last Name</label></td>
				<td><input type="text" id="lname" name="lname" /></td>
			</tr>

			<tr>
				<td><label for="dob">DOB</label></td>
				<td><input type="date" id="dob" name="dob" /></td>
			</tr>

			<tr>
				<td><label for="batAvg">Batting Average</label></td>
				<td><input type="number" id="batAvg" name="batAvg" /></td>
			</tr>

			<tr>
				<td><label for="wicket">Wickets Taken</label></td>
				<td><input type="number" id="wicket" name="wicket" /></td>
			</tr>

			<tr>
				<td>
					<button type="submit">Add a player</button>
				</td>
			</tr>
		</form>
	</table>
</body>
</html>