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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLRentedAppliancesController implements Initializable {

    @FXML
    private VBox itemsLayout;

    @FXML
    private Button logoutButton;
    
    @FXML
    private Button applistButton;
    
    @FXML
    private Label userLabel;
    
    @FXML
    void applistButtonPushed() throws IOException {
        MainApp.setRoot("FXMLUserPage");
    }

    @FXML
    void logoutButtonPushed() throws Exception {
        MainApp.setRoot("FXMLLoginPage");
    }
    
    public void update(){
        itemsLayout.getChildren().clear();
        for(Appliance a : applianceList.getAppList()){
            if(a.getRenter().equals(userList.getActiveUser())){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/FXMLEditableItem.fxml"));
                try {
                    Pane pane = loader.load();
                    FXMLEditableItemController item = loader.getController();
                    item.setData(a, "nothing");
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
        userLabel.setText("????" + userList.getActiveUser());
    }    
    
}
