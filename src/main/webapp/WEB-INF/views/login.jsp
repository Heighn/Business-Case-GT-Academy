<%@ include file="header.jsp" %>
	<div id="main">
		<div class="content">
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
	</div>
	</div>
<%@ include file="footer.jsp" %>