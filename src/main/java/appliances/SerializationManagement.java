/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances;

import appliances.model.Appliance;
import appliances.model.ApplianceModel;
import static appliances.model.ApplianceModel.appliancesList;
import appliances.model.User;
import appliances.model.UserModel;
import static appliances.model.UserModel.userList;
import java.io.File;
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
public class SerializationManagement {
    public static void userSerialisation(){
        try (FileOutputStream fs = new FileOutputStream("files/users.ser");
             ObjectOutputStream os = new ObjectOutputStream(fs);) {
            os.writeObject(userList);
        } catch (IOException ex){
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void userDeserialisation(){
        File tempFile = new File("files/users.ser");
        if(tempFile.exists()){
            try (FileInputStream fs = new FileInputStream("files/users.ser");
                 ObjectInputStream os = new ObjectInputStream(fs);) {
                userList = (List<User>)os.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            userList.add(new User("user1", "user1"));
            userList.add(new User("user2", "user2"));
            userList.add(new User("admin", "admin"));
        }
    }
    
    public static void applianceSerialisation(){
        try (FileOutputStream fs = new FileOutputStream("files/appliances.ser");
             ObjectOutputStream os = new ObjectOutputStream(fs);) {
            os.writeObject(appliancesList);
        } catch (IOException ex){
            Logger.getLogger(ApplianceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void applianceDeserialisation(){
        File tempFile = new File("files/appliances.ser");
        if(tempFile.exists()){
            try (FileInputStream fs = new FileInputStream("files/appliances.ser");
                 ObjectInputStream os = new ObjectInputStream(fs);) {
                appliancesList = (List<Appliance>)os.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ApplianceModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            appliancesList.add(new Appliance("1", "admin", "Porszívó", "háztartási eszköz", 2000, "bérelhető", ""));
            applianceSerialisation();
        }
    }
}
