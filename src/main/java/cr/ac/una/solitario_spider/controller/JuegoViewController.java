/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitario_spider.controller;

import cr.ac.una.solitario_spider.model.Carta;
import cr.ac.una.solitario_spider.model.Mazo;
import cr.ac.una.solitario_spider.model.Partida;
import cr.ac.una.solitario_spider.util.AppContext;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author 
 */
  
public class JuegoViewController extends Controller implements Initializable {

   
    @FXML
    private AnchorPane root2;
    @FXML
    private Pane Pane;
    public double s;
    private double d;
    private boolean cara;
    private Button btnMazo;
    private boolean victory =false;
    int minutos = 0,
        segundos = 0,
        horas = 0,
        msegundos=0,
        visible=0;
    VBox colu = new VBox();
    //int cantpalos=2;
    /**
     * Initializes the controller class.
     */
        
      Mazo mazo = new Mazo(AppContext.getInstance().getPalos(),AppContext.getInstance().getDificultad());
    
   // public Label LabelCrono;
    Label LabelCrono = new Label();
    Partida partida;
    public ArrayList columnas = new ArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.partida =new Partida();
        Audio("Grasswalk.mp3");
        
        ImageView Fondos =new ImageView();
        Fondos.setImage(AppContext.getInstance().getFondo());
        Fondos.fitHeightProperty().bind(Pane.heightProperty());
        Fondos.fitWidthProperty().bind(Pane.widthProperty());
        Pane.getChildren().add(Fondos);
     
        //Se crea una matriz para crear imagenes y llamar las cartas dentro de estas imagenes y posicionarlas
        VBox columna1 =new VBox();
        columna1.setId("columna1");
        columnas.add(columna1);
        
        VBox columna2 =new VBox();
        columna2.setId("columna2");
        columnas.add(columna2);
        
        VBox columna3 =new VBox();
        columna3.setId("columna3");
        columnas.add(columna3);
        
        VBox columna4 =new VBox();
        columna4.setId("columna4");
        columnas.add(columna4);
        
        VBox columna5 =new VBox();
        columna5.setId("columna5");
        columnas.add(columna5);
        
        VBox columna6 =new VBox();
        columna6.setId("columna6");
        columnas.add(columna6);
        
        VBox columna7 =new VBox();
        columna7.setId("columna7");
        columnas.add(columna7);
        
        VBox columna8 =new VBox();
        columna8.setId("columna8");
        columnas.add(columna8);
        
        VBox columna9 =new VBox();
        columna9.setId("columna9");
        columnas.add(columna9);
        
        VBox columna10 =new VBox();
        columna10.setId("columna10");
        columnas.add(columna10);
        
        Pane.getChildren().add(columna1);
        Pane.getChildren().add(columna2);
        Pane.getChildren().add(columna3);
        Pane.getChildren().add(columna4);
        Pane.getChildren().add(columna5);
        Pane.getChildren().add(columna6);
        Pane.getChildren().add(columna7);
        Pane.getChildren().add(columna8);
        Pane.getChildren().add(columna9);
        Pane.getChildren().add(columna10);
        VBox colu = new VBox();
        for(int x=0; x<10; x++)
        {
            for(int y=0; y<6; y++)
            {
                if(x>=4 && y>=5)
                {
                    break;
                }
                Carta carta0 = mazo.getCarta();
                ImageView carta1 = new ImageView();
                carta1.setImage(carta0.getImagen());
                carta1.setUserData(carta0);
                carta1.setId("carta1");
                carta1.setFitHeight(100);
                carta1.setFitWidth(70);
                if(y==0)
                {
                    colu.setMargin(carta1,new Insets(10, 0, 0, 0));   
                }
                else
                {
                    colu.setMargin(carta1,new Insets(-60, 0, 0, 0));
                }
                if(x>=4 && y==4)
                {
                     
                   
                    carta1.setImage(carta0.getImagen()); 
                    cara = true;
                }
                else
                {
                    if(y<5)
                    {
                    //se llama la espalda de la carta
                    Image imagen = new Image("/cr/ac/una/solitario_spider/resource/cartas/0-espaldadorada.png");
                    carta1.setImage(imagen);  
                     cara= false;
                    }
                    else
                    {
                    if(y==5)
                    {
                         
                         carta1.setImage(carta0.getImagen());
                         cara = true;
                    }
                    }
                }
              
                  
                  s = carta1.getTranslateX();
                  d =  carta1.getTranslateY();
                  //moverse(carta1,s,d,cara);
                Drag(carta1);
                colu = (VBox) columnas.get(x);
                colu.getChildren().add(carta1); 
                
            }
            
        }
        //Se crea una imagen que al ser tocada reparte las cartas.
        ImageView imgboton = new ImageView();
        imgboton.setId("imgboton");
        imgboton.setFitHeight(100);
        imgboton.setFitWidth(70);
        Image imgbtn = new Image("/cr/ac/una/solitario_spider/resource/prueba.png");
        imgboton.setImage(imgbtn);
       
        imgboton.setOnMouseClicked((event) -> {
        if(visible==0){
            Cronometro();
        }
        if(visible < 5){
            
            for(int y=0; y<10; y++) 
            {
                
                for(int l=1;l==1;l++)
                {
                    Carta carta0 = mazo.getCarta();
                    ImageView carta1 = new ImageView();
                    
                    carta1.setImage(carta0.getImagen());
                    carta1.setUserData(carta0);
                    carta1.setFitHeight(100);
                    carta1.setFitWidth(70); 
                    this.colu.setMargin(carta1,new Insets(-60, 0, 0, 0));
                 
                      
                    carta1.setImage(carta0.getImagen()); 
                    cara = true;
                    Drag(carta1);
                    this.colu=(VBox) columnas.get(y);
                    this.colu.getChildren().add(carta1);
                    
                   // mazo.getCarta();
                }
            }
            
            visible++;
        }
        else{
            if(visible ==5)
            {
               imgboton.setVisible(false); 
            }
        }
       imgboton.visibleProperty();
        });
        Pane.getChildren().add(imgboton);
   
        //Se crea un label que contenga el cronometro
        LabelCrono.setId("lblCrono");
        LabelCrono.setText("00:00:00");
        Pane.getChildren().add(LabelCrono);
        
        Label lblNuevaPartida = new Label();
        lblNuevaPartida.setId("lblNuevaPartida");
        lblNuevaPartida.setText("Nueva Partida");
        Pane.getChildren().add(lblNuevaPartida);
       
        ImageView imvRetroceder = new ImageView();
        imvRetroceder.setId("imvRetroceder");
        imvRetroceder.setFitHeight(40);
        imvRetroceder.setFitWidth(40);
        Image imgRetroceder = new Image("/cr/ac/una/solitario_spider/resource/agrego.png");
        imvRetroceder.setImage(imgRetroceder);
        Pane.getChildren().add(imvRetroceder);
       
       
    }
    
    @Override
    public void initialize() {
        MenuBar menuBar = new MenuBar();
        Menu OpcionesMenu = new Menu("Opciones");
        OpcionesMenu.getItems().add(new MenuItem("Guardar"));
        OpcionesMenu.getItems().add(new MenuItem("Salir"));
        OpcionesMenu.setOnAction((event) -> { 
            stage.close();
        });
        menuBar.getMenus().add(OpcionesMenu);
        Menu AyudaMenu = new Menu("Ayuda");
        menuBar.getMenus().add(AyudaMenu);
        
        Pane.getChildren().add(menuBar);
        
               // LabelCrono.setText("00:00:00:00");
        
    }
     
    
    //Se crea un metodo de cronometro para llevar el tiempo del juego.
     public void Cronometro( ) {
        Thread t1 = new Thread(() -> { 
            Audio("Cronometro.mp3");
            for(horas=0;horas<24;horas++)
            {
                for(minutos=0;minutos<60;minutos++)
                {
                    for(segundos=0;segundos<60;segundos++)
                    {
                        System.out.println(horas+":"+minutos+":"+segundos);
                        for(msegundos=0;msegundos<60;msegundos++)
                        {
                            Platform.runLater(new Runnable() { 
                               @Override 
                               public void run() {
                                   if(horas<=9 && minutos<=9 && segundos<=9){
                                       LabelCrono.setText("0"+horas+":"+"0"+ minutos+":"+"0"+segundos+":"+msegundos); 
                                   }
                                    else{ 
                                       if(horas<=9 && minutos<=9 && segundos>9){
                                            LabelCrono.setText("0"+horas+":"+"0"+minutos+":"+segundos+":"+msegundos);
                                        }
                                        else{
                                           if(horas<=9 && minutos>9 && segundos<=9){
                                                LabelCrono.setText("0"+horas+":"+minutos+":"+"0"+segundos+":"+msegundos);
                                            }
                                           else{
                                                if(horas<=9 && minutos>9 && segundos>9){
                                                     LabelCrono.setText("0"+horas+":"+minutos+":"+segundos+":"+msegundos);
                                                 }
                                                else{
                                                    if(horas>9 && minutos>9 && segundos>9){
                                                        LabelCrono.setText(horas+":"+ minutos+":"+segundos+":"+msegundos);
                                                    }
                                                    else{ 
                                                        if(horas>9 && minutos<=9 && segundos<=9){
                                                            LabelCrono.setText(horas+":"+"0"+minutos+":"+"0"+segundos+":"+msegundos);
                                                        }
                                                        else{
                                                            if(horas>9 && minutos<=9 && segundos>9){
                                                                LabelCrono.setText(horas+":"+"0"+minutos+":"+segundos+":"+msegundos);
                                                            }
                                                            else{
                                                                if(horas>9 && minutos>9 && segundos<=9){
                                                                    LabelCrono.setText(horas+":"+minutos+":"+"0"+segundos+":"+msegundos);
                                                                }
                                                                
                                                                
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                       }
                                    } 
                               }
                            });
                            try{
                            Thread.sleep(1);                            
                            }catch(InterruptedException e){
                            }
                        }
                        try{
                            Thread.sleep(1000);                            
                        }catch(InterruptedException e){
                        }
                        
                    }
                }
            }
        });
        t1.start();
    }
    
}

  
   
    

 
    

    
  

   

   

   

  

    

    



  
    
   





  

   

 

   
 

  



  

  

   

  


   
    

   

