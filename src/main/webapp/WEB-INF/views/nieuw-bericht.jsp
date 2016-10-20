<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="charset" content="utf-8">
  <title>Get There Studentenportaal</title>
  <link rel="stylesheet" href="../styles.css">
  <script src="http://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body ng-app="portal">
  <header id="header">
      <div class="branding">
        <a href="dashboard"><img src="../images/logo.png" alt="logo"></a>
      </div>
      <div class="avatar">
        <p>U bent ingelogd als '${recruiterName}'<p>
        <a href="../logout">Uitloggen</a>
      </div>
      <div class="clear"></div>
      <nav id="menu">
        <ul class="fluid">
          <li><a href="dashboard">Dashboard</a></li>
          <li><a href="beheer">Beheer</a></li>
        </ul>
      </nav>
  </header>
  <div id="main">
    <div class="content-fluid">
        <h3>Nieuw bericht</h3>
        <form:form method="POST" name="email">
        	<p>Geadresseerden</p>
        	<textarea name="emailAddresses" id="test" class="nMessage"></textarea><br>
        	<p>Onderwerp</p>
        	<input type="text" name="subject" class="nMessage"><br>
        	<p>Bericht</p>
        	<textarea name="messageText"  class="nMessageB nMessage"></textarea>
        	<input type="submit">
        </form:form>
    </div>
  </div>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
    $(document).ready(function(){
        $('#test').val(sessionStorage.selectedEmails);
    });
</script>
  <%@ include file="footer.jsp" %>
