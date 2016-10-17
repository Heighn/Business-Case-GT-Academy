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
<body ng-app="correspondence">
< id="header">

<table>
    <thead>
    <th><input type="checkbox"></th>
    <th>Type</th>
    <th>Ontvangers</th>
    <th>Onderwerp</th>
    <th>Bericht</th>
    </thead>
    <tbody>
    <tr ng-repeat="item in vm.data">
        <td>{{ item.type }}</td>
        <td>{{ item.ontvangers }}</td>
        <td>{{ item.onderwerp }}</td>
        <td>{{ item.bericht }}</td>
    </tr>
    </tbody>
</table>



<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<script src="../correspondence.module.js"></script>
<script src="../correspondence.controller.js"></script>
<%@ include file="footer.jsp" %>
