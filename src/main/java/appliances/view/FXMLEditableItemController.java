/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import appliances.model.Appliance;
import appliances.model.ApplianceModel;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLEditableItemController implements Initializable {
    
     @FXML
    private Label id;

    @FXML
    private Label name;

    @FXML
    private Label comment;

    @FXML
    private Label category;

    @FXML
    private Label status;

    @FXML
    private Label price;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;
    
    public void setData(Appliance appliance){
        id.setText("#" + appliance.getId());
        name.setText(appliance.getName());
        category.setText(appliance.getCategory());
        status.setText(appliance.getStatus());
        price.setText(Integer.toString(appliance.getPrice()) + " Ft");
        comment.setText(appliance.getComment());
    }

    @FXML
    void deleteButtonPushed() {
        for(Appliance a : appliancesList)
            if(this.id.getText().substring(1).equals(a.getId())){
                appliancesList.remove(a);
                break;
            }
        ApplianceModel.serialisationList();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Törölve!");
        alert.setHeaderText(null);
        alert.setContentText("Az elem törölve, kérlek, frissítsd a táblázatot!");
        alert.showAndWait();
    }

    @FXML
    void editButtonPushed() {

    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
