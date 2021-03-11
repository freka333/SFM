/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.model;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Appliance implements Serializable{
    private String name;
    private String category;
    private int price;
    private String status;
    private String comment;

    public Appliance(String name, String category, int price, String status) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.status = status;
    }
    
    public Appliance(String name, String category, int price, String status, String comment) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.status = status;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public int getPrice() {
        return price;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Appliance{" + "name=" + name + ", category=" + category + ", status=" + status + ", price=" + price + ", comment=" + comment + '}';
    }
}
