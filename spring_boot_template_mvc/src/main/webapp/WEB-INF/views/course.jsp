<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Management</title>
</head>
<body>
	<h1>Course Management</h1>
	<form method="post" action="/save">
		<input type="hidden" name="id" value="${course.id}"> <label
			for="name">Name:</label> <input type="text" name="name"
			value="${course.name}" required><br> <label for="type">Type:</label>
		<select name="type" required>
			<option value="BBA" ${course.type == 'BBA' ? 'selected' : ''}>BBA</option>
			<option value="BCA" ${course.type == 'BCA' ? 'selected' : ''}>BCA</option>
			<option value="MBA" ${course.type == 'MBA' ? 'selected' : ''}>MBA</option>
		</select><br> <label for="duration">Duration:</label> <select
			name="duration" required>
			<option value="1" ${course.duration == 1 ? 'selected' : ''}>1
				year</option>
			<option value="2" ${course.duration == 2 ? 'selected' : ''}>2
				years</option>
			<option value="3" ${course.duration == 3 ? 'selected' : ''}>3
				years</option>
			<option value="4" ${course.duration == 4 ? 'selected' : ''}>4
				years</option>
		</select><br> <label for="fee">Fee:</label> <input type="number"
			name="fee" value="${course.fee}" min="100000" max="400000" required><br>
		<input type="submit"
			value="${course.id == null ? 'Add' : 'Update'} Course">
	</form>
</body>
</html>
