/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author freka333
 */
public class User implements Serializable{
    private String userName;
    private String password;
    private List<Appliance> rentedAppliances = new ArrayList();
    private List<Appliance> myAppliances = new ArrayList();
    
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    
    public User(String userName, String password, List<Appliance> rentedApp, List<Appliance>myApp){
        this.userName = userName;
        this.password = password;
        this.rentedAppliances = rentedApp;
        this.myAppliances = myApp;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Appliance> getReservedAppliances() {
        return rentedAppliances;
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
        this.rentedAppliances = reservedAppliances;
    }

    public void setMyAppliances(List<Appliance> myAppliances) {
        this.myAppliances = myAppliances;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final User other = (User) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + password + ", reservedAppliances=" + rentedAppliances + ", myAppliances=" + myAppliances + '}';
    }
    
    
}
