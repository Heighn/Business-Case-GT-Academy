<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welkom!</title>
</head>
<body>
	<form method="post" name="signInSheet">
		<p>Emailadres</p>
		<input type="text" name="email" />
		<p>Wachtwoord</p>
		<input type="password" name="password" /><br> <input
			type="submit" />
	</form>
	<p>Heb je nog geen account?
	</p>
	<form action="signUp">
		<input type="submit" name="newAccount" value="Studentaccount aanmaken" />
		<input type="submit" name="newAccount" value="Recruiteraccount aanmaken" />
	</form>
</body>
</html>