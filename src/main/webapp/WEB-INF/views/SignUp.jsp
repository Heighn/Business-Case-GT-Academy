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
</head>
<body>
  <header id="header">
  </header>
  <div id="main">
    <div class="content">
      <form:form action="/signUp" method="post" commandName="studentForm">
        <h2>Persoonsgegevens</h2>
        <p>Voornaam</p>
        <form:input path="firstName" value="${firstName}"/>
        <p>Achternaam</p>
        <form:input path="lastName" value="${lastName}"/>
        <h2>Accountgegevens</h2>
        <p>Wachtwoord</p>
        <form:input type="password" path="password" value="${password}"/>
        <p>Bevestig wachtwoord</p>
        <form:input type="password" path="passwordConfirmation" value="${password}"/>
        <h2>Contactgegevens</h2>
        <p>Emailadres</p>
        <form:input type="email" path="emailAddress" value="${emailAddress}"/>
        <p>Telefoonnummer</p>
        <form:input type="tel" path="phoneNumber" value="${phoneNumber}"/>
        <p>Get There doet niks vervelends met je gegevens</p>
        <form:checkbox path="agreedPrivacy"/>
        <input type="submit">
        
      </form:form>
    </div>
  </div>
  <footer id="footer">
  </footer>
</body>
</html>
