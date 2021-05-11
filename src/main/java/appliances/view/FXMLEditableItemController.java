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
    Appliance me = new Appliance();
    
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
    
    public void setData(Appliance appliance, String type){
        me = appliance;
        id.setText("#" + me.getId());
        name.setText(me.getName());
        category.setText(me.getCategory());
        status.setText(me.getStatus());
        price.setText(Integer.toString(me.getPrice()) + " Ft");
        comment.setText(me.getComment());
        if(type.equals("editable")){
            reserveButton.setVisible(false);
            editButton.setVisible(true);
            deleteButton.setVisible(true);
        }
        else if(type.equals("rent")){
            reserveButton.setVisible(true);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
        }
        else{
            reserveButton.setVisible(false);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
        }
    }
    
    @FXML
    void reserveButtonPushed() throws IOException {
        me.setRenter(userList.getActiveUser());
        applianceList.editAppliance(me);
        infoAlert("Sikeres foglalás", null, me.getName() + " eszközt sikeresen lefoglaltad!");
        pageRefresh();
    }
    
    @FXML
    void deleteButtonPushed() throws IOException {
        applianceList.deleteAppliance(me);
        infoAlert("Törölve!", null, me.getName() + " elem törölve!");
        pageRefresh();
    }

    @FXML
    void editButtonPushed() throws IOException {
        applianceList.setCurrentApp(me);
        MainApp.setRoot("FXMLEditAppliance");
    }
    
    void pageRefresh() throws IOException{
        if(userList.getActiveUser().equals("admin"))
            MainApp.setRoot("FXMLAdminPage");
        else
            MainApp.setRoot("FXMLUserPage");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
