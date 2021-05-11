/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.model;

import java.io.Serializable;

/**
 *
 * @author freka333
 */
public class Appliance implements Serializable{
    private String id;
    private String owner;
    private String renter;
    private String name;
    private String category;
    private int price;
    private String status;
    private String comment;
    
    public Appliance(){
        
    }
    
    public Appliance(String id, String owner, String renter, String name, String category, int price, String status, String comment) {
        this.id = id;
        this.owner = owner;
        this.renter = renter;
        this.name = name;
        this.category = category;
        this.price = price;
        this.status = status;
        this.comment = comment;
    }
    
    public String getOwner(){
        return owner;
    }

    public String getId() {
        return id;
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
    
    public String getRenter() {
        return renter;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }
    public void setId(String id) {
        this.id = id;
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
    
    public void setRenter(String renter) {
        this.renter = renter;
    }

    @Override
    public String toString() {
        return "Appliance{" + "id=" + id + ", owner=" + owner + ", renter=" + renter + ", name=" + name + ", category=" + category + ", status=" + status + ", price=" + price + ", comment=" + comment + '}';
    }
}
