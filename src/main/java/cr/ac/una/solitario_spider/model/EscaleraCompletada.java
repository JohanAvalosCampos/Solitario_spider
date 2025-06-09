/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.solitario_spider.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Escalera_Completada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscaleraCompletada.findAll", query = "SELECT e FROM EscaleraCompletada e"),
    @NamedQuery(name = "EscaleraCompletada.findByIdEscalera", query = "SELECT e FROM EscaleraCompletada e WHERE e.idEscalera = :idEscalera"),
    @NamedQuery(name = "EscaleraCompletada.findByPalo", query = "SELECT e FROM EscaleraCompletada e WHERE e.palo = :palo"),
    @NamedQuery(name = "EscaleraCompletada.findByFecha", query = "SELECT e FROM EscaleraCompletada e WHERE e.fecha = :fecha")})
public class EscaleraCompletada implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_escalera")
    private BigDecimal idEscalera;
    @Basic(optional = false)
    @Column(name = "palo")
    private String palo;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_partida", referencedColumnName = "id_partida")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Partida idPartida;

    public EscaleraCompletada() {
    }

    public EscaleraCompletada(BigDecimal idEscalera) {
        this.idEscalera = idEscalera;
    }

    public EscaleraCompletada(BigDecimal idEscalera, String palo) {
        this.idEscalera = idEscalera;
        this.palo = palo;
    }

    public BigDecimal getIdEscalera() {
        return idEscalera;
    }

    public void setIdEscalera(BigDecimal idEscalera) {
        this.idEscalera = idEscalera;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idEscalera != null ? idEscalera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscaleraCompletada)) {
            return false;
        }
        EscaleraCompletada other = (EscaleraCompletada) object;
        if ((this.idEscalera == null && other.idEscalera != null) || (this.idEscalera != null && !this.idEscalera.equals(other.idEscalera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.solitario_spider.model.EscaleraCompletada[ idEscalera=" + idEscalera + " ]";
    }
    
}
