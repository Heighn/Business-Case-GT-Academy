<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="charset" content="utf-8">
  <title>Get There Studentenportaal</title>
  <link rel="stylesheet" href="../styles.css">
</head>
<body>
  <header id="header">
  </header>
  <div id="main" class="bg">
    <div class="login-container">
			<div class="reg-form">
				<img src="images/logo.png" alt="logo" class="logo">
				<h3>Registreer een account</h3>
        <form:form method="post" commandName="currentStudent">
        <div class="float-left">
          <p>Voornaam</p>
          <form:input path="firstName" value="${firstName}"/>
        </div>
        <div class="float-left">
          <p>Achternaam</p>
          <form:input path="lastName" value="${lastName}"/>
        </div>
        <div class="clear"></div><br>
        <div class="float-left">
          <p>Wachtwoord</p>
          <form:input type="password" path="password" value="${password}"/>
        </div>
        <div class="float-left">
          <p>Bevestig wachtwoord</p>
          <form:input type="password" path="passwordConfirmation" value="${password}"/>
        </div>
        <div class="clear"></div>
          <h3>Contactgegevens</h3>
          <div class="clear"></div>
        <div class="float-left">
          <p>Emailadres (dit is ook je gebruikersnaam)</p>
          <form:input type="email" path="emailAddress" value="${emailAddress}"/>
        </div>
        <div class="float-left">
          <p>Telefoonnummer</p>
          <form:input type="tel" path="phoneNumber" value="${phoneNumber}"/>
        </div>
        <div class="clear"></div>
          <form:checkbox path="agreedPrivacy" id="priv" />
          <label for="priv">Ik ga akkoord met de <a>algemene voorwaarden</a>.</label>
          <input type="submit">
         </form:form>
        
				<p><a href="inloggen">Terug naar inloggen</a></p>
			</div>
		</div>
  </div>
  <footer id="footer">
  </footer>
</body>
</html>
