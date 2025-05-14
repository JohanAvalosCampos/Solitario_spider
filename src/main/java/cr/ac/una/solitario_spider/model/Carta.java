/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitario_spider.model;

import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


public class Carta 
{
    private Image imagen;
    private Integer numero;
    private String simbolo;
    private String color;
    private boolean mover;
    

    

  

    public Carta(String imagen, Integer numero, String simbolo, String color, boolean mover)
    {
        this.imagen = new Image(imagen);
        this.numero = numero;
        this.simbolo = simbolo;
        this.color = color;
        this.mover = mover;
    }

    public Image getImagen() 
    {
        return imagen;
    }

    public void setImagen(Image imagen) 
    {
        this.imagen = imagen;
    }

    public Integer getNumero() 
    {
        return numero;
    }

    public void setNumero(Integer numero)
    {
        this.numero = numero;
    }

    public String getSimbolo() 
    {
        return simbolo;
    }

    public void setSimbolo(String simbolo)
    {
        this.simbolo = simbolo;
    }

    public String getColor() 
    {
        return color;
    }

    public void setColor(String color) 
    {
        this.color = color;
    }
      public boolean isMover() 
      {
        return mover;
    }

    public void setMover(boolean mover)
    {
        this.mover = mover;
    }
    
   
}
