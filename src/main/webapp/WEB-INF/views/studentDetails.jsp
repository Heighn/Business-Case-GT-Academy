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
          <li><a href="#" class="current">Beheer</a></li>
        </ul>
      </nav>
  </header>
<div id="main" ng-app="profiel" ng-controller="ProfielController as vm">
	<div class="content">
		<h1>Welkom ${firstName}</h1>
		<p>Dit is je persoonlijke profiel. Hieronder kun je alle gegevens die bij ons bekend zijn wijzigen. Daarnaast kun je je cv uploaden en je aanmelden voor evenementen.</p><br>
		<p>${message}</p>
		<div id="accordion">
		  <h3>Algemeen</h3>
		  <div>
				<form:form action="persoonsGegevensUpdate" method="post" commandName="persoonsGegevensBean">
			 		<p>Voornaam</p>
					<form:input path="firstName" value="${firstName}"/>
					<p>Achternaam</p>
					<form:input path="lastName" value="${lastName}"/>
					<p>Geboortedatum</p>
					<form:input path="gebDatum" value="${gebDatum}" id="datepicker"/>
					<p>Woonplaats</p>
					<form:input path="woonplaats" value="${woonplaats}"/>
					<input type="submit" value="Opslaan">
				</form:form>
		  </div>
		  <h3>Contactgegevens</h3>
		  <div>
				<form:form method="post" action="contactGegevensUpdate" commandName="contactGegevensBean">
					<p>Emailadres</p>
					<form:input type="email" path="emailAddress" value="${emailAddress}"/>
					<p>Telefoonnummer</p>
					<form:input type="tel" path="phoneNumber" value="${phoneNumber}"/>
					<p>LinkedIn</p>
					<form:input path="linkedIn" value="${linkedIn}"/>
					<input type="submit" value="Opslaan">
				</form:form>
		  </div>
		  <%--<h3>Interesses</h3>--%>
		  <%--<div>--%>
		  	<%--<form:form method="post" commandName="contactGegevensBean">--%>
				<%--<p>Tech events (gratis te bezoeken)</p><form:checkbox path="techEvents"/>--%>
				<%--<p>Afstudeeronderzoeken</p><form:checkbox path="afstudeerOnderzoek"/>--%>
				<%--<p>Stages</p><form:checkbox path="stage"/>--%>
				<%--<p>Traineeships</p><form:checkbox path="traineeship"/>--%>
				<%--<p>Anders, namelijk:</p>--%>
				<%--<form:input type="text" path="anders"/>--%>
			<%--</form:form>--%>
		  <%--</div>--%>

			<h3>Thema's</h3>
			<div>
				<form:form method="post" action="themasUpdate" commandName="themeBean">
					<p ng-repeat="item in vm.data"> <form:checkbox path="themes" value="{{item.description}}"/> {{ item.description }}</p>
					<input type="submit" value="Opslaan">
					<%--<p>Domotica/Robotica</p><form:checkbox path="domoticaRobotica"/>--%>
					<%--<p>Big Data</p><form:checkbox path="domoticaRobotica"/>--%>
					<%--<p>Software Development</p><form:checkbox path="domoticaRobotica"/>--%>
					<%--<p>Software Architectuur</p><form:checkbox path="domoticaRobotica"/>--%>
					<%--<p>Security</p><form:checkbox path="domoticaRobotica"/>--%>
					<%--<p>Internet of Things</p><form:checkbox path="domoticaRobotica"/>--%>
					<%--<p>Virtual Reality</p><form:checkbox path="domoticaRobotica"/>--%>
					<%--<p>Gamification</p><form:checkbox path="domoticaRobotica"/>--%>
					<%--<p>Business Consultancy</p><form:checkbox path="domoticaRobotica"/>--%>
					<%--<p>Test Engineering</p><form:checkbox path="domoticaRobotica"/>--%>
				</form:form>
			</div>
			<h3>Overig</h3>
			<div>
				<p><a href="verwijderen">Account verwijderen</a></p>
			</div>
 		</div>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="../profiel.module.js"></script>
<script src="../profiel.controller.js"></script>
<%@ include file="footer.jsp" %>
