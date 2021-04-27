/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import appliances.model.Appliance;
import appliances.model.ApplianceModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author freka333
 */
public class FXMLAppliancesController implements Initializable {
    ApplianceModel model = new ApplianceModel();
    
    Appliance appliance;
    
    @FXML
    private AnchorPane adminPanel;
    
    @FXML
    private Label IDnumber;
    
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
    private Button closeButton;

    @FXML
    void closeButtonPushed() {
        nameInput.setText("");
        categoryInput.setText("");
        priceInput.setText("");
        statusInput.setText("");
        commentInput.setText("");
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/FXMLAdminPage.fxml"));
            Stage window = (Stage) closeButton.getScene().getWindow();
            window.setScene(new Scene(root));
        } catch (IOException ex) {
            Logger.getLogger(FXMLAppliancesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void errorAlert(String header, String content){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Hiba!");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void saveButtonPushed() {
        String ID = IDnumber.getText();
        String nameTxt = nameInput.getText();
        String catTxt = categoryInput.getText();
        String priceValue = priceInput.getText();
        String statusTxt = statusInput.getText();
        String commentTxt = commentInput.getText();
        if(nameTxt.isEmpty() || catTxt.isEmpty() || priceValue.isEmpty() || statusTxt.isEmpty()){
            errorAlert("Nem töltöttél ki minden mezőt!", "Kérlek, minden kötelező mezőt tölts ki mentés előtt!");
        }
        else{
            try {
                int price = Integer.parseInt(priceValue);
                appliance = new Appliance(ID, nameTxt, catTxt, price, statusTxt, commentTxt);
                ApplianceModel.appliancesList.add(appliance);
                ApplianceModel.serialisationList();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Mentve");
                alert.setHeaderText(null);
                alert.setContentText(nameTxt + " sikeresen mentve!");
                alert.showAndWait();
                closeButtonPushed();
            } catch (NumberFormatException ex) {
                errorAlert("Hibás érték!", "Az ár csak egész szám lehet!");
            }
        }
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IDnumber.setText(ApplianceModel.idGenerator());
    }
    
}
