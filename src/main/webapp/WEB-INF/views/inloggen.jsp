<%@ include file="header.jsp" %>
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
					<input type="submit" value="Verzenden" />
				</form:form>
				<p><a href="registreren">Registreren</a> | <a href="wachtwoordVergeten">Wachtwoord vergeten</a></p>
			</div>
		</div>
	</div>
<%@ include file="footer.jsp" %>
