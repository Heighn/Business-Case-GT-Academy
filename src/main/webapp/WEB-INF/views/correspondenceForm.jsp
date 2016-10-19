/**
 * Created by hein.dehaan on 17-10-2016.
 */

<%@ include file="header.jsp" %>
<div id="main">
 <div class="content">
  <h1>Correspondentie Aanmaken</h1>
  <form:form commandName="correspondenceForm">
   <p>Datum</p>
   <form:input path="dateString" id="datepicker"/>
   <p>Type</p>
   <form:input type="text" path="type"/>
   <p>Ontvangers</p>
   <form:input type="text" path="receivers"/>
   <p>Onderwerp</p>
   <form:input type="text" path="subject"/>
   <p>Bericht</p>
   <form:input type="text" path="message"/>
   <input type="submit">
  </form:form>
 </div>
</div>

<%@ include file="footer.jsp" %>