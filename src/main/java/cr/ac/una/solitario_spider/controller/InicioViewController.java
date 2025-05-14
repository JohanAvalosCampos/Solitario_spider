/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitario_spider.controller;

import cr.ac.una.solitario_spider.util.FlowController;
import java.io.File;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
//import sun.tools.jar.Main;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class InicioViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ProgressBar pbCarga;
    @FXML
    private ImageView imvFondo;
    double Contador=0.1;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        //imvFondo.fitHeightProperty().bind(root.heightProperty());
       //imvFondo.fitWidthProperty().bind(root.widthProperty());
       System.out.println("Hola Mundo");
          
     
    }    

    @Override
    public void initialize() {
        
        System.out.println("Hola dos");
        Thread t1 = new Thread(() -> { //definicion del thread
            final String NOMBRE_ARCHIVO = "Inicio.mp3";
                File archivo = new File (NOMBRE_ARCHIVO);

                Media audio = new Media(archivo.toURI().toString());

                MediaPlayer reproductor = new MediaPlayer(audio);
                reproductor.play();
                reproductor.setVolume(0.7);
            synchronized(this){  //sincronizacion entre los hilos (t1 y t2)
                
                while(Contador < 1){
                    Platform.runLater(new Runnable() { 
                           @Override 
                           public void run() {
                                   pbCarga.setProgress(Contador); 
                            }    
                    });
                     try {
                        Thread.sleep(100);
                        Contador+=0.01;
                    } catch (InterruptedException e) {}
                    System.out.println(Contador);

                }
                notify();  //envia la notificacion de finalizacion 
            }
        });
        t1.start();
        
        Thread t2 = new Thread(() -> {
            synchronized(t1){
                try{
                    t1.wait(); //espera la notificacion 
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                Platform.runLater(new Runnable() {
                 @Override public void run() {
                    stage.close();
                    FlowController.getInstance().InitializeFlow(stage, null);
                    FlowController.getInstance().goViewInWindow("LogIn");
                 }
                });
            } 
        });
        t2.start();
    }
}
