/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.solitario_spider.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
public class EstadoPartidaDto implements Serializable {
   private Long idEstado;
   private Date momento;
   private String estadoJson;
   private Long idPartida;
   public EstadoPartidaDto(){}
   public EstadoPartidaDto(Long idEstado,Date momento,String estadoJson,Long idPartida){
   this.idEstado = idEstado;
   this.momento = momento;
   this.estadoJson = estadoJson;
   this.idPartida = idPartida;
   
   }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public String getEstadoJson() {
        return estadoJson;
    }

    public void setEstadoJson(String estadoJson) {
        this.estadoJson = estadoJson;
    }

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
    }
}
