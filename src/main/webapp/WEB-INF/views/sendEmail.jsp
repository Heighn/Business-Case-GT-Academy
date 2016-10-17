<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="header.jsp" %>
  <div id="main">
    <div class="content">
      <h3>Nieuw bericht</h3>
      <form:form method="POST" name="email">
      	<p>Geadresseerden</p>
      	<input type="text" name="emailAddresses" id="test"></textarea><br>
      	<p>Onderwerp</p>
      	<input type="text" name="subject"></textarea><br>
      	<p>Bericht</p>
      	<textarea cols="10" rows="10" name="messageText"></textarea>
      	<input type="submit">
      </form:form>
    </div>
  </div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    $(document).ready(function(){
        $('#test').val(sessionStorage.selectedEmails);
    });
</script>
  <%@ include file="footer.jsp" %>
