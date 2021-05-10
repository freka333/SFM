/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import static appliances.Dialogs.infoAlert;
import appliances.MainApp;
import static appliances.MainApp.applianceList;
import static appliances.MainApp.userList;
import appliances.model.Appliance;
import appliances.model.ApplianceModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author freka333
 */
public class FXMLEditableItemController implements Initializable {
    @FXML
    private Label id;

    @FXML
    private Label name;

    @FXML
    private Label comment;

    @FXML
    private Label category;

    @FXML
    private Label status;

    @FXML
    private Label price;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;
    
    @FXML
    private Button reserveButton;
    
    public void setData(Appliance appliance){
        id.setText("#" + appliance.getId());
        name.setText(appliance.getName());
        category.setText(appliance.getCategory());
        status.setText(appliance.getStatus());
        price.setText(Integer.toString(appliance.getPrice()) + " Ft");
        comment.setText(appliance.getComment());
        if(userList.getActiveUser().equals("admin")){
            reserveButton.setVisible(false);
            editButton.setVisible(true);
            deleteButton.setVisible(true);
        }
        else{
            reserveButton.setVisible(true);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
        }
    }
    
    @FXML
    void reserveButtonPushed() {
        
    }
    
    @FXML
    void deleteButtonPushed() {
        for(Appliance a : applianceList.getAppList())
            if(this.id.getText().substring(1).equals(a.getId())){
                applianceList.deleteAppliance(a);
                break;
            }
        infoAlert("Törölve!", null, "Az elem törölve, kérlek, frissítsd a táblázatot!");
    }

    @FXML
    void editButtonPushed() throws IOException {
        ApplianceModel.currentId = this.id.getText().substring(1);
        MainApp.setRoot("FXMLEditAppliance");
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
