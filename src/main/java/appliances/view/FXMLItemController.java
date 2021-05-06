/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import appliances.model.Appliance;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLItemController implements Initializable {
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
    private Button reserveButton;

    @FXML
    void reserveButtonPushed() {

    }
    
    public void setData(Appliance appliance){
        id.setText("#" + appliance.getId());
        name.setText(appliance.getName());
        category.setText(appliance.getCategory());
        status.setText(appliance.getStatus());
        price.setText(Integer.toString(appliance.getPrice()) + " Ft");
        comment.setText(appliance.getComment());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
