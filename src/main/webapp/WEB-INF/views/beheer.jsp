<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
          <li><a href="studenten">Studenten</a></li>
          <li><a href="evenementen">Evenementen</a></li>
          <li><a href="themas">Themas</a></li>
          <li><a href="#" class="current">Beheer</a></li>
        </ul>
      </nav>
  </header>
<div id="main" ng-controller="PortalController as vm">
    <div class="content-fluid">
    	<h1>Beheer</h1><br>
      <h2>Recruiters</h2>
      <p>De personen in de tabel hieronder kunnen op de applicatie inloggen met recruiter rechten.</p><br>
      <div class="menubar">
        <div class="item">
          <button class="success" onclick="window.location.href='recruiter-toevoegen'">Recruiter toevoegen</button>
          <button class="delete">Recruiter verwijderen</button>
        </div>
        <div class="clear"></div>
      </div>
      <table>
        <thead>
          <th><input type="checkbox"></th>
          <th>Omschrijving</th>
        </thead>
        <tbody>
        <c:forEach items="${recruiters}" var="recruiter">
        <tr>
          <td class="check"><input type="checkbox"></td>
          <td>${recruiter.recruiterName}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table><br><br>
    <h2>Voorkeuren</h2>
    <input type="checkbox" id="newStudent" checked><label for="newStudent">Stuur een bericht wanneer een nieuwe student zich inschrijft.</label><br>
    <input type="checkbox" id="study"><label for="study">Stuur een bericht wanneer een student afstudeerd.</label>
  </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="../portal.module.js"></script>
<script src="../portal.controller.js"></script>
<%@ include file="footer.jsp" %>
