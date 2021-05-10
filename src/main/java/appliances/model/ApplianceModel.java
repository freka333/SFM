/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.model;

import static appliances.MainApp.applianceList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freka333
 */
public class ApplianceModel {
    private List<Appliance> appList = new ArrayList();
    public static String currentId;

    public List<Appliance> getAppList() {
        return appList;
    }

    public void setAppList(List<Appliance> appliancesList) {
        this.appList = appliancesList;
    }
    
    public void addAppliance(Appliance app){
        this.appList.add(app);
    }
    
    public void deleteAppliance(Appliance app){
        this.appList.remove(app);
    }
    
    public static String idGenerator(){
        int id = 0;
        if(!applianceList.getAppList().isEmpty())
            for(Appliance a : applianceList.getAppList())
                if(Integer.parseInt(a.getId()) > id)
                    id = Integer.parseInt(a.getId());
        return Integer.toString(id + 1);
    }

}
