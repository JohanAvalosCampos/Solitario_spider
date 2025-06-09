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
import javax.persistence.Lob;
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
@Table(name = "Estado Partida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPartida.findAll", query = "SELECT e FROM EstadoPartida e"),
    @NamedQuery(name = "EstadoPartida.findByIdEstado", query = "SELECT e FROM EstadoPartida e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "EstadoPartida.findByMomento", query = "SELECT e FROM EstadoPartida e WHERE e.momento = :momento")})
public class EstadoPartida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_estado")
    private BigDecimal idEstado;
    @Basic(optional = false)
    @Column(name = "momento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date momento;
    @Basic(optional = false)
    @Lob
    @Column(name = "estado_json")
    private Serializable estadoJson;
    @JoinColumn(name = "id_partida", referencedColumnName = "id_partida")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Partida idPartida;

    public EstadoPartida() {
    }

    public EstadoPartida(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoPartida(BigDecimal idEstado, Date momento, Serializable estadoJson) {
        this.idEstado = idEstado;
        this.momento = momento;
        this.estadoJson = estadoJson;
    }

    public BigDecimal getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public Serializable getEstadoJson() {
        return estadoJson;
    }

    public void setEstadoJson(Serializable estadoJson) {
        this.estadoJson = estadoJson;
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
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPartida)) {
            return false;
        }
        EstadoPartida other = (EstadoPartida) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.solitario_spider.model.EstadoPartida[ idEstado=" + idEstado + " ]";
    }
    
}
