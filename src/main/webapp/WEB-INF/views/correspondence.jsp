<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="charset" content="utf-8">
    <title>Get There Studentenportaal</title>
    <link rel="stylesheet" href="../css/styles.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body ng-app="correspondence">
<header id="header">
    <div class="branding">
        <a href="inloggen"><img src="../images/logo.png" alt="logo"></a>
    </div>
    <nav id="menu">
        <ul class="fluid">
            <li><a href="#" class="current">Overzicht studenten</a></li>
            <li><a href="#">Evenementen</a></li>
            <li><a href="/inloggen">Uitloggen</a></li>
            <!--<li><a href="/sendEmail">Email Verzenden</a></li>
                <li><a href="/recruitersList">Recruitersoverzicht</a></li>
            <li><a href="/StudentList">Studentenoverzicht</a></li>
            <li><a href="/DeleteStudent">Verwijder een Student</a></li>-->
        </ul>
    </nav>
</header>
<div class="content-fluid">
    <h1>Gepleegde Correspondentie met Studenten</h1>
    <p>Hieronder zie je een lijst met eerdere correspondentie met studenten.</p><br>

    <div class="menubar">
        <div class="item">
            <input type="button" onclick="location.href='/recruiter/nieuwe-correspondentie'" value="Nieuwe Correspondentie" />
        </div>
        <div class="clear"></div>
    </div>

    <div id="main2" ng-controller="CorrespondenceController as vm">
        <div class="item right">
            <select ng-model="order" id="order">
                <option value="" disabled selected>Sorteermethode</option>
                <option value="dateString">Datum</option>
                <option value="type">Type</option>
                <option value="receivers">Ontvangers</option>
            </select>
        </div>
        <div class="item right">
            <select ng-model="type" id="type">
                <option value="" disabled selected>Filter op Type</option>
                <option value="Email">Email</option>
                <option value="Telefoongesprek">Telefoongesprek</option>
                <option value="Persoonlijk Bezoek">Persoonlijk Gesprek</option>
            </select>
        </div>
        <div class="item right">
            <select ng-model="receivers" id="receivers">
                <option value="" disabled selected>Filter op Student</option>
                <option ng-repeat="item in vm.studentData" value={{item.emailAddress}}>{{ item.firstName }} {{ item.lastName }}</option>
            </select>
        </div>


        <table>
            <thead>
            <th>Datum</th>
            <th>Type</th>
            <th>Ontvangers</th>
            <th>Onderwerp</th>
            <th>Bericht</th>
            </thead>
            <tbody>

            <tr ng-repeat="item in vm.data | filter:type | filter:receivers | orderBy:order">
                <td>{{ item.dateString }}</td>
                <td>{{ item.type }}</td>
                <td>{{ item.receivers }}</td>
                <td>{{ item.subject }}</td>
                <td>{{ item.message }}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>

<script src="../js/correspondence.module.js"></script>
<script src="../js/correspondence.controller.js"></script>
<script src="../correspondence.module.js"></script>
<script src="../correspondence.controller.js"></script>

<script src="../portal.module.js"></script>
<script src="../portal.controller.js"></script>

<%@ include file="footer.jsp" %>
