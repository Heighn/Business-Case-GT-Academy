<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="header.jsp" %>
<div id="main">
	<div class="content">
		<h1>Profiel</h1>
		<p>${message}</p>
		<form:form method="post" commandName="studentForm">
 		<h3>Persoonsgegevens</h3>
 		<p>Voornaam</p>
		<form:input path="firstName" value="${firstName}"/>
		<p>Achternaam</p>
		<form:input path="lastName" value="${lastName}"/>
		<p>Geboortedatum</p>
		<form:input path="gebDatum" value="${gebDatum}"/>
		<p>Woonplaats</p>
		<form:input path="woonplaats" value="${woonplaats}"/>

		<h3>Contactgegevens</h3>
		<p>Emailadres</p>
		<form:input type="email" path="emailAddress" value="${emailAddress}"/>
		<p>Telefoonnummer</p>
		<form:input type="tel" path="phoneNumber" value="${phoneNumber}"/>
		<p>LinkedIn</p>
		<form:input path="linkedIn" value="${linkedIn}"/>
		</form:form>



 		<a href="/wijzig">Accountgegevens Wijzigen</a> <a href="/inactief">Account Verwijderen</a>
 	</div>
</div>
<%@ include file="footer.jsp" %>
