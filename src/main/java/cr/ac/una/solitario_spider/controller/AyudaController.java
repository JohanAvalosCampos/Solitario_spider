/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitario_spider.controller;

import com.jfoenix.controls.JFXButton;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class AyudaController extends Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXButton btnUrl;
    @FXML
    private JFXButton btnAtras;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
         @Override
    public void initialize() {
        
    }
    @FXML
    private void onActionBtnUrl(ActionEvent event) {
       try {
            Desktop.getDesktop().browse(new URI("https://www.solitar.io/normas-detalladas-del-solitario-spider"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        } 

    @FXML
    private void onActionBtnAtras(ActionEvent event) {
        ((Stage) btnAtras.getScene().getWindow()).close();
    }
    }

   
