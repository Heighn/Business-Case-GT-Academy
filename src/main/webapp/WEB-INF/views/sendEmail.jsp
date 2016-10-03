<%@ include file="header.jsp" %>
  <div id="main">
    <div class="content">     
      <h3>Stuur een email naar alle studenten</h3>
      
      <form method=POST name=email>
      	<input type="text" name="emailAddress">
      	<textarea cols="150" rows="30" name="messageText"></textarea>
      	<input type="submit">
      </form>
      
    </div>
  </div>
  <%@ include file="footer.jsp" %>
