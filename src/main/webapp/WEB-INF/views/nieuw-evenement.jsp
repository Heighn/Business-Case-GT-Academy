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
  <script>
$( function() {
  $( "#datepicker" ).datepicker();
} );
</script>
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
          <li><a href="evenementen">Evenementen</a></li>
          <li><a href="themas">Themas</a></li>
          <li><a href="beheer">Beheer</a></li>
        </ul>
      </nav>
  </header>
<div id="main">
    <div class="content-fluid">
        <h1>Evenement toevoegen</h1>
        <p>Hieronder kunt u een nieuw evenement toevoegen.</p><br>
        <form:form commandName="eventForm">
            <p>Naam evenement</p>
            <form:input type="text" path="name" class="nMessage"/>
            <p>Datum</p>
            <form:input path="date" id="datepicker" class="nMessage"/>
            <p>Thema's</p>
            <form:select name="eventType" path="type" class="fluid">
                <option value="techEvent" selected>Tech Event</option>
                <option value="afstudeerOnderzoek">Afstudeeronderzoek</option>
                <option value="stageMogelijkheid">Stagemogelijkheid</option>
                <option value="traineeship">Traineeship</option>
            </form:select>
            <br><br><br><p>Beschrijving Event</p>
            <textarea path="description" class="nMessageB nMessage"></textarea>
            <input type="submit">
        </form:form>
    </div>
</div>
<%@ include file="footer.jsp" %>
