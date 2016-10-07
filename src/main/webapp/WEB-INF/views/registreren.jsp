<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="header.jsp" %>

  <div id="main">
    <div class="content">

      <form:form method="post" commandName="currentStudent">
        <h3>Persoonsgegevens</h3>
        <p>Voornaam</p>
        <form:input path="firstName" value="${firstName}"/>
        <p>Achternaam</p>
        <form:input path="lastName" value="${lastName}"/>
        <h3>Contactgegevens</h3>
        <p>Emailadres (dit is ook je gebruikersnaam)</p>
        <form:input type="email" path="emailAddress" value="${emailAddress}"/>
        <p>Telefoonnummer</p>
        <form:input type="tel" path="phoneNumber" value="${phoneNumber}"/>
        <h3>Accountgegevens</h3>
        <p>Wachtwoord</p>
        <form:input type="password" path="password" value="${password}"/>
        <p>Bevestig wachtwoord</p>
        <form:input type="password" path="passwordConfirmation" value="${password}"/>
        <form:checkbox path="agreedPrivacy" id="priv" />
        <label for="priv">Ik ga akkoord met de algemene voorwaarden.</label>
        <input type="submit">
       </form:form>
    </div>
  </div>
  <footer id="footer">
  </footer>
</body>
</html>
