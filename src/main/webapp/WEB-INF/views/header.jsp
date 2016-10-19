<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="content-type" content="text/javascript; charset=utf-8">
  <title>Get There Studentenportaal</title>
  <base href="/">
  <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
  <header id="header">
      <div class="branding">
        <a href="inloggen"><img src="../images/logo.png" alt="logo"></a>
      </div>
      <div ng-include="html/nav-students.html"></div>
      <div ng-include="nav-recruiters.html"></div>
  </header>
