<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="content-type" content="text/javascript; charset=utf-8">
  <title>Get There Studentenportaal</title>
  <base href="/">
  <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
  <header id="header">
  </header>
	<div id="main" div class="bg">
		<div class="login-container">
			<div class="login-form">
				<img src="../images/logo.png" alt="logo" class="logo">
				<h3>Inloggen</h3>
				<form:form method="post" name="signInSheet" commandName="currentStudent">
					<p>Emailadres</p>
					<input type="text" name="username" />
					<p>Wachtwoord</p>
					<input type="password" name="password" />
					<input type="submit" value="Verzenden" />
				</form:form>
				<p><a href="registreren">Registreren</a> | <a href="wachtwoordVergeten">Wachtwoord vergeten</a></p>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp" %>
