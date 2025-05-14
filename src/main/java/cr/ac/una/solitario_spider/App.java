package cr.ac.una.solitario_spider;

import cr.ac.una.solitario_spider.util.FlowController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;




/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException, Exception{
       
        FlowController.getInstance().InitializeFlow(stage, null);
        FlowController.getInstance().goViewInWindow("Dificultad_Palos_View");
    }


    public static void main(String[] args) {
        
        launch();
    }

}