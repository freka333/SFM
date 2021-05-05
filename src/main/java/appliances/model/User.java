/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author freka333
 */
public class User implements Serializable{
    private StringProperty userName = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private List<Appliance> reservedAppliances = new ArrayList();
    private List<Appliance> myAppliances = new ArrayList();
    
    public User(String userName, String password, List<Appliance> reservedApp, List<Appliance>myApp){
        this.userName.set(userName);
        this.password.set(password);
        this.reservedAppliances = reservedApp;
        this.myAppliances = myApp;
    }

    public String getUserName() {
        return userName.get();
    }

    public String getPassword() {
        return password.get();
    }

    public List<Appliance> getReservedAppliances() {
        return reservedAppliances;
    }

    public List<Appliance> getMyAppliances() {
        return myAppliances;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public void setReservedAppliances(List<Appliance> reservedAppliances) {
        this.reservedAppliances = reservedAppliances;
    }

    public void setMyAppliances(List<Appliance> myAppliances) {
        this.myAppliances = myAppliances;
    }
    
    public StringProperty nameProperty(){
        return userName;
    }
    
    public StringProperty passwordProperty(){
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + password + ", reservedAppliances=" + reservedAppliances + ", myAppliances=" + myAppliances + '}';
    }
    
    
}
