/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gagarciaPackages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TecMilenio
 */
public class paymentValidateServlet extends HttpServlet {

    private User activeUser;
    private Cart cart;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext sc = getServletContext();
        activeUser = (User) sc.getAttribute("activeUser");
        cart = (Cart) sc.getAttribute("cart");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Orden recibida</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<img src=\"images/logo.png\"/>");
            out.println("<h1>Su orden ha sido procesado exitosamente.</h1>");
            out.println("<div id='purchaseSummary'>");
            out.println("<p>Tarjeta " + request.getParameter("cardType") + "</p>");
            out.println("<p>Direccion de entrega:" + activeUser.getAddress() + ", " + activeUser.getCity() + ", " + activeUser.getState() + ", " + activeUser.getCountry() + "</p>");
            out.println("<p>Fecha de entrega: " + LocalDateTime.now().plusDays(10l).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "</p>");
            out.println("<p>Costo con envio: " + (cart.getTotalPrice() + 75f) + " </p>");
            out.println("<p>Fecha de compra: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "</p>");
            out.println("<p><a href='catalogo.jsp'><< Regresar a comprar</a></p>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
        
        sc.removeAttribute("cart");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
