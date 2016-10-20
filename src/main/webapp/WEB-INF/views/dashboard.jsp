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
          <li><a href="#" class="current">Dashboard</a></li>
          <li><a href="studenten">Studenten</a></li>
          <li><a href="evenementen">Evenementen</a></li>
          <li><a href="themas">Themas</a></li>
          <li><a href="beheer">Beheer</a></li>
        </ul>
      </nav>
  </header>
<div id="main" ng-controller="PortalController as vm">
    <div class="content-fluid">
    	<h1>Dashboard</h1>
      <p>Deze pagina bevat een overzicht van actiepunten en recente activiteit van studenten.</p><br>
      <h2>Recente wijzigingen</h2><br>
      <table>
        <thead>
          <th>Naam</th>
          <th>Veld</th>
          <th>Oude waarde</th>
          <th>Nieuwe waarde</th>
          <th></th>
        </thead>
        <tbody>
        <tr ng-repeat="item in vm.dataChanges | limitTo:10">
          <td>{{ item.firstName }} {{item.lastName}}</td>
          <td>{{ item.fieldName }}</td>
          <td>{{ item.oldValue }}</td>
          <td>{{ item.newValue }}</td>
          <td class="check"><a href="#"><img src="../images/icon.png" title="Bekijk gegevens van deze student"></a></td>
        </tr>
      </tbody>
    </table>
    <br><br><br><br><br>
      <h2>Afstudeerders</h2><br>
      <table>
        <thead>
          <th>Naam</th>
          <th>Afstudeerdatum</th>
          <th></th>
        </thead>
        <tbody>
        <tr ng-repeat="item in vm.data | orderBy:'afstudeerMaand' | limitTo:10">
          <td>{{ item.firstName }} {{item.lastName}}</td>
          <td>{{item.afstudeerDatum | date : 'MMMM'}} {{item.afstudeerDatum | date : 'dd'}}, {{item.afstudeerDatum | date : 'yyyy'}}</td>
          <td class="check"><a href="#"><img src="../images/icon.png" title="Bekijk gegevens van deze student"></a></td>
        </tr>
      </tbody>
    </table>
    <br><br><br><br><br>
    <h2>Verjaardagen</h2><br>
    <table>
      <thead>
        <th>Naam</th>
        <th>Emailadres</th>
        <th>Verjaardag</th>
        <th></th>
      </thead>
      <tbody>
      <tr ng-repeat="item in vm.data | orderBy:'verjaardagMaand' | orderBy:'verjaardagDag' | limitTo:10">
        <td>{{ item.firstName }} {{item.lastName}}</td>
        <td>{{ item.emailAddress }}</td>
        <td>{{item.verjaardag | date : 'MMMM'}} {{item.verjaardag | date : 'dd'}}</td>
        <td class="check"><a href="#"><img src="../images/icon.png" title="Bekijk gegevens van deze student"></a></td>
      </tr>
    </tbody>
  </table>
  </div>
</div>
<br><br><br><br><br><br>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="../portal.module.js"></script>
<script src="../portal.controller.js"></script>
<%@ include file="footer.jsp" %>
