<%@ include file="header.jsp" %> 
  <div id="main">
    <div class="content">
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
  <%@ include file="header.jsp" %>