/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import appliances.model.Appliance;
import static appliances.model.ApplianceModel.appliancesList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author freka333
 */
public class FXMLAdminPageController implements Initializable {
    
    @FXML
    private Button newApplianceButton;
    
    @FXML
    private Button logoutButton;
    
    @FXML
    private VBox itemsLayout;
    
    @FXML
    void newApplianceButtonPushed() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLAppliances.fxml"));
        Stage window = (Stage) newApplianceButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    @FXML
    void logoutButtonPushed() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLLoginPage.fxml"));
        Stage window = (Stage) logoutButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Appliance a : appliancesList){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/FXMLEditableItem.fxml"));
            
            try {
                Pane pane = loader.load();
                FXMLEditableItemController eic = loader.getController();
                eic.setData(a);
                itemsLayout.getChildren().add(pane);
            } catch (IOException ex) {
                Logger.getLogger(FXMLAdminPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
