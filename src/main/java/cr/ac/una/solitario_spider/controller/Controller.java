package cr.ac.una.solitario_spider.controller;

import cr.ac.una.solitario_spider.model.Carta;
import cr.ac.una.solitario_spider.model.Partida;
import cr.ac.una.solitario_spider.util.AppContext;
import cr.ac.una.solitario_spider.util.Mensaje;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public abstract class Controller {

    public String Dificultad, CantPalos = "";

    public String getDificultad() {
        return Dificultad;
    }

    public void setDificultad(String Dificultad) {
        this.Dificultad = Dificultad;
    }

    public String getCantPalos() {
        return CantPalos;
    }

    public void setCantPalos(String CantPalos) {
        this.CantPalos = CantPalos;
    }

    Stage stage;
    private String accion;

    public String getAccion() {
        return accion;
    }
    
    private Partida partida;
    public void setPartida(Partida partida){
    this.partida = partida;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public void sendTabEvent(KeyEvent event) {
        event.consume();
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.TAB, false, false, false, false);
        ((Control) event.getSource()).fireEvent(keyEvent);
    }

    public void Audio(String tono) {
        File archivo = new File(tono);
        Media audio = new Media(archivo.toURI().toString());
        MediaPlayer reproductor = new MediaPlayer(audio);
        reproductor.play();
    }

    public void moverse(ImageView ima, double x, double y, boolean mover) {
        if (mover) {
            ima.setOnMouseDragged((MouseEvent event) -> {
                Node actual = (Node) event.getSource();
                actual.setLayoutX(event.getSceneX() - (x + 25));
                actual.setLayoutY(event.getSceneY() - (y + 50));
            });
        }
    }

    public void Drag(ImageView ima) {
        Image img = ima.getImage();

        ima.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = ima.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putImage(img);
                db.setContent(content);
                db.setDragView(img); // Usamos la imagen directamente
                event.consume();
            }
        });

        ima.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getDragboard().hasImage()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });

        ima.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasImage()) {
                    ImageView origenView = (ImageView) event.getGestureSource();
                    VBox pilaOrigen = (VBox) origenView.getParent();
                    VBox pilaDestino =(VBox) ((ImageView) event.getSource()).getParent();
                    int idxArrastrada = pilaOrigen.getChildren().indexOf(origenView);
                    if (!movimientoMultiCarta(pilaOrigen, idxArrastrada)) {
                      event.setDropCompleted(false);
                      return;
                    }
                  
                    ImageView cabezaView = (ImageView) pilaOrigen.getChildren().get(idxArrastrada);
                    Carta cabezaCarta =(Carta) cabezaView.getUserData();
                    
                    ObservableList<Node> hijosDest= pilaDestino.getChildren();
                    if (hijosDest.isEmpty()){
                       if(cabezaCarta.getNumero() != 13){
                       event.setDropCompleted(false);
                       return;
                       }
                       
                    } else {
                     ImageView ultView =(ImageView) hijosDest.get(hijosDest.size()-1);
                     Carta ultCarta = (Carta) ultView.getUserData();
                     if(!movimiento1Carta(cabezaCarta,ultCarta)){
                       event.setDropCompleted(false);
                       return;
                     }
                    }
                  List<Node> toMove = new ArrayList<>(pilaOrigen.getChildren().subList(idxArrastrada,pilaOrigen.getChildren().size()));
                  pilaOrigen.getChildren().removeAll(toMove);
                  pilaDestino.getChildren().addAll(toMove);
                  event.setDropCompleted(true);
                  
                  if(!pilaOrigen.getChildren().isEmpty()){
                    ImageView ult=(ImageView)pilaOrigen.getChildren().get(pilaOrigen.getChildren().size()-1);
                    Carta cartUlt= (Carta)ult.getUserData();
                    if(cartUlt.isBocaArriba()){
                      cartUlt.setBocaArriba(true);
                      ult.setImage(cartUlt.getImagen());
                    }
                  }
                  else{
                  event.setDropCompleted(success);
                   
                }
                if(partida.victory())
                        new Mensaje().showModal(Alert.AlertType.INFORMATION, "VICTORIA", getStage(), "HAS GANADO");
                  }
                event.consume();   
            }

     private boolean movimientoMultiCarta(VBox pila, int idx){
      ObservableList<Node> hijos =pila.getChildren();
         for (int i = idx; i<hijos.size()-1;i++){
         ImageView actual= (ImageView) hijos.get(i);
         ImageView siguiente= (ImageView) hijos.get(i+1);
     
         Carta cartaActual = (Carta) actual.getUserData();
         Carta cartaSiguiente = (Carta) siguiente.getUserData();
    
         if (!(cartaActual.getSimbolo().equals(cartaSiguiente.getSimbolo())&& cartaActual.getNumero() == cartaSiguiente.getNumero()+1 && cartaActual.isBocaArriba() && cartaSiguiente.isBocaArriba())){
           return false;
         }  
        } 
     return true;
    }
        });
    }
    private boolean movimiento1Carta(Carta arrastrada, Carta destino){
     if (!arrastrada.isBocaArriba()||!destino.isBocaArriba()){
     return false;
     }
     int numA = arrastrada.getNumero();
     int numD = destino.getNumero();
     if (arrastrada.getSimbolo().equals(destino.getSimbolo())){
      return numA==numD - 1;
     }
     return false;
    }
    public void lupa(ImageView Fondo, Image image, int x, int y, AnchorPane rood) {
        ImageView fondo = new ImageView();
        Fondo.setOnMouseMoved((event) -> {
            fondo.setVisible(true);
            fondo.setImage(image);
            fondo.setTranslateX(x - 25);
            fondo.setTranslateY(y - 40);
            fondo.setFitHeight(90);
            fondo.setFitWidth(90);
            if (!rood.getChildren().contains(fondo)) {
                rood.getChildren().add(fondo);
            }
        });

        fondo.setOnMouseClicked((event) -> {
            AppContext.getInstance().setFondo(image);
            System.out.println("Fondo seleccionado.");
        });

        fondo.setOnMouseExited((event) -> {
            fondo.setVisible(false);
        });
    }

    public abstract void initialize();
}
