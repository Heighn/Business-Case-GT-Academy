<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="header.jsp" %>
  <div id="main">
    <div class="content">     
      <h3>Stuur een email naar alle studenten</h3>
      
      <form:form method="POST" name="email">
      	<p>Emailaddressen</p>
      	<textarea cols="150" rows="1" name="emailAddresses"></textarea><br>
      	<p>Onderwerp</p>
      	<textarea cols="150" rows="1" name="subject"></textarea><br>
      	<p>Bericht</p>
      	<textarea cols="150" rows="30" name="messageText"></textarea>
      	<input type="submit">
      </form:form>
      
    </div>
  </div>
  <%@ include file="footer.jsp" %>
