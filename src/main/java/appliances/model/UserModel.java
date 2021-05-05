/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freka333
 */
public class UserModel {
    private User user;
    
    public UserModel(String userName, String password, List<Appliance> reservedApp, List<Appliance>myApp){
        this.user = new User(userName, password, reservedApp, myApp);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    public static List<User> userList = new ArrayList();
}
