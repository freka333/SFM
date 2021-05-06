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
public class ApplianceModel {
    public static List<Appliance> appliancesList = new ArrayList();
    public static String currentId;
    
    public static String idGenerator(){
        int id = 0;
        if(!appliancesList.isEmpty())
            for(Appliance a : appliancesList)
                if(Integer.parseInt(a.getId()) > id)
                    id = Integer.parseInt(a.getId());
        return Integer.toString(id + 1);
    }

}
