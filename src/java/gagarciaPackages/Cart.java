/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gagarciaPackages;

import java.util.ArrayList;

/**
 *
 * @author maple
 */
public class Cart {
    private ArrayList<Book> books;
    private float totalPrice;
    
    public Cart() {
        books = new ArrayList<>();
        totalPrice = 0;
    }
    
    public void addToCart(Book b) {
        books.add(b);
        totalPrice = calculateTotal();
    }
    
    public void removeFromCart(Book b) {
        books.remove(b);
        totalPrice = calculateTotal();
    }
    
    private float calculateTotal() {
        float priceSum = 0;
        for(Book b : books) {
            priceSum += b.getPrice();
        }
        return priceSum;
    }
    
    public ArrayList<Book> getBooks() {
        return books;
    }
    
    public float getTotalPrice() {
        return totalPrice;
    }
}
