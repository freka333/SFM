/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import static appliances.Dialogs.*;
import appliances.MainApp;
import static appliances.MainApp.applianceList;
import static appliances.MainApp.userList;
import appliances.model.Appliance;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author freka333
 */
public class FXMLEditableItemController implements Initializable {
    Appliance thisApp = new Appliance();
    
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
    
    @FXML
    private Button reserveButton;
    
    @FXML
    private Button rentedButton;
    
    public void setData(Appliance appliance, String type){
        thisApp = appliance;
        id.setText("#" + thisApp.getId());
        name.setText(thisApp.getName());
        category.setText(thisApp.getCategory());
        status.setText(thisApp.getStatus());
        price.setText(Integer.toString(thisApp.getPrice()) + " Ft");
        comment.setText(thisApp.getComment());
        if(type.equals("editable")){
            reserveButton.setVisible(false);
            editButton.setVisible(true);
            deleteButton.setVisible(true);
            rentedButton.setVisible(false);
        }
        else if(type.equals("rent")){
            reserveButton.setVisible(true);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            rentedButton.setVisible(false);
        }
        else{
            reserveButton.setVisible(false);
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            rentedButton.setVisible(true);
        }
    }
    
    @FXML
    void reserveButtonPushed() throws IOException {
        thisApp.setRenter(userList.getActiveUser());
        thisApp.setStatus("foglalva");
        applianceList.editAppliance(thisApp);
        infoAlert("Sikeres foglalás", null, thisApp.getName() + " eszközt sikeresen lefoglaltad!");
        pageRefresh();
    }
    
    @FXML
    void deleteButtonPushed() throws IOException {
        if(optionalALert("Törlés", null, thisApp.getName() + " eszközt biztosan törölni szeretnéd?")){
            applianceList.deleteAppliance(thisApp);
            infoAlert("Törölve!", null, thisApp.getName() + " elem törölve!");
            pageRefresh();
        }
    }

    @FXML
    void editButtonPushed() throws IOException {
        applianceList.setCurrentApp(thisApp);
        MainApp.setRoot("FXMLEditAppliance");
    }
    
     @FXML
    void rentedButtonPushed() throws IOException {
        if(userList.getActiveUser().equals("admin") || userList.getActiveUser().equals(thisApp.getOwner())) {
            infoAlert("Bérelt eszöz", null, "Ezt az eszközt jelenleg " + thisApp.getRenter() + " bérli.");
        }
        else
            if(optionalALert("Bérlés visszavonása", null, "Biztos vagy benne, hogy vissza akarod mondani a bérlést?")){
                thisApp.setRenter("");
                thisApp.setStatus("bérelhető");
                applianceList.editAppliance(thisApp);
                infoAlert("Sikeres lemondás", null, thisApp.getName() + " eszköz bérlését sikeresen visszamondtad!");
                pageRefresh();
            }
    }
    
    void pageRefresh() throws IOException{
        if(userList.getActiveUser().equals("admin"))
            MainApp.setRoot("FXMLAdminPage");
        else
            MainApp.setRoot("FXMLUserPage");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
