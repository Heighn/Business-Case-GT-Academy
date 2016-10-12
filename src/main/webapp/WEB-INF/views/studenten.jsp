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
  var availableTags = [
    <c:forEach items="${students}" var="student">
        "${student.firstName} ${student.lastName}",
    </c:forEach>
  ];
  $( "#search" ).autocomplete({
    source: availableTags
  });
} );
</script>
</head>
<body ng-app="portal">
  <header id="header">
      <div class="branding">
        <a href="inloggen"><img src="../images/logo.png" alt="logo"></a>
      </div>
      <nav id="menu">
        <ul>
          <li><a href="#" class="current">Profiel</a></li>
          <li><a href="#">Evenementen</a></li>
          <li><a href="/inloggen">Uitloggen</a></li>
          <!--<li><a href="/sendEmail">Email Verzenden</a></li>
  		    <li><a href="/recruitersList">Recruitersoverzicht</a></li>
          <li><a href="/StudentList">Studentenoverzicht</a></li>
          <li><a href="/DeleteStudent">Verwijder een Student</a></li>-->
        </ul>
      </nav>
  </header>
<div id="main2">
    <div class="content">
    	<h1>Overzicht studenten</h1>
      <p>De tabel hieronder toont een lijst met alle studenten die zich hebben ingeschreven via het Get There studentenportaal.</p><br>
      <div class="menubar">
        <div class="item">
          <button>Student toevoegen</button>
          <button>Studenten verwijderen</button>
        </div>
        <div class="item">
          <button>Email</button>
          <button>SMS</button>
        </div>
        <div class="item right">
          <p class="small">3 van 10 studenten in overzicht</p>
        </div>
        <div class="clear"></div>
      </div>
      <div class="menubar">
        <div class="item">
          <input type="checkbox">
        </div>
        <div class="item">
          <select>
            <option value="" disabled selected>Filter op thema</option>
            <option value="tech">Tech events</option>
            <option value="study">Afstudeer onderzoeken</option>
            <option value="stage">Stages</option>
            <option value="trainee">Traineeships</option>
            <option value="other">Anders...</option>
          </select>
        </div>
        <div class="item">
          <select>
            <option value="" disabled selected>Filter op evenement</option>
            <option value="">Evenement X</option>
            <option value="">Evenement Y</option>
            <option value="">Evenement Z</option>
          </select>
        </div>
        <div class="item right">
          <input id="search" placeholder="zoeken">
        </div>
        <div class="clear"></div>
      </div>
      <table>
        <thead>
          <th><input type="checkbox"></th>
          <th>Naam</th>
          <th>Emailadres</th>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
          <tr>
            <td class="check"><input type="checkbox"></td>
            <td>${student.firstName} ${student.lastName}</td>
            <td>${student.emailAddress}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>



<%@ include file="footer.jsp" %>
