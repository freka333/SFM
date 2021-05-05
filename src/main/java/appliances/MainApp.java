package appliances;

import static appliances.SerializationManagement.applianceDeserialisation;
import static appliances.SerializationManagement.userDeserialisation;
import appliances.model.Appliance;
import appliances.model.ApplianceModel;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        applianceDeserialisation();
        for(Appliance a : ApplianceModel.appliancesList){
            System.out.println(a);
        }
        userDeserialisation();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLLoginPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setTitle("Eszköz-Össég bejelentkezési felület");
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
