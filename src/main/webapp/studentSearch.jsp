<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AJAX Demo</title>
</head>
<body>
<section>
    Zoekterm: <input type="text" id="zoekterm"><br>
    <input type="button" value="Zoek!" id="zoek_btn"><br>
    <p style="display:hidden">Resultaat: <span id="zoekresultaat"></span></p>
</section>

<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

<script>
    var root_url = "${pageContext.request.contextPath}/";

    function search(){
        var zoekterm = $('#zoekterm').val();
        var url = root_url + "recruiter/searchStudent";

        $.get(url, {zoekterm: zoekterm}, function(data){
            console.log(data);
            $('#zoekresultaat').text(data).show();
        });

    }
    $(document).ready(function(){
        $('#zoek_btn').click(search);
    });

</script>

</body>
</html>