/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.solitario_spider.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "Puntaje Historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuntajeHistorico.findAll", query = "SELECT p FROM PuntajeHistorico p"),
    @NamedQuery(name = "PuntajeHistorico.findByIdPuntaje", query = "SELECT p FROM PuntajeHistorico p WHERE p.idPuntaje = :idPuntaje"),
    @NamedQuery(name = "PuntajeHistorico.findByPuntaje", query = "SELECT p FROM PuntajeHistorico p WHERE p.puntaje = :puntaje"),
    @NamedQuery(name = "PuntajeHistorico.findByFecha", query = "SELECT p FROM PuntajeHistorico p WHERE p.fecha = :fecha")})
public class PuntajeHistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_puntaje")
    private BigDecimal idPuntaje;
    @Basic(optional = false)
    @Column(name = "puntaje")
    private BigInteger puntaje;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Jugador idJugador;

    public PuntajeHistorico() {
    }

    public PuntajeHistorico(BigDecimal idPuntaje) {
        this.idPuntaje = idPuntaje;
    }

    public PuntajeHistorico(BigDecimal idPuntaje, BigInteger puntaje, Date fecha) {
        this.idPuntaje = idPuntaje;
        this.puntaje = puntaje;
        this.fecha = fecha;
    }

    public BigDecimal getIdPuntaje() {
        return idPuntaje;
    }

    public void setIdPuntaje(BigDecimal idPuntaje) {
        this.idPuntaje = idPuntaje;
    }

    public BigInteger getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigInteger puntaje) {
        this.puntaje = puntaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuntaje != null ? idPuntaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntajeHistorico)) {
            return false;
        }
        PuntajeHistorico other = (PuntajeHistorico) object;
        if ((this.idPuntaje == null && other.idPuntaje != null) || (this.idPuntaje != null && !this.idPuntaje.equals(other.idPuntaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.solitario_spider.model.PuntajeHistorico[ idPuntaje=" + idPuntaje + " ]";
    }
    
}
