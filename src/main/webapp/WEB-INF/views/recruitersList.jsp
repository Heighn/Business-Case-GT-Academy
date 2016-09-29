<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
  <title>Get There studentenportaal</title>
  <link rel="stylesheet" href="../styles.css">
</head>
<body>
  <header id="header">
  </header>
  <div id="main">
    <div class="content">
      <ul>
      	<c:forEach items="${recruiters}" var="recruiter">
      	<li>
      		${recruiter.id} ${recruiter.recruiterName}
      	</li>
      	</c:forEach>
      </ul>
    </div>
  </div>
  <footer id="footer">
  </footer>
</body>
</html>
