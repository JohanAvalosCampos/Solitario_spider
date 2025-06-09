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
@Table(name = "Movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m"),
    @NamedQuery(name = "Movimiento.findByIdMovimiento", query = "SELECT m FROM Movimiento m WHERE m.idMovimiento = :idMovimiento"),
    @NamedQuery(name = "Movimiento.findByTipoMovimiento", query = "SELECT m FROM Movimiento m WHERE m.tipoMovimiento = :tipoMovimiento"),
    @NamedQuery(name = "Movimiento.findByMomento", query = "SELECT m FROM Movimiento m WHERE m.momento = :momento")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id _movimiento")
    private BigDecimal idMovimiento;
    @Basic(optional = false)
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    @Lob
    @Column(name = "detalle")
    private Serializable detalle;
    @Basic(optional = false)
    @Column(name = "momento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date momento;
    @JoinColumn(name = "id_partida", referencedColumnName = "id_partida")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Partida idPartida;

    public Movimiento() {
    }

    public Movimiento(BigDecimal idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Movimiento(BigDecimal idMovimiento, String tipoMovimiento, Date momento) {
        this.idMovimiento = idMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.momento = momento;
    }

    public BigDecimal getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(BigDecimal idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Serializable getDetalle() {
        return detalle;
    }

    public void setDetalle(Serializable detalle) {
        this.detalle = detalle;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
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
        hash += (idMovimiento != null ? idMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.idMovimiento == null && other.idMovimiento != null) || (this.idMovimiento != null && !this.idMovimiento.equals(other.idMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.solitario_spider.model.Movimiento[ idMovimiento=" + idMovimiento + " ]";
    }
    
}
