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
<body class="bg">

<div id="main">
    <div class="login-container">
        <div class="login-form">
            <img src="../images/logo.png" alt="logo" class="logo">
            <h3>Wachtwoord vergeten</h3>
            <p>Vul uw emailadres in en ontvang uw nieuwe wachtwoord direct per email.</p><br>
            <form:form method="post" name="wachtwoordVergetenSheet">
                <p>Emailadres</p>
                <input type="text" name="emailAddress" />
                <input type="submit" />
            </form:form>
            <p><a href="../registreren">Nieuw account</a> | <a href="../inloggen">Inloggen</a></p>
        </div>
    </div>
</div>


</body>
</html>
