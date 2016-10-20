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
</head>
<body ng-app="portal">
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
<div id="main" ng-controller="PortalController as vm">
  <div class="content-fluid">
    <h1>U bent ingelogd, ${recruiterName}</h1>

    <h2>Recente Wijzigingen in onze Studentgegevens</h2>
    <p ng-repeat="item in vm.dataChanges">
      {{ item.firstName }} {{ item.lastName }} veranderde zijn/haar {{ item.fieldName }} van {{ item.oldValue }} naar {{ item.newValue }}.
    </p>

    <h2>Aankomende Verjaardagen</h2>
    <p ng-repeat="item in vm.data | orderBy:'verjaardagMaand' | orderBy:'verjaardagDag' | limitTo:10">
      {{item.firstName}} {{item.lastName}}: {{item.verjaardag | date : 'EEEE'}}, {{item.verjaardag | date : 'MMMM'}} {{item.verjaardag | date : 'dd'}}
    </p>

    <h2>Aankomende Afstudeerders (minimaal 3 maand)</h2>
    <p ng-repeat="item in vm.data | orderBy:'afstudeerMaand' | limitTo:10">
      {{item.firstName}} {{item.lastName}}: {{item.afstudeerDatum | date : 'EEEE'}}, {{item.afstudeerDatum | date : 'MMMM'}} {{item.afstudeerDatum | date : 'dd'}} {{item.afstudeerDatum | date : 'yyyy'}}
    </p>


  </div>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="../portal.module.js"></script>
<script src="../portal.controller.js"></script>
<%@ include file="footer.jsp" %>
