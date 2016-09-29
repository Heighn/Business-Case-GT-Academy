<%@ include file="header.jsp" %>
  <div id="main">
    <div class="content">
      <form:form method ="post">
        <h3>Inloggen recruiter</h3>
        <p>Gebruikersnaam</p>
        <input type="text" name="recruiterName">
        <p>Wachtwoord</p>
        <input type="password" name="recruiterPass">
        <input type="submit" value="Verzenden">
		<p><a href="/recruitersReg">Nog geen account?</a></p>
      </form:form>
    </div>
  </div>
  <%@ include file="footer.jsp" %>
