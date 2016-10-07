<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="charset" content="utf-8">
  <title>Get There Studentenportaal</title>
  <link rel="stylesheet" href="../styles.css">
</head>
<body class="bg">
	<div id="main">
		<div class="login-container">
			<div class="login-form">
				<img src="../images/logo.png" alt="logo" class="logo">
				<h3>Inloggen</h3>
				<form:form method="post" name="signInSheet" commandName="currentStudent">
					<p>Emailadres</p>
					<input type="text" name="username" />
					<p>Wachtwoord</p>
					<input type="password" name="password" />
					<input type="submit" />
				</form:form>
				<p>Nog geen account?<br>
					<a href="registreren">Registreer je hier.</a>
				</p>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp" %>
