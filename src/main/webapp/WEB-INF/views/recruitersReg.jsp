<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
  <title>Get There studentenportaal</title>
  <link rel="stylesheet" href="../styles.css">
</head>
<body>
  <header id="header">
  </header>
  <div id="main">
    <div class="content">
      <ul>
      	<c:forEach items="${recruiters}" var="recruiter">
      	<li>
      		Recruiter ${recruiter.id}
      	</li>
      	</c:forEach>
      </ul>
      <form:form method ="post">
        <h3>Recruiter registreren</h3>
        <p>Gebruikersnaam</p>
        <input type="text" name="recruiterName">
        <p>Wachtwoord</p>
        <input type="password" name="recruiterPass">
        <p>Bevestig wachtwoord</p>
        <input type="password" name="confirm">
        <input type="submit" value="Verzenden">
      </form:form>
    </div>
  </div>
  <footer id="footer">
  </footer>
</body>
</html>
