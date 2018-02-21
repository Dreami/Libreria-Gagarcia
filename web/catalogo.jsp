<%-- 
    Document   : catalogo
    Created on : Feb 20, 2018, 11:16:05 AM
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
        <div id="headingWithCart">
            <h1>Catalogo</h1>
            <form method="POST" action="purchaseServlet">
                <button name="checkout" type="submit" class="btn btn-info btn-lg">
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                </button>
            </form>
        </div>
        <div id="bookListing">
            <c:forEach var="book" items="${applicationScope['bookList']}">
                <div class="bookspace">
                    <div class="col-md-4">
                        <img src="images/<c:out value="${book.getCover()}"/>"/>
                        <h3>Titulo: <a href="detallelibro.jsp?cover=<c:out value="${book.getCover()}"/>"><c:out value="${book.getDescription()}"/></a></h3>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
