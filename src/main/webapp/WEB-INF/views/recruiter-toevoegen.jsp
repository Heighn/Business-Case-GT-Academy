<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="charset" content="utf-8">
  <title>Get There Studentenportaal</title>
  <link rel="stylesheet" href="../styles.css">
  <script src="http://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body ng-app="portal">
  <header id="header">
      <div class="branding">
        <a href="dashboard"><img src="../images/logo.png" alt="logo"></a>
      </div>
      <div class="avatar">
        <p>U bent ingelogd als '${recruiterName}'<p>
        <a href="../logout">Uitloggen</a>
      </div>
      <div class="clear"></div>
      <nav id="menu">
        <ul class="fluid">
          <li><a href="dashboard">Dashboard</a></li>
          <li><a href="evenementen">Evenementen</a></li>
          <li><a href="themas">Themas</a></li>
          <li><a href="beheer">Beheer</a></li>
        </ul>
      </nav>
  </header>
  <div id="main">
    <div class="content-fluid">
      <h3>Recruiter toevoegen</h3>
      <p>Gebruik het formulier hieronder om een nieuwe recruiter toe te voegen.<br><a href="beheer">Ga terug naar beheer.</a></p><br>
      <div class="error">${errorMessage}</div>
      <form:form method="post" commandName="recruiterForm">
        <p>Gebruikersnaam</p>
        <form:input path="recruiterName"/>
        <p>Wachtwoord</p>
        <form:input type="password" path="recruiterPass"/>
        <p>Bevestig Wachtwoord</p>
        <form:input type="password" path="confirm"/>
        <input type="submit">
      </form:form>
    </div>
  </div>
  <footer id="footer">
  </footer>
</body>
</html>
