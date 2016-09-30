<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
sidenav {
    height: 100%;
    width: 2;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    background-color: #111;
    overflow-x: hidden;
    padding-top: 60px;
    transition: 0.5s;
}

sidenav, a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s;
}

h1{
	position: relative;
	top: 0;
	left: 400px;
}
</style>

<title>Welkom, ${firstName}!</title>
</head>

<div id="mySidenav" class="sidenav">
  <a href="#">Accountgegevens Wijzigen</a>
  <a href="#">Account Verwijderen</a>
</div>


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