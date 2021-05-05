/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import appliances.LoginCheck;
import appliances.model.Appliance;
import appliances.model.ApplianceModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author freka333
 */
public class FXMLLoginPageController implements Initializable {
    
    @FXML
    private TextField userNameInput;

    @FXML
    private PasswordField passwordInput;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Button registrationButton;
    
    @FXML
    void loginButtonPushed() throws Exception {
        String userType = LoginCheck.loginCheck(userNameInput.getText(), passwordInput.getText());
        if(userType.equals("admin")){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLAdminPage.fxml"));
            Stage window = (Stage) loginButton.getScene().getWindow();
            window.setTitle("Admin felület");
            window.setScene(new Scene(root));
        }
        else if(userType.equals("ok")){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLUserPage.fxml"));
            Stage window = (Stage) loginButton.getScene().getWindow();
            window.setTitle("Felhasználói felület");
            window.setScene(new Scene(root));
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba!");
            alert.setHeaderText("Hibás felhasználónév vagy jelszó!");
            alert.showAndWait();
        }
    }
    
    @FXML
    void registrationButtonPushed() {
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
