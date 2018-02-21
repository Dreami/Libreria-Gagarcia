<%-- 
    Document   : detallelibro
    Created on : Feb 21, 2018, 12:45:26 PM
    Author     : maple
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="gagarciaPackages.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% ServletContext sc = getServletContext();
        String currentCover = request.getParameter("cover");
        ArrayList<Book> bookList = (ArrayList<Book>) sc.getAttribute("bookList");
        for (Book b : bookList) {
            if (currentCover.equals(b.getCover())) {
                request.setAttribute("currentBook", b);
            }
        }
    %>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="mainstyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${purchaseSuccess}
        <c:remove var="purchaseSuccess" scope="session" />
        <div id='bookDetails'>
            <div id="headingWithCart">
                <h1>Titulo: ${currentBook.getDescription()}</h1>
                <form method="POST" action="purchaseServlet">
                <button name="checkout" type="submit" class="btn btn-info btn-lg">
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                </button>
            </div>

            <img src="images/${currentBook.getCover()}"/>

            <p id='sinopsis'><b>Sinopsis: </b> ${currentBook.getSinopsis()}</p>

            <div id='price'>$ ${currentBook.getPrice()}</div>
            <div id='pageoptions'>
                <div>
                    <form method='POST' action="purchaseServlet">
                        <button name='purchase' value="${currentBook.getCover()}" class='btn btn-success' type='submit'>Agregar al carrito</button>
                    </form>
                </div>
                <div>
                    <a href='catalogo.jsp'><< Regresar al catalogo</a>
                </div>
            </div>
        </div>
    </body>
</html>
