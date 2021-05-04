/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.model;

import static appliances.model.ApplianceModel.appliancesList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author freka333
 */
public class UserModel {
    public static List<User> userList = new ArrayList();
    
    
    public static void userSerialisation(){
        try (FileOutputStream fs = new FileOutputStream("files/users.ser");
             ObjectOutputStream os = new ObjectOutputStream(fs);) {
            os.writeObject(userList);
        } catch (IOException ex){
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void userDeserialisation(){
        try (FileInputStream fs = new FileInputStream("files/users.ser");
             ObjectInputStream os = new ObjectInputStream(fs);) {
            userList = (List<User>)os.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
