/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances;

import static appliances.MainApp.userList;
import appliances.model.User;

/**
 *
 * @author User
 */
public class LoginCheck {
    public static String loginCheck(String userName, String password){
        if(userName.equals("admin") && password.equals("admin")){
            userList.setActiveUser(userName);
            return "FXMLAdminPage";
        }
        else{
            for(User u : userList.getUserList()){
                if(userName.equals(u.getUserName()) && password.equals(u.getPassword())){
                    userList.setActiveUser(userName);
                    return "FXMLUserPage";
                }
            }
            return "error";
        }
    }
}
