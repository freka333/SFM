/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freka333
 */
public class User implements Serializable{
    private String userName;
    private String password;
    private List<Appliance> reservedAppliances = new ArrayList();
    private List<Appliance> myAppliances = new ArrayList();

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Appliance> getReservedAppliances() {
        return reservedAppliances;
    }

    public List<Appliance> getMyAppliances() {
        return myAppliances;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setReservedAppliances(List<Appliance> reservedAppliances) {
        this.reservedAppliances = reservedAppliances;
    }

    public void setMyAppliances(List<Appliance> myAppliances) {
        this.myAppliances = myAppliances;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + password + ", reservedAppliances=" + reservedAppliances + ", myAppliances=" + myAppliances + '}';
    }
    
    
}
