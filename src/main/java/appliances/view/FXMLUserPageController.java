/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import appliances.MainApp;
import static appliances.MainApp.applianceList;
import static appliances.MainApp.userList;
import appliances.model.Appliance;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLUserPageController implements Initializable {

    @FXML
    private Button rentedAppsButton;

    @FXML
    private Button myAppsButton;

    @FXML
    private VBox itemsLayout;

    @FXML
    private Button logoutButton;

    @FXML
    void logoutButtonPushed() throws Exception {
        MainApp.setRoot("FXMLLoginPage");
    }

    @FXML
    void newApplianceButtonPushed() throws Exception {
        MainApp.setRoot("FXMLAppliances");
    }

    @FXML
    void rentedAppsButtonPushed() {

    }
    
    public void update(){
        itemsLayout.getChildren().clear();
        for(Appliance a : applianceList.getAppList()){
            if(a.getOwner().equals(userList.getActiveUser())){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/FXMLEditableItem.fxml"));
                try {
                    Pane pane = loader.load();
                    FXMLEditableItemController eic = loader.getController();
                    eic.setData(a);
                    itemsLayout.getChildren().add(pane);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLUserPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        update();
    }    
    
}
