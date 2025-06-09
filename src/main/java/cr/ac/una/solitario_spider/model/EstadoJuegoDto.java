/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.solitario_spider.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class EstadoJuegoDto implements Serializable{
    private List<CartaDto>mazo;
    private List<CartaDto>descarte;
    private List<List<CartaDto>>columnas;
    private List<List<CartaDto>>escaleras;
    public EstadoJuegoDto(){}

    public List<CartaDto> getMazo() {
        return mazo;
    }

    public void setMazo(List<CartaDto> mazo) {
        this.mazo = mazo;
    }

    public List<CartaDto> getDescarte() {
        return descarte;
    }

    public void setDescarte(List<CartaDto> descarte) {
        this.descarte = descarte;
    }

    public List<List<CartaDto>> getColumnas() {
        return columnas;
    }

    public void setColumnas(List<List<CartaDto>> columnas) {
        this.columnas = columnas;
    }

    public List<List<CartaDto>> getEscaleras() {
        return escaleras;
    }

    public void setEscaleras(List<List<CartaDto>> escaleras) {
        this.escaleras = escaleras;
    }
    
}
