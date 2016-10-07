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
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
    $( function() {
      $( "#accordion" ).accordion({
        collapsible: true
      });
    } );
    </script>
</head>
<body>
  <header id="header">
      <div class="branding">
        <a href="inloggen"><img src="../images/logo.png" alt="logo"></a>
      </div>
      <nav id="menu">
        <ul>
          <li><a href="inloggen">Inloggen</a></li>
          <li><a href="#" class="current">Registreren</a></li>
        </ul>
      </nav>
  </header>
  <div id="main">
    <div class="content">
      <form:form method="post" commandName="currentStudent">
        <h3>Persoonsgegevens</h3>
        <p>Voornaam</p>
        <form:input path="firstName" value="${firstName}"/>
        <p>Achternaam</p>
        <form:input path="lastName" value="${lastName}"/>
        <h3>Contactgegevens</h3>
        <p>Emailadres (dit is ook je gebruikersnaam)</p>
        <form:input type="email" path="emailAddress" value="${emailAddress}"/>
        <p>Telefoonnummer</p>
        <form:input type="tel" path="phoneNumber" value="${phoneNumber}"/>
        <h3>Accountgegevens</h3>
        <p>Wachtwoord</p>
        <form:input type="password" path="password" value="${password}"/>
        <p>Bevestig wachtwoord</p>
        <form:input type="password" path="passwordConfirmation" value="${password}"/>
        <form:checkbox path="agreedPrivacy" id="priv" />
        <label for="priv">Ik ga akkoord met de algemene voorwaarden.</label>
        <input type="submit">
      </form:form>
    </div>
  </div>
  <footer id="footer">
  </footer>
</body>
</html>
