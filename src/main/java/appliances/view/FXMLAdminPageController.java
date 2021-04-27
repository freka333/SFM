/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        // TODO
    }    
    
}