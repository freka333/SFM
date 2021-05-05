/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances;

import appliances.model.User;
import static appliances.model.UserModel.userList;

/**
 *
 * @author User
 */
public class LoginCheck {
    public static String loginCheck(String userName, String password){
        if(userName.equals("admin") && password.equals("admin"))
            return "admin";
        else{
            for(User u : userList){
                if(userName.equals(u.getUserName()) && password.equals(u.getPassword()))
                    return "ok";
            }
            return "error";
        }
    }
}
