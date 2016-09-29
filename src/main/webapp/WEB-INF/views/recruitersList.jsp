<%@ include file="header.jsp" %>
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
  <%@ include file="header.jsp" %>