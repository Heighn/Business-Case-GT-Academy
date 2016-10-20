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
<body ng-app="event">
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
            <li><a href="profiel" >Profiel</a></li>
            <li><a href="#" class="current">Evenementen</a></li>
        </ul>
    </nav>
</header>
<div id="main" ng-controller="EventController as vm">
    <div class="content-fluid">
        <h1>Evenementen</h1>
        <p>Hieronder kunt je de aankomende evenementen bekijken!</p><br>
        <div class="menubar">
            <div class="item">
                <!--<button>Student toevoegen</button>
                <button>Studenten verwijderen</button>-->
            </div>
            <%--<div class="item">--%>
                <%--<button class="success" onclick="window.location.href='nieuw-evenement'">Evenement toevoegen</button>--%>
                <%--<button class="delete">Evenement verwijderen</button>--%>
            <%--</div>--%>

            <div class="clear"></div>
        </div>
        <%--<div class="menubar">--%>

            <%--<div class="clear"></div>--%>
        <%--</div>--%>
        <table>
            <thead>
            <th>Event</th><th>Type</th><th>Omschrijving</th><th>Datum</th>
            </thead>
            <tbody>
            <tr ng-repeat="item in vm.data">
                <td>{{ item.name }}</td>
                <td>{{ item.type }}</td>
                <td>{{ item.description }}</td>
                <td>{{ item.date }}</td>
                <td><a href="/student/{{item.name}}">Aanmelden!</a></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="../event.module.js"></script>
<script src="../event.controller.js"></script>
<%@ include file="footer.jsp" %>
