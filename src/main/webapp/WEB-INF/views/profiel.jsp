<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="header.jsp" %>
<div id="main">
	<div class="content">
		<h1>Profiel</h1>
		<p>Welkom, gebruiker</p><br>
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
				<%--<form:form method="post" commandName="currentStudent">--%>
					<%--<form:checkbox path="agreedPrivacy" id="tech" />--%>
					<%--<label for="tech">Tech events (gratis te bezoeken)</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="stud" />--%>
					<%--<label for="study">Afstudeer onderzoeken</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="stage" />--%>
					<%--<label for="stage">Stages</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="train" />--%>
					<%--<label for="trainee">Traineeships</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="anders" />--%>
					<%--<label for="other">Anders, namelijk:</label>--%>
					<%--<input type="submit" value="Opslaan">--%>
				<%--</form:form>--%>
			<%--</div>--%>
			<%--<h3>Thema's</h3>--%>
			<%--<div>--%>
				<%--<form:form method="post" commandName="currentStudent">--%>
					<%--<form:checkbox path="agreedPrivacy" id="tech" />--%>
					<%--<label for="tech">Tech events (gratis te bezoeken)</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="stud" />--%>
					<%--<label for="stud">Afstudeer onderzoeken</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="stage" />--%>
					<%--<label for="stage">Stages</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="train" />--%>
					<%--<label for="train">Traineeships</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="anders" />--%>
					<%--<label for="anders">Anders, namelijk:</label>--%>
					<%--<input type="submit" value="Opslaan">--%>
				<%--</form:form>--%>
			<%--</div>--%>
		  <%--<h3>Interesses</h3>--%>
		  <%--<div>--%>
				<%--<form:form method="post" commandName="persoonsGegevensBean">--%>
					<%--<form:checkbox path="agreedPrivacy" id="tech" />--%>
					<%--<label for="tech">Tech events (gratis te bezoeken)</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="stud" />--%>
					<%--<label for="stud">Afstudeer onderzoeken</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="stage" />--%>
					<%--<label for="stage">Stages</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="train" />--%>
					<%--<label for="train">Traineeships</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="anders" />--%>
					<%--<label for="anders">Anders, namelijk:</label>--%>
					<%--<input type="submit" value="Opslaan">--%>
				<%--</form:form>--%>
		  <%--</div>--%>
		  <%--<h3>Thema's</h3>--%>
		  <%--<div>--%>
				<%--<form:form method="post" commandName="persoonsGegevensBean">--%>
					<%--<form:checkbox path="agreedPrivacy" id="tech" />--%>
					<%--<label for="tech">Tech events (gratis te bezoeken)</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="stud" />--%>
					<%--<label for="stud">Afstudeer onderzoeken</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="stage" />--%>
					<%--<label for="stage">Stages</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="train" />--%>
					<%--<label for="train">Traineeships</label><br>--%>
					<%--<form:checkbox path="agreedPrivacy" id="anders" />--%>
					<%--<label for="anders">Anders, namelijk:</label>--%>
					<%--<input type="submit" value="Opslaan">--%>
				<%--</form:form>--%>
		  <%--</div>--%>
		</div>
		<p><a href="/inactief">Account Verwijderen</a></p>
 	</div>
</div>
<%@ include file="footer.jsp" %>
