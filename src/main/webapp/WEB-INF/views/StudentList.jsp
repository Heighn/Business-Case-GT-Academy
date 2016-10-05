<%@ include file="header.jsp" %>
<div id="main">
    <div class="content">
    	<p>Student List page</p>
      <ul>
      	<c:forEach items="${students}" var="student">
      	<li>
      		${student.firstName} ${student.lastName}: ${student.emailAddress}
      	</li>
      	</c:forEach>
      </ul>
    </div>
</div>



<%@ include file="footer.jsp" %>