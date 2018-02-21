<%-- 
    Document   : registrar
    Created on : Feb 20, 2018, 11:15:54 AM
    Author     : maple
--%>

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
        <h1>Registrate</h1>
        <form method="POST" action="loginServlet">
            <div class="login-page">
                <input name="email" class="form-control" type="text" placeholder="Correo" required />
                <input name="password" class="form-control" type="password" placeholder="Contraseña" required/>
                <input name="username" class="form-control" type="text" placeholder="Nombre"/>
                <input name="lastname" class="form-control" type="text" placeholder="Apellido"/>
                <input name="city" class="form-control" type="text" placeholder="Ciudad"/>
                <input name="state" class="form-control" type="text" placeholder="Estado"/>
                <input name="country" class="form-control" type="text" placeholder="Pais"/>
                <input name="cp" class="form-control" type="text" placeholder="Codigo postal"/>
                <input name="phone" class="form-control" type="text" placeholder="Numero"/>
                <input name="address" class="form-control" type="text" placeholder="Direccion"/>
                <button name="register" class="btn btn-default">Registrar</button>
                <p>Ya tienes cuenta? <a href="index.jsp">Acceder a tu cuenta</a></p>
            </div>
        </form>
    </body>
</html>
