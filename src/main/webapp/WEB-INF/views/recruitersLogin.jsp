<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welkom!</title>
</head>
  <div id="main">
    <div class="content">
      <form:form method ="post" modelAttribute="recruiter">
        <h1>Inloggen Recruiter</h1>
        <p>Gebruikersnaam</p>
        <form:input path="recruiterName"/>
        <p>Wachtwoord</p>
        <form:password path="recruiterPass"/>
        <input type="submit" value="Inloggen"/>
		<p><a href="/recruitersReg">Nog geen account?</a></p>
      </form:form>
    </div>
  </div>
</html>

