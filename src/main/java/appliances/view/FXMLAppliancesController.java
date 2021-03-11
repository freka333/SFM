/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appliances.view;

import appliances.model.Appliance;
import com.sun.tools.javac.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    Appliance appliance;

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
    private  TextField IDnumber;
    
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
        IDnumber.setText("");
        nameInput.setText("");
        categoryInput.setText("");
        priceInput.setText("");
        statusInput.setText("");
        commentInput.setText("");
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
        String ID = IDnumber.getText();
        String nameTxt = nameInput.getText();
        String catTxt = categoryInput.getText();
        String priceValue = priceInput.getText();
        String statusTxt = statusInput.getText();
        if(ID.isEmpty() || nameTxt.isEmpty() || catTxt.isEmpty() || priceValue.isEmpty() || statusTxt.isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Hiba!");
            alert.setHeaderText("Nem töltöttél ki minden mezőt!");
            alert.setContentText("Kérlek, minden kötelező mezőt tölts ki mentés előtt!");
            alert.showAndWait();
        }
        else{
            boolean exist = false;
            try (Scanner fscID = new Scanner(new File("files/ids.txt"));) {
                fscID.useDelimiter(";");
                while(fscID.hasNext()){
                    String currentID = fscID.next();
                    if(ID.equals(currentID)){
                        exist = true;
                        break;
                    }
                }
                
                if(!exist){
                    try {
                        int price = Integer.parseInt(priceValue);
                        appliance = new Appliance(nameTxt, catTxt, price, statusTxt);
                        if(!commentInput.getText().isEmpty())
                            appliance.setComment(commentInput.getText());
                        serialisation(ID, appliance);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Mentve");
                        alert.setHeaderText(null);
                        alert.setContentText("Sikeres mentés!");
                        alert.showAndWait();
                    } catch (NumberFormatException ex) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Hiba!");
                        alert.setHeaderText("Hibás érték!");
                        alert.setContentText("Az ár csak egész szám lehet!");
                        alert.showAndWait();
                    }
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Hiba!");
                    alert.setHeaderText(null);
                    alert.setContentText("Már létezik eszköz ezzel az ID-val!");
                    alert.showAndWait();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLAppliancesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void serialisation(String ID, Appliance a){
        String fileName = "files/" + ID + ".ser";
        
        try (FileOutputStream fs = new FileOutputStream(fileName);
             ObjectOutputStream os = new ObjectOutputStream(fs);) {
            os.writeObject(a);
        } catch (IOException ex){
            Logger.getLogger(FXMLAppliancesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (FileWriter ids = new FileWriter("files/ids.txt", true);){
            ids.write(ID + ";");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAppliancesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //deserialisation(fileName);
    }

    public void deserialisation(String fileName){
        Appliance a2 = null;
        try (FileInputStream fs = new FileInputStream(fileName);
             ObjectInputStream os = new ObjectInputStream(fs);) {
            a2 = (Appliance)os.readObject();
        } catch (IOException | ClassNotFoundException ex){
            Logger.getLogger(FXMLAppliancesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Appliance: " + a2.toString());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
