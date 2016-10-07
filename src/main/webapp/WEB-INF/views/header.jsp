<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="charset" content="utf-8">
  <title>Get There Studentenportaal</title>
  <link rel="stylesheet" href="../styles.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
    $( function() {
      $( "#accordion" ).accordion({
        collapsible: true
      });
    } );
    </script>
    <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
</head>
<body>
  <header id="header">
      <div class="branding">
        <a href="inloggen"><img src="../images/logo.png" alt="logo"></a>
      </div>
      <nav id="menu">
        <ul>
          <li><a href="#" class="current">Profiel</a></li>
          <li><a href="/inloggen">Uitloggen</a></li>
          <!--<li><a href="/sendEmail">Email Verzenden</a></li>
  		    <li><a href="/recruitersList">Recruitersoverzicht</a></li>
          <li><a href="/StudentList">Studentenoverzicht</a></li>
          <li><a href="/DeleteStudent">Verwijder een Student</a></li>-->
        </ul>
      </nav>
  </header>
