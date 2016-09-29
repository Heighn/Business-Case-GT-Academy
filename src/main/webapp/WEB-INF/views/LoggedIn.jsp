<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welkom, ${firstName}!</title>
</head>
<body>
	<h1>Welkom, ${firstName}!</h1>

	<h2>Accountgegevens Wijzigen</h2>
	<form action="/wijzig" method="get">
		<input type="submit" />
	</form>
	
	<h2>Account Verwijderen</h2>
	<form action="/inactief" method="get">
		<input type="submit" />
	</form>
	
	
</body>
</html>