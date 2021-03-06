/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import static appliances.Dialogs.errorAlert;
import appliances.LoginCheck;
import appliances.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
        String page = LoginCheck.loginCheck(userNameInput.getText(), passwordInput.getText());
        if(!page.equals("error")){
            MainApp.setRoot(page);
        }
        else{
            errorAlert("Hibás felhasználónév vagy jelszó!", null);
        }
    }
    
    @FXML
    void registrationButtonPushed() throws IOException {
        MainApp.setRoot("FXMLRegistrationForm");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
