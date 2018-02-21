/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gagarciaPackages;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {

    ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    public User activeUser;
    private static final String wrongUserMessage = "<div id='loginErr'>Su contraseña o correo son incorrectos.</div>";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = getServletContext();
        request.removeAttribute("loginErr");
        
        if(userList.isEmpty()) {
            User masterUser = (User) sc.getAttribute("masterUser");
            userList.add(masterUser);
        }

        if (request.getParameter("login") != null) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            for (User u : userList) {
                if (email.equals(u.getEmail()) && password.equals(u.getPassword())) {
                    activeUser = u;
                    sc.setAttribute("activeUser", activeUser);
                }
            }

            if (activeUser == null) {
                request.getSession().setAttribute("loginErr", wrongUserMessage);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("catalogo.jsp");
            }
        } else if (request.getParameter("register") != null) {
            String email, password, username, lastname, cp, city, state, country, phone, address;
            email = request.getParameter("email");
            password = request.getParameter("email");
            username = request.getParameter("username");
            lastname = request.getParameter("lastname");
            cp = request.getParameter("cp");
            city = request.getParameter("city");
            state = request.getParameter("state");
            country = request.getParameter("country");
            phone = request.getParameter("phone");
            address = request.getParameter("address");

            userList.add(new User(username, lastname, address, cp, city, state, country, phone, email, password));
            //stockUpBooks();
            response.sendRedirect("catalogo.jsp");
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
