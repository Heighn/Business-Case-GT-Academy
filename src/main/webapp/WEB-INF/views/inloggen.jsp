<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="charset" content="utf-8">
  <title>Get There Studentenportaal</title>
  <link rel="stylesheet" href="../styles.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$( function() {
		  function runEffect() {
				if (${shaker}) {
		    	$( "#effect" ).effect("shake", 500);
				}
		  };
		  runEffect();
		} );
	</script>
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
				<p><a href="../registreren">Registreren</a> | <a href="../wachtwoordVergeten">Wachtwoord vergeten</a></p>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp" %>
