/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gagarciaPackages;

import java.util.Objects;

/**
 *
 * @author maple
 */
public class Book {
    private String cover;
    private String description;
    private String sinopsis;
    private float price;
    private int amount;

    public Book(String cover, String description, String sinopsis, float price) {
        this.cover = cover;
        this.description = description;
        this.sinopsis = sinopsis;
        this.price = price;
        this.amount = 1;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cover);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.cover, other.cover)) {
            return false;
        }
        return true;
    }
    
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void addOne() {
        amount++;
    }
    
    public int getAmount() {
        return amount;
    }
}
