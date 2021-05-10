/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import static appliances.Dialogs.*;
import appliances.MainApp;
import static appliances.MainApp.userList;
import appliances.model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLRegistrationFormController implements Initializable {
     @FXML
    private TextField userNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registrationButton;

    @FXML
    private Button cancelButton;

    @FXML
    void cancelButtonPushed() throws IOException {
        MainApp.setRoot("FXMLLoginPage");
    }

    @FXML
    void registrationButtonPushed() throws IOException {
        User newUser = new User(userNameField.getText(), passwordField.getText());
        if(userList.getUserList().contains(newUser)){
            errorAlert("Ez a felhasználó már létezik!", "Adj meg másik felhasználónevet, vagy jelentkezz be!");
        }
        else{
            userList.addUser(newUser);
            infoAlert("Mentve", "Sikeres regisztráció!", "A megadott felhasználónevet és jelszót elmentettük, jelentkezz be az alkalmazás használatához!");
            cancelButtonPushed();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
