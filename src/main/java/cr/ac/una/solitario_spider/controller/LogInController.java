/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitario_spider.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.solitario_spider.util.FlowController;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class LogInController extends Controller implements Initializable {

    @FXML
    private JFXTextField txtNombre;
    @FXML
    private JFXButton btnJugar;
    @FXML
    private JFXButton btnTabla;
    @FXML
    private JFXButton btnRegistro;
    @FXML
    private JFXButton btnAyuda;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imvFondo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       imvFondo.fitHeightProperty().bind(root.heightProperty());
       imvFondo.fitWidthProperty().bind(root.widthProperty());
       
    }    

    @Override
    public void initialize() {
     final String NOMBRE_ARCHIVO = "zapsplat.mp3";
      File archivo = new File (NOMBRE_ARCHIVO);

        Media audio = new Media(archivo.toURI().toString());

        MediaPlayer reproductor = new MediaPlayer(audio);
        reproductor.play();   
    }

    @FXML
    private void onActionBtnayuda(ActionEvent event) {
        //FlowController.getInstance().goMain();
        FlowController.getInstance().InitializeFlow(stage, null);
        FlowController.getInstance().goViewInWindow("Ayuda");
        //((Stage) btnAyuda.getScene().getWindow()).close();
    }

    @FXML
    private void onActionBtnJugar(ActionEvent event) {
        FlowController.getInstance().InitializeFlow(stage, null);
        FlowController.getInstance().goViewInWindow("JuegoView");
        ((Stage) btnJugar.getScene().getWindow()).close();
    }

    @FXML
    private void OnActionBtnRegistro(ActionEvent event) {
       /* final String NOMBRE_ARCHIVO = "inicio.mp3";
        File archivo = new File (NOMBRE_ARCHIVO);

        Media audio = new Media(archivo.toURI().toString());

        MediaPlayer reproductor = new MediaPlayer(audio);
        reproductor.play();*/
    }
}
    

