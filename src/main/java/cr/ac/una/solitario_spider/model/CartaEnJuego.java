/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.solitario_spider.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "Carta_En_Juego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartaEnJuego.findAll", query = "SELECT c FROM CartaEnJuego c"),
    @NamedQuery(name = "CartaEnJuego.findByIdCartaEnJuego", query = "SELECT c FROM CartaEnJuego c WHERE c.idCartaEnJuego = :idCartaEnJuego"),
    @NamedQuery(name = "CartaEnJuego.findByZona", query = "SELECT c FROM CartaEnJuego c WHERE c.zona = :zona"),
    @NamedQuery(name = "CartaEnJuego.findByVisible", query = "SELECT c FROM CartaEnJuego c WHERE c.visible = :visible"),
    @NamedQuery(name = "CartaEnJuego.findByColumna", query = "SELECT c FROM CartaEnJuego c WHERE c.columna = :columna"),
    @NamedQuery(name = "CartaEnJuego.findByPosicionEnColumna", query = "SELECT c FROM CartaEnJuego c WHERE c.posicionEnColumna = :posicionEnColumna")})
public class CartaEnJuego implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_carta_en_juego")
    private BigDecimal idCartaEnJuego;
    @Basic(optional = false)
    @Column(name = "zona")
    private String zona;
    @Basic(optional = false)
    @Column(name = "visible")
    private BigInteger visible;
    @Column(name = "columna")
    private BigInteger columna;
    @Column(name = "posicion_en_columna")
    private BigInteger posicionEnColumna;
    @JoinColumn(name = "id_carta", referencedColumnName = "id_carta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Carta_1 idCarta;
    @JoinColumn(name = "id_partida", referencedColumnName = "id_partida")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Partida idPartida;

    public CartaEnJuego() {
    }

    public CartaEnJuego(BigDecimal idCartaEnJuego) {
        this.idCartaEnJuego = idCartaEnJuego;
    }

    public CartaEnJuego(BigDecimal idCartaEnJuego, String zona, BigInteger visible) {
        this.idCartaEnJuego = idCartaEnJuego;
        this.zona = zona;
        this.visible = visible;
    }

    public BigDecimal getIdCartaEnJuego() {
        return idCartaEnJuego;
    }

    public void setIdCartaEnJuego(BigDecimal idCartaEnJuego) {
        this.idCartaEnJuego = idCartaEnJuego;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public BigInteger getVisible() {
        return visible;
    }

    public void setVisible(BigInteger visible) {
        this.visible = visible;
    }

    public BigInteger getColumna() {
        return columna;
    }

    public void setColumna(BigInteger columna) {
        this.columna = columna;
    }

    public BigInteger getPosicionEnColumna() {
        return posicionEnColumna;
    }

    public void setPosicionEnColumna(BigInteger posicionEnColumna) {
        this.posicionEnColumna = posicionEnColumna;
    }

    public Carta_1 getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Carta_1 idCarta) {
        this.idCarta = idCarta;
    }

    public Partida getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Partida idPartida) {
        this.idPartida = idPartida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCartaEnJuego != null ? idCartaEnJuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartaEnJuego)) {
            return false;
        }
        CartaEnJuego other = (CartaEnJuego) object;
        if ((this.idCartaEnJuego == null && other.idCartaEnJuego != null) || (this.idCartaEnJuego != null && !this.idCartaEnJuego.equals(other.idCartaEnJuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.solitario_spider.model.CartaEnJuego[ idCartaEnJuego=" + idCartaEnJuego + " ]";
    }
    
}
