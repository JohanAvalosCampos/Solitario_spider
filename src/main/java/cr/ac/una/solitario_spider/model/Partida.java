/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.solitario_spider.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "Partida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p"),
    @NamedQuery(name = "Partida.findByIdPartida", query = "SELECT p FROM Partida p WHERE p.idPartida = :idPartida"),
    @NamedQuery(name = "Partida.findByFechaInicio", query = "SELECT p FROM Partida p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Partida.findByFechaFin", query = "SELECT p FROM Partida p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Partida.findByDificultad", query = "SELECT p FROM Partida p WHERE p.dificultad = :dificultad"),
    @NamedQuery(name = "Partida.findByPuntuaciNFinal", query = "SELECT p FROM Partida p WHERE p.puntuaciNFinal = :puntuaciNFinal"),
    @NamedQuery(name = "Partida.findByEstado", query = "SELECT p FROM Partida p WHERE p.estado = :estado")})
public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_partida")
    private BigDecimal idPartida;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "dificultad")
    private String dificultad;
    @Column(name = "puntuaci\ufffdn_final")
    private BigInteger puntuaciNFinal;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartida", fetch = FetchType.LAZY)
    private List<CartaEnJuego> cartaEnJuegoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartida", fetch = FetchType.LAZY)
    private List<Movimiento> movimientoList;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Jugador idJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartida", fetch = FetchType.LAZY)
    private List<EstadoPartida> estadoPartidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPartida", fetch = FetchType.LAZY)
    private List<EscaleraCompletada> escaleraCompletadaList;

    public Partida() {
    }

    public Partida(BigDecimal idPartida) {
        this.idPartida = idPartida;
    }

    public Partida(BigDecimal idPartida, Date fechaInicio, String dificultad, String estado) {
        this.idPartida = idPartida;
        this.fechaInicio = fechaInicio;
        this.dificultad = dificultad;
        this.estado = estado;
    }

    public BigDecimal getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(BigDecimal idPartida) {
        this.idPartida = idPartida;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public BigInteger getPuntuaciNFinal() {
        return puntuaciNFinal;
    }

    public void setPuntuaciNFinal(BigInteger puntuaciNFinal) {
        this.puntuaciNFinal = puntuaciNFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<CartaEnJuego> getCartaEnJuegoList() {
        return cartaEnJuegoList;
    }

    public void setCartaEnJuegoList(List<CartaEnJuego> cartaEnJuegoList) {
        this.cartaEnJuegoList = cartaEnJuegoList;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    @XmlTransient
    public List<EstadoPartida> getEstadoPartidaList() {
        return estadoPartidaList;
    }

    public void setEstadoPartidaList(List<EstadoPartida> estadoPartidaList) {
        this.estadoPartidaList = estadoPartidaList;
    }

    @XmlTransient
    public List<EscaleraCompletada> getEscaleraCompletadaList() {
        return escaleraCompletadaList;
    }

    public void setEscaleraCompletadaList(List<EscaleraCompletada> escaleraCompletadaList) {
        this.escaleraCompletadaList = escaleraCompletadaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartida != null ? idPartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partida)) {
            return false;
        }
        Partida other = (Partida) object;
        if ((this.idPartida == null && other.idPartida != null) || (this.idPartida != null && !this.idPartida.equals(other.idPartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.solitario_spider.model.Partida[ idPartida=" + idPartida + " ]";
    }
    
    public boolean victory(){
     return escaleraCompletadaList != null && escaleraCompletadaList.size()>=8;
    }
}
