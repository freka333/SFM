package appliances;

import static appliances.SerializationManagement.*;
import appliances.model.Appliance;
import appliances.model.ApplianceModel;
import appliances.model.User;
import static appliances.model.UserModel.userList;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {
    
    public static String activeUser;
    private static Scene scene;
    
    @Override
    public void init()throws Exception{
        applianceDeserialisation();
        for(Appliance a : ApplianceModel.appliancesList){
            System.out.println(a);
        }
        userDeserialisation();
        System.out.println("users:");
        for(User u : userList){
            System.out.println(u);
        }
    }
    
    @Override
    public void stop()throws Exception{
        applianceSerialisation();
        userSerialisation();
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("FXMLLoginPage"));
        stage.setTitle("Eszköz-Össég");        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void setRoot(String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
    }
    
    private static Parent loadFXML(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
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
