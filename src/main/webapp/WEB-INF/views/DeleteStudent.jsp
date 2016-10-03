<%@ include file="header.jsp" %>
<div id="main">
    <div class="content">
      <ul>
      	<c:forEach items="${students}" var="student">
      	<li>
      		<form method="post">
      			${student.firstName} ${student.lastName}: ${student.emailAddress} <button type="button" name="${student.emailAddress}">Verwijder</button>
      		</form>
      	</li>
      	</c:forEach>
      </ul>
    </div>
</div>



<%@ include file="footer.jsp" %>