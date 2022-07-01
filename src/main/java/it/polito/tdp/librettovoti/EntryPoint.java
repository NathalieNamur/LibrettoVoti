package it.polito.tdp.librettovoti;

import it.polito.tdp.librettovoti.model.Libretto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	
    	//MODEL:
    	Libretto model = new Libretto();
    	
    	//LOADER e CONTROLLER:
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
    	Parent root = loader.load();
       
        FXMLController controller = loader.getController();
        
        //METODO setModel() DELLA CLASSE FXMLController:
        controller.setModel(model);
        
        
        Scene scene = new Scene(root);
        scene.getRoot().setStyle("-fx-font-family: 'Verdana'");

        stage.setTitle("Gestore Corsi");
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
