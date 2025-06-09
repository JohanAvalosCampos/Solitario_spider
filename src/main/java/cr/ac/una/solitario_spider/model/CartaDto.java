/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.solitario_spider.model;
import java.io.Serializable;
/**
 *
 * @author USUARIO
 */
public class CartaDto implements Serializable {
   private static final long serialVersionUID =1L;
   private int numero;
   private String simbolo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBocaArriba() {
        return bocaArriba;
    }

    public void setBocaArriba(boolean bocaArriba) {
        this.bocaArriba = bocaArriba;
    }
   private String color;
   private boolean bocaArriba;
   public CartaDto(Integer numero, String simbolo, String color, boolean bocaArriba) {
        this.numero = numero;
        this.simbolo = simbolo;
        this.color = color;
        this.bocaArriba = bocaArriba;
    }

    // Constructor auxiliar para convertir desde una Carta del juego
    public CartaDto(Carta carta) {
        this.numero = carta.getNumero();
        this.simbolo = carta.getSimbolo();
        this.color = carta.getColor();
        this.bocaArriba = carta.isBocaArriba();
    }

    // Método para convertir de vuelta a una Carta del juego
    public Carta toCarta() {
        return new Carta(numero, simbolo, color, bocaArriba);
    }
}
