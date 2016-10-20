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
      <h3 class="error">${errorMessage}</h3>
      <form:form action="recruitersReg" method="post" commandName="recruiterForm">
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
