/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import static appliances.Dialogs.errorAlert;
import static appliances.Dialogs.infoAlert;
import appliances.MainApp;
import appliances.model.Appliance;
import appliances.model.ApplianceModel;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    void closeButtonPushed() throws Exception {
        if(MainApp.activeUser.equals("admin"))
            MainApp.setRoot("FXMLAdminPage");
        else
            MainApp.setRoot("FXMLUserPage");
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
                appliance = new Appliance(ID, MainApp.activeUser, nameTxt, catTxt, price, statusTxt, commentTxt);
                ApplianceModel.appliancesList.add(appliance);
                infoAlert("Mentve", null, nameTxt + " sikeresen mentve!");
                closeButtonPushed();
            } catch (NumberFormatException ex) {
                errorAlert("Hibás érték!", "Az ár csak egész szám lehet!");
            } catch (Exception ex) {
                Logger.getLogger(FXMLAppliancesController.class.getName()).log(Level.SEVERE, null, ex);
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
