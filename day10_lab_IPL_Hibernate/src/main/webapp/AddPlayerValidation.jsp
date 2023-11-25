<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add player validation</title>
</head>
<!-- To set the parameters of Client to bean  -->
<jsp:setProperty property="*" name="play" />
<h4>${sessionScope.play.addPlayer()}</h4>
<body>

</body>
</html>