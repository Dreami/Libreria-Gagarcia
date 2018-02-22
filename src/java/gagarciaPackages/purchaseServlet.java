/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gagarciaPackages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maple
 */
@WebServlet(name = "purchaseServlet", urlPatterns = {"/purchaseServlet"})
public class purchaseServlet extends HttpServlet {

    private Cart cart;
    private ArrayList<Book> books = new ArrayList<>();
    ServletContext sc;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (cart == null) {
            cart = new Cart();
        }
        if (request.getParameter("purchase") != null) {
            Book b = findBook(request.getParameter("purchase"));
            if (b != null) {
                if (books.contains(b)) {
                    b.addOne();
                } else {
                    books.add(b);
                }
                request.getSession().setAttribute("purchaseSuccess", "<div id='purchasesuccess'><p>Agregado al carrito</p></div>");
                response.sendRedirect("detallelibro.jsp?cover=" + b.getCover());
            }
        } else if (request.getParameter("checkout") != null) {
            if(request.getParameter("checkout").equals("dumpcart"))
                dumpCart();
            else
                cart.addToCart(books);
            
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"mainstyle.css\">");
            out.println("<title>Carrito de compra</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<img src=\"images/logo.png\"/>");
            out.println("<h1>Carrito de compras</h1>");
            if (cart == null || cart.getBooks().isEmpty()) {
                out.println("<h3>Tu carrito esta vacio</h3>");
                out.println("<a href='catalogo.jsp'>Regresar</a>");
            } else {
                sc.setAttribute("cart", cart);
                for (Book b : cart.getBooks()) {
                    out.println("<div class='cartitem'>");
                    out.println("<fieldset>");
                    out.println("<img src='images/" + b.getCover() + "' height=140 width=92px/>");
                    out.println("<legend>" + b.getDescription() + " x " + b.getAmount() + "<br>");
                    out.println("<b>$" + b.getPrice() * b.getAmount() + "</b></legend>");
                    out.println("</fieldset>");
                    out.println("</div>");
                }
                out.println("<div>");
                out.println("<h3>Total: $" + cart.getTotalPrice() + "</h3>");
                out.println("</div>");
                out.println("<div id=checkoutoptions>");
                out.println("<form method='POST' action='paymentFormServlet'>");
                out.println("<button type='submit' class='btn btn-success'>Proceder a pagar</button>");
                out.println("</form>");
                out.println("<form method='POST' action='purchaseServlet'>");
                out.println("<button name='checkout' value='dumpcart' type='submit' class='btn btn-default'>Limpiar carrito</button>");
                out.println("</form>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    private void dumpCart() {
        cart = new Cart();
        books.removeAll(books);
    }
    
    private Book findBook(String cover) {
        sc = getServletContext();
        ArrayList<Book> bookList = (ArrayList<Book>) sc.getAttribute("bookList");
        for (Book b : bookList) {
            if (b.getCover().equals(cover)) {
                return b;
            }
        }
        return null;
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
