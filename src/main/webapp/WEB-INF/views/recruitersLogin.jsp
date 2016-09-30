<%@ include file="header.jsp" %>
  <div id="main">
    <div class="content">
      <form:form method ="post" modelAttribute="recruiter">
        <h3>Inloggen recruiter</h3>
        <p>Gebruikersnaam</p>
        <form:input path="recruiterName"/>
        <p>Wachtwoord</p>
        <form:password path="recruiterPass"/>
        <input type="submit" value="Inloggen"/>
		<p><a href="/recruitersReg">Nog geen account?</a></p>
      </form:form>
    </div>
  </div>
  <%@ include file="footer.jsp" %>
