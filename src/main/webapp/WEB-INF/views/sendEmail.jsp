<%@ include file="header.jsp" %>
  <div id="main">
    <div class="content">
      <h1>Stuur een email naar alle studenten</h1>
      <form method=POST name=email>
        <p>Emailadres</p>
      	<input type="text" name="emailAddress">
        <p>Bericht</p>
      	<textarea cols="90" rows="15" name="messageText"></textarea>
      	<input type="submit">
      </form>

    </div>
  </div>
  <%@ include file="footer.jsp" %>
