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
          <li><a href="#" class="current">Evenementen</a></li>
          <li><a href="themas">Themas</a></li>
          <li><a href="beheer">Beheer</a></li>
        </ul>
      </nav>
  </header>
<div id="main" ng-controller="PortalController as vm">
    <div class="content-fluid">
    	<h1>Evenementen</h1>
      <p>Hieronder kunt u evenementen beheren en de deelnemers per evenement bekijken.</p><br>
      <div class="menubar">
        <div class="item">
          <!--<button>Student toevoegen</button>
          <button>Studenten verwijderen</button>-->
        </div>
        <div class="item">
          <button class="success" onclick="window.location.href='nieuw-evenement'">Evenement toevoegen</button>
          <button class="delete">Evenement verwijderen</button>
        </div>
        <div class="item right">
          <p class="foundSet">{{ (vm.data|filter:thema|filter:status|filter:search|filter:event).length }} van {{ vm.data.length}} evenementen in huidige weergave</p>
        </div>
        <div class="clear"></div>
      </div>
      <div class="menubar">
        <div class="item">
          <button ng-click="thema=''; event=''; search=''; status=''">Toon alle evenementen</button>
        </div>
        <div class="item right">
          <input type="text" ng-model="search" id="search" placeholder="zoeken">
        </div>
        <div class="clear"></div>
      </div>
      <table>
        <thead>
          <th><input type="checkbox"></th>
          <th>Omschrijving</th>
        </thead>
        <tbody>
        <tr ng-repeat="item in vm.data | filter:search | filter:thema | filter:event | filter:status | orderBy:'firstName'" ng-class="{'inactive': item.status === 'Verwijderd'}">
          <td class="check"><input type="checkbox" ng-model="item.selected" ng-change="vm.updateSelection()"></td>
          <td>{{ item.firstName }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="../portal.module.js"></script>
<script src="../portal.controller.js"></script>
<%@ include file="footer.jsp" %>
