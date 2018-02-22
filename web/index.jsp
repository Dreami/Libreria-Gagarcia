<%-- 
    Document   : index
    Created on : Feb 20, 2018, 1:55:52 AM
    Author     : maple
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="mainstyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="images/logo.png"/>
        <h1>Iniciar sesión</h1>
        <form method="POST" action="loginServlet">
            <div class="login-page">
                <input name="email" class="form-control" type="text" placeholder="Correo" required/>
                <input name="password" class="form-control" type="password" placeholder="Contraseña" required/>
                <button name="login" class="btn btn-default">Acceder</button>
                <p>No tienes cuenta? <a href="registrar.jsp">Crear cuenta</a></p>
            </div>
        </form>
        ${loginErr}
        <c:remove var="loginErr" scope="session" />
    </body>
</html>
