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
      $( "#accordion" ).accordion({
        collapsible: true,
        heightStyle: "content"
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
        <a href="dashboard"><img src="../images/logo.png" alt="logo"></a>
      </div>
      <div class="avatar">
        <p>U bent ingelogd als '${firstName}'<p>
        <a href="../logout">Uitloggen</a>
      </div>
      <div class="clear"></div>
      <nav id="menu">
        <ul>
          <li><a href="#" class="current">Profiel</a></li>
          <li><a href="#">Evenementen</a></li>
        </ul>
      </nav>
  </header>
