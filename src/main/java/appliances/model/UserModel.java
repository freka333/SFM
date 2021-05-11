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
    private List<User> userList = new ArrayList();
    private String activeUser = "";

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    public String getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(String user) {
        this.activeUser = user;
    }
    
    public void addUser(User user) {
        this.userList.add(user);
    }

}
