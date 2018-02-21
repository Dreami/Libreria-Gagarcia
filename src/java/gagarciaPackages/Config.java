/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gagarciaPackages;

import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author maple
 */
@WebListener
public class Config implements ServletContextListener { 

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("a-gate-at-the-stairs.jpg", "A gate at the stairs", "Habia unas escaleras y una puerta y las abro.", 10.99f));
        bookList.add(new Book("clockwork-orange.jpg", "A Clockwork Orange", "Coge, toma, mata asi que lo amarran a una silla.", 19.99f));
        bookList.add(new Book("cogheart.jpg", "Cogheart", "AI desarrolla sentimientos y esta bien.", 21.99f));
        bookList.add(new Book("house-lost-at-sea.jpg", "The house lost at sea", "Eso pasa cuando sube la marea y vives en la playa.", 5.99f));
        bookList.add(new Book("how-the-dead-live.jpg", "How the dead live", "Si Jesus pudo, yo tambien.", 8.99f));
        bookList.add(new Book("how-to-dutch.jpg", "How to be the perfect Dutch", "Hon-hon baguette pero ahora con stroopwaffles.", 3.59f));
        bookList.add(new Book("our-grand-finale.jpeg", "Our grand finale", "Hugh Jackman cantando cuando fue despedido de Fox.", 2.19f));
        bookList.add(new Book("the-aeneid.jpg", "The Aeneid", "Mermaid? No, Aeneid.", 10.99f));
        bookList.add(new Book("the-night-gardener.jpg", "The Night Gardener", "Es que de dia no hay chamba.", 10.99f));
        sce.getServletContext().setAttribute("bookList", bookList);
        
        User masterUser = new User("Dummy", "Test", "TecMilenio", "010101", "Monterrey", "Nuevo Leon", "Mexico", "1111111", "dummy@tester.wa", "123");
        sce.getServletContext().setAttribute("masterUser", masterUser);
                //tring un, String ln, String address, String cp, String city, String state, String country, String phone, String email, String password
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}