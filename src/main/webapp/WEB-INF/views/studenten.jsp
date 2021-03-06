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
          <li><a href="#" class="current">Studenten</a></li>
          <li><a href="evenementen">Evenementen</a></li>
          <li><a href="themas">Themas</a></li>
          <li><a href="beheer">Beheer</a></li>
        </ul>
      </nav>
  </header>
<div id="main" ng-controller="PortalController as vm">
    <div class="content-fluid">
    	<h1>Studenten overzicht</h1>
      <p>Volledige lijst met alle studenten.</p><br>
      <div class="menubar">
        <div class="item">
          <!--<button>Student toevoegen</button>
          <button>Studenten verwijderen</button>-->
        </div>
        <div class="item">
          <button class="success" ng-click="vm.newMailMessage()">Verstuur email</button>
          <!--<button class="success">Verstuur SMS</button>-->
        </div>
        <div class="item right">
          <p class="foundSet">{{ (vm.data|filter:thema|filter:status|filter:search|filter:event).length }} van {{ vm.data.length}} studenten in huidige weergave</p>
        </div>
        <div class="clear"></div>
      </div>
      <div class="menubar">
        <div class="item">
          <button ng-click="thema=''; event=''; search=''; status=''">Toon alle studenten</button>
        </div>
        <div class="item right">
          <input type="text" ng-model="search" id="search" placeholder="zoeken">
        </div>
        <div class="item right">
          <select ng-model="status">
            <option value="" disabled selected>Filter op status</option>
            <option value="">Toon alles</option>
            <option value="actief">Actief</option>
            <option value="verwijderd">Verwijderd</option>
          </select>
        </div>
        <div class="item right">
          <select ng-model="event" id="event">
            <option value="" disabled selected>Filter op evenement</option>
            <option value="">Toon alles</option>
            <option value="Evenement X">Evenement X</option>
            <option value="Evenement Y">Evenement Y</option>
            <option value="Evenement Z">Evenement Z</option>
          </select>
        </div>
        <div class="item right">
          <select ng-model="thema" id="thema">
            <option value="" disabled selected>Filter op thema</option>
            <option value="">Toon alles</option>
            <option value="tech">Tech events</option>
            <option value="study">Afstudeer onderzoeken</option>
            <option value="stage">Stages</option>
            <option value="trainee">Traineeships</option>
            <option value="other">Anders...</option>
          </select>
        </div>
        <div class="clear"></div>
      </div>
      <table>
        <thead>
          <th><input type="checkbox"></th>
          <th>Naam</th>
          <th>Emailadres</th>
          <th>Thema's</th>
          <th>Evenementen</th>
          <th>Status</th>
          <th></th>
        </thead>
        <tbody>
        <tr ng-repeat="item in vm.data | filter:search | filter:thema | filter:event | filter:status | orderBy:'firstName'" ng-class="{'inactive': item.status === 'Verwijderd'}">
          <td class="check"><input type="checkbox" ng-model="item.selected" ng-change="vm.updateSelection()"></td>
          <td>{{ item.firstName }} {{item.lastName}}</td>
          <td>{{ item.emailAddress }}</td>
          <td>{{ item.thema }}</td>
          <td>{{ item.events }}</td>
          <td>{{ item.status }}</td>
          <td class="check"><a href="#"><img src="../images/icon.png" title="Bekijk gegevens van deze student"></a></td>
        </tr>
      </tbody>
    </table>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="../portal.module.js"></script>
<script src="../portal.controller.js"></script>
<%@ include file="footer.jsp" %>
