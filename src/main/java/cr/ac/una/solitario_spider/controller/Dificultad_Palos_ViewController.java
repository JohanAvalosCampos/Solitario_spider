/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitario_spider.controller;

import cr.ac.una.solitario_spider.util.AppContext;
import cr.ac.una.solitario_spider.util.FlowController;
import java.awt.Canvas;

import static java.awt.Color.blue;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 * FXML Controller class 
 *
 * @author joshu
 */
public class Dificultad_Palos_ViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane rood;
    @FXML
    private Pane pane;
    private Button btn;
    
      
    /**
     * Initializes the controller class.
     */
    
    //Se crea una pantalla pequeña para escoger la cantidad de palos por jugar y la dificultad del juego.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Pane pane1 =new Pane();
        pane1.setId("pane1");
        pane1.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        pane1.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
        pane1.setLayoutX(-25);
        pane1.setLayoutY(45);
        pane.getChildren().add(pane1);
        
        Label  titulo1 = new Label();
        titulo1.setId("CantPalos");
        titulo1.setText("Cantidad de Palos");
        rood.getChildren().add(titulo1);
        
        Label  titulo2 = new Label();
        titulo2.setId("Dificultad");
        titulo2.setText("Dificultad");
        rood.getChildren().add(titulo2);
        
        Label  titulo3 = new Label();
        titulo3.setId("lblFondo");
        titulo3.setText("Imagen de fondo");
        rood.getChildren().add(titulo3);
        
        ImageView fondo1 = new ImageView();
        fondo1.setId("fondo1");
        fondo1.setFitHeight(30);
        fondo1.setFitWidth(30);
        Image image = new Image("/cr/ac/una/solitario_spider/resource/spiderForest.gif");
        fondo1.setImage(image);
        lupa(fondo1, image, 50, 270, rood);
        
        rood.getChildren().add(fondo1);
        
        ImageView fondo2 = new ImageView();
        fondo2.setId("fondo2");
        fondo2.setFitHeight(30);
        fondo2.setFitWidth(30);
        Image image2 = new Image("/cr/ac/una/solitario_spider/resource/starNight.gif");
        fondo2.setImage(image2);
        lupa(fondo2, image2, 50, 315,rood);
        rood.getChildren().add(fondo2);
        
        ImageView fondo3 = new ImageView();
        fondo3.setId("fondo3");
        fondo3.setFitHeight(30);
        fondo3.setFitWidth(30);
        Image image3 = new Image("/cr/ac/una/solitario_spider/resource/Hallow.gif");
        fondo3.setImage(image3);
        lupa(fondo3, image3, 50, 360, rood);
        rood.getChildren().add(fondo3);
        
        ImageView fondo4 = new ImageView();
        fondo4.setId("fondo4");
        fondo4.setFitHeight(30);
        fondo4.setFitWidth(30);
        Image image4 = new Image("/cr/ac/una/solitario_spider/resource/Montaña.gif");
        fondo4.setImage(image4);
        lupa(fondo4, image4, 125, 270, rood);
        rood.getChildren().add(fondo4);
         
        ImageView fondo5 = new ImageView();
        fondo5.setId("fondo5");
        fondo5.setFitHeight(30);
        fondo5.setFitWidth(30);
        Image image5 = new Image("/cr/ac/una/solitario_spider/resource/1.gif");
        fondo5.setImage(image5);
        lupa(fondo5, image5, 125, 315, rood);
        rood.getChildren().add(fondo5);
        
        ImageView fondo6 = new ImageView();
        fondo6.setId("fondo6");
        fondo6.setFitHeight(30);
        fondo6.setFitWidth(30);
        Image image6 = new Image("/cr/ac/una/solitario_spider/resource/EF65.gif");
        fondo6.setImage(image6);
        lupa(fondo6, image6, 125, 360, rood);
        rood.getChildren().add(fondo6);
        
        ImageView fondo7 = new ImageView();
        fondo7.setId("fondo7");
        fondo7.setFitHeight(30);
        fondo7.setFitWidth(30);
        Image image7 = new Image("/cr/ac/una/solitario_spider/resource/Desert.gif");
        fondo7.setImage(image7);
        lupa(fondo7, image7, 200, 270, rood);
        rood.getChildren().add(fondo7);
        
        ImageView fondo8 = new ImageView();
        fondo8.setId("fondo8");
        fondo8.setFitHeight(30);
        fondo8.setFitWidth(30);
        Image image8 = new Image("/cr/ac/una/solitario_spider/resource/VaporwaveBackground.gif");
        fondo8.setImage(image8);
        lupa(fondo8, image8, 200, 315, rood);
        rood.getChildren().add(fondo8);
        
        ImageView fondo9 = new ImageView();
        fondo9.setId("fondo9");
        fondo9.setFitHeight(30);
        fondo9.setFitWidth(30);
        Image image9 = new Image("/cr/ac/una/solitario_spider/resource/Telaraña.gif");
        fondo9.setImage(image9);
        lupa(fondo9, image9, 200, 360, rood);
        rood.getChildren().add(fondo9);
         
        RadioButton facil = new RadioButton();
        facil.setId("facil");
        facil.setText("Facil");
        rood.getChildren().add(facil);

        RadioButton medio = new RadioButton();
        medio.setId("medio");
        medio.setText("Medio");
        rood.getChildren().add( medio);
        
        RadioButton dificil = new RadioButton();
        dificil.setId("dificil");
        dificil.setText("Dificil");
        rood.getChildren().add(dificil);
        
        ToggleGroup grupo1 = new ToggleGroup();
        facil.setToggleGroup(grupo1);
        facil.setSelected(true);
        AppContext.getInstance().setDificultad("Facil");
        dificil.setToggleGroup(grupo1);
        medio.setToggleGroup(grupo1);
        seleccion(facil,"Facil");
        seleccion(medio,"Medio");
        seleccion(dificil,"Dificil");
        
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("1 Palo", "2 Palos", "4 Palos");
        ComboBox<String> palos = new ComboBox<>(items);
        palos.setTranslateX(50);
        palos.setTranslateY(50);
        palos.setPrefSize(187, 10);
        palos.getSelectionModel().select("1 Palo");
        AppContext.getInstance().setPalos(palos.getValue());
        rood.getChildren().add(palos);
       
        Button btnIngreso = new Button();
        btnIngreso.setText("Ingresar");
        btnIngreso.setId("botonIngreso");
        btnIngreso.setOnAction((event) -> {
            FlowController.getInstance().InitializeFlow(stage, null);
            FlowController.getInstance().goViewInWindow("JuegoView");
            ((Stage) btnIngreso.getScene().getWindow()).close();
            
        });
       
        rood.getChildren().add(btnIngreso);
        
        palos.setOnAction((event) -> {
          AppContext.getInstance().setPalos(palos.getValue());
      });
        
     }    
    
     public void seleccion(RadioButton n, String f){
         n.setOnAction((event) -> {
            //System.out.println(f);
             AppContext.getInstance().setDificultad(f);
         });
     }
         
     
        
    @Override
    public void initialize() {
        
        
        }

 

    
   
}
