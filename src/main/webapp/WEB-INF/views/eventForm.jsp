<%@ include file="header.jsp" %>
<div id="main">
    <div class="content">
        <h1>Event Aanmaken</h1>
        <form:form commandName="eventForm">
            <p>Naam Event</p>
            <form:input type="text" path="name"/>
            <p>Datum Event</p>
            <form:input path="date" id="datepicker"/>
            <p>Type Event</p>
            <form:select name="eventType" path="type">
                <option value="techEvent" selected>Tech Event</option>
                <option value="afstudeerOnderzoek">Afstudeeronderzoek</option>
                <option value="stageMogelijkheid">Stagemogelijkheid</option>
                <option value="traineeship">Traineeship</option>
            </form:select>
            <p>Beschrijving Event</p>
            <form:input type="text" path="description"/>
            <input type="submit">
        </form:form>
    </div>
</div>
<%@ include file="footer.jsp" %>