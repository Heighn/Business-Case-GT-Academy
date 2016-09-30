<%@ include file="header.jsp" %> 
  <div id="main">
    <div class="content">
      <form:form method ="post" modelAttribute="recruiter">
        <h3>Recruiter registreren</h3>
        <p>Gebruikersnaam<form:label path="recruiterName">
        	<form:errors path="recruiterName" cssClass="error"></form:errors>
        </form:label></p>
        <form:input path="recruiterName"/>
        <p>Wachtwoord</p>
        <form:password path="recruiterPass"/>
        <p>Bevestig wachtwoord</p>
        <form:password path="confirm"/>
        <input type="submit" value="Verzenden">
      </form:form>
    </div>
  </div>
  <%@ include file="footer.jsp" %>