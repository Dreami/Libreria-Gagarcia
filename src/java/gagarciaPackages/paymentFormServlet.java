/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gagarciaPackages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TecMilenio
 */
public class paymentFormServlet extends HttpServlet {

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
        if (activeUser != null) {
            if (cart != null) {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
                    out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">");
                    out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>");
                    out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"mainstyle.css\">");
                    out.println("<title>Payment</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<img src=\"images/logo.png\"/>");
                    
                    out.println("<form id='paymentMethodForm' class='form-group' action='paymentValidateServlet' method='POST'>");
                    out.println("<div id='cardDetails' >");
                    out.println("<h1>Metodo de pago</h1>");
                    out.println("<div id='choosecard'");
                    out.println("<legend>Seleccione su tarjeta</legend>");
                    out.println("<select name='cardType' class='form-control'>");
                    out.println("<option value='Paypal'>Paypal</option>");
                    out.println("<option value='Mastercard'>Mastercard</option>");
                    out.println("<option value='VISA'>VISA</option>");
                    out.println("<option value='American Express'>American Express</option>");
                    out.println("</select>");
                    out.println("</div>");
                    
                    
                    
                    out.println("<div id='cardHolderForm' ");
                    out.println("<label >Nombre: </label>");
                    out.println("<input class='form-control'  value='" + activeUser.getUn() + " " + activeUser.getLn() + "' placeholder='i.e. Dracula'>");
                    out.println("</div>");
                    
                    out.println("<div id='cardNumberForm' ");
                    out.println("<label >Numero de tarjeta: </label>");
                    out.println("<input class='form-control ' maxlength='16' required>");
                    out.println("</div>");
                    
                    out.println("<div id='cardExpiration' ");
                    out.println("<label >Expiration date: </label>");
                    out.println("<input class='form-control'  placeholder='MM' maxlength='2' required>");
                    out.println("<input class='form-control' placeholder='YY' maxlength='2' required>");
                    out.println("</div>");
                    
                    out.println("<div id='securitycodeform' ");
                    out.println("<label >Codigo de seguridad: </label>");
                    out.println("<input class='form-control ' placeholder='***' maxlength='3' required>");
                    out.println("</div>");
                    
                    out.println("</div>");
                    
                    out.println("<hr>");
                    
                    
                    
                    out.println("<div id='deliveryInfo' > ");
                    out.println("<h1>Direccion de envio</h1>");
                    out.println("<div ");
                    out.println("<label >Direccion: </label>");
                    out.println("<input class='form-control' value='" + activeUser.getAddress() + "' placeholder='Calle Acueducto' required>");
                    out.println("</div>");
                    
                    out.println("<div>");
                    out.println("<label>Ciudad: </label>");
                    out.println("<input class='form-control ' value='" + activeUser.getCity() + "' placeholder='Cd. de Mexico' required>");
                    
                    
                    out.println("<label>Estado:</label>");
                    out.println("<input class='form-control' value='" + activeUser.getState() + "' placeholder='Queretaro' required>");
                    out.println("</div>");
                    
                    out.println("<div ");
                    out.println("<label >Pais: </label>");
                    out.println("<input class='form-control ' value='" + activeUser.getCountry() + "' placeholder='Pakistan' required>");
                    out.println("</div>");
                    
                    out.println("<div ");
                    out.println("<label >Codigo postal: </label>");
                    out.println("<input class='form-control' value='" + activeUser.getCp() + "' placeholder='54656'>");
                    out.println("</div>");
                    
                    out.println("<div ");
                    out.println("<label >Celular: </label>");
                    out.println("<input class='form-control' value='" + activeUser.getPhone() + "' placeholder='8115991230'>");
                    out.println("</div>");
                    
                    out.println("</div>");
                    
                    out.println("<div><button type='submit' class='btn btn-success'>Comprar</button></div>");
                    out.println("</form>");
                    
                    out.println("<hr>");
                    
                    
                    out.println("<div id='receipt' </div>");
                    out.println("<h1>Recibo: </h1>");
                    out.println("<table class='table table-bordered'>");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>Product</th>");
                    out.println("<th>Amount</th>");
                    out.println("<th>Total</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    for(Book b: cart.getBooks()) {
                        out.println("<tr>");
                        out.println("<td>");
                        out.println(b.getDescription());
                        out.println("</td>");
                        out.println("<td>");
                        out.println(b.getAmount());
                        out.println("</td>");
                        out.println("<td>");
                        out.println("$ " + b.getPrice() * b.getAmount());
                        out.println("</td>");
                        out.println("</tr>");
                    }
                    out.println("<tr>");
                    out.println("<td>Envio</td>");
                    out.println("<td>-</td>");
                    out.println("<td>$ 75.00</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td><b>Total</b></td>");
                    out.println("<td>-</td>");
                    out.println("<td><b>$ " + (cart.getTotalPrice() + 75f) + "</b></td>");
                    out.println("</tr>");
                    out.println("</tbody>");
                    out.println("</table>");
                    out.println("</div>");
                    
                    
                    out.println("</body>");
                    out.println("</html>");
                }
            } else {
                response.sendRedirect("catalogo.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }

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