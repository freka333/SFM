/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLAppliancesController implements Initializable {

    @FXML
    private AnchorPane homePagePanel;

    @FXML
    private Button adminButton;

    @FXML
    private Button clientButton;
    
    @FXML
    private AnchorPane adminPanel;
    
    @FXML
    private TabPane clientPanel;
    
    @FXML
    private TextField nameInput;

    @FXML
    private TextField categoryInput;

    @FXML
    private TextField priceInput;

    @FXML
    private TextField statusInput;

    @FXML
    private TextField commentInput;

    @FXML
    void adminButtonPushed() {
        homePagePanel.setVisible(false);
        adminPanel.setVisible(true);
    }

    @FXML
    void clientButtonPushed() {
        homePagePanel.setVisible(false);
        clientPanel.setVisible(true);
    }

    @FXML
    void closeButtonPushed() {
        adminPanel.setVisible(false);
        homePagePanel.setVisible(true);
    }

    @FXML
    void exitButtonPushed() {
        clientPanel.setVisible(false);
        homePagePanel.setVisible(true);
    }

    @FXML
    void saveButtonPushed() {

    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
