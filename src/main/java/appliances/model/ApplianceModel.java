/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.model;

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
public class ApplianceModel {
    public static List<Appliance> appliancesList = new ArrayList();

    public static boolean adminLoginCheck(String userName, String password){
        return userName.equals("admin") && password.equals("admin");
    }
    
    public static boolean userLoginCheck(String userName, String password){
        return userName.equals("user") && password.equals("user");
    }

    public static void serialisationList(){
        try (FileOutputStream fs = new FileOutputStream("files/appliances.ser");
             ObjectOutputStream os = new ObjectOutputStream(fs);) {
            os.writeObject(appliancesList);
        } catch (IOException ex){
            Logger.getLogger(ApplianceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deserialisation(){
        try (FileInputStream fs = new FileInputStream("files/appliances.ser");
             ObjectInputStream os = new ObjectInputStream(fs);) {
            ApplianceModel.appliancesList = (List<Appliance>)os.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ApplianceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String idGenerator(){
        int id = 0;
        if(!appliancesList.isEmpty())
            for(Appliance a : appliancesList)
                if(Integer.parseInt(a.getId()) > id)
                    id = Integer.parseInt(a.getId());
        return Integer.toString(id + 1);
    }
}
