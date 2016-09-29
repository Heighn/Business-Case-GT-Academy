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
      <form>
        <h3>Persoonsgegevens</h3>
        <p>Voornaam</p>
        <input type="text" name="voornaam">
        <p>Achternaam</p>
        <input type="text" name="achternaam">
        <h3>Accountgegevens</h3>
        <p>Wachtwoord</p>
        <input type="password" name="wachtwoord">
        <p>Bevestig wachtwoord</p>
        <input type="password" name="bevestiging">
        <h3>Contactgegevens</h3>
        <p>Emailadres</p>
        <input type="email" name="email">
        <p>Telefoon</p>
        <input type="tel" name="telefoon">
        <label for="privacy">
        <input type="checkbox" name="privacy" id="privacy" value="Ik accepteer de privacy voorwaarden">
        <input type="submit" value="Verzenden">
      </form>
    </div>
  </div>
  <footer id="footer">
  </footer>
</body>
</html>
