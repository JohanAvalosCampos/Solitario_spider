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
@Table(name = "Jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
    @NamedQuery(name = "Jugador.findByIdJugador", query = "SELECT j FROM Jugador j WHERE j.idJugador = :idJugador"),
    @NamedQuery(name = "Jugador.findByNombreUsuario", query = "SELECT j FROM Jugador j WHERE j.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Jugador.findByImagenFondo", query = "SELECT j FROM Jugador j WHERE j.imagenFondo = :imagenFondo"),
    @NamedQuery(name = "Jugador.findByTemaCartas", query = "SELECT j FROM Jugador j WHERE j.temaCartas = :temaCartas"),
    @NamedQuery(name = "Jugador.findByPartidasGanadas", query = "SELECT j FROM Jugador j WHERE j.partidasGanadas = :partidasGanadas"),
    @NamedQuery(name = "Jugador.findByFechaRegistro", query = "SELECT j FROM Jugador j WHERE j.fechaRegistro = :fechaRegistro")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_jugador")
    private BigDecimal idJugador;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "imagen_fondo")
    private String imagenFondo;
    @Column(name = "tema_cartas")
    private String temaCartas;
    @Basic(optional = false)
    @Column(name = "partidas_ganadas")
    private BigInteger partidasGanadas;
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.LAZY)
    private List<Partida> partidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.LAZY)
    private List<PuntajeHistorico> puntajeHistoricoList;

    public Jugador() {
    }

    public Jugador(BigDecimal idJugador) {
        this.idJugador = idJugador;
    }

    public Jugador(BigDecimal idJugador, String nombreUsuario, BigInteger partidasGanadas, Date fechaRegistro) {
        this.idJugador = idJugador;
        this.nombreUsuario = nombreUsuario;
        this.partidasGanadas = partidasGanadas;
        this.fechaRegistro = fechaRegistro;
    }

    public BigDecimal getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(BigDecimal idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getImagenFondo() {
        return imagenFondo;
    }

    public void setImagenFondo(String imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

    public String getTemaCartas() {
        return temaCartas;
    }

    public void setTemaCartas(String temaCartas) {
        this.temaCartas = temaCartas;
    }

    public BigInteger getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(BigInteger partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {
        this.partidaList = partidaList;
    }

    @XmlTransient
    public List<PuntajeHistorico> getPuntajeHistoricoList() {
        return puntajeHistoricoList;
    }

    public void setPuntajeHistoricoList(List<PuntajeHistorico> puntajeHistoricoList) {
        this.puntajeHistoricoList = puntajeHistoricoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJugador != null ? idJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.idJugador == null && other.idJugador != null) || (this.idJugador != null && !this.idJugador.equals(other.idJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.solitario_spider.model.Jugador[ idJugador=" + idJugador + " ]";
    }
    
}
