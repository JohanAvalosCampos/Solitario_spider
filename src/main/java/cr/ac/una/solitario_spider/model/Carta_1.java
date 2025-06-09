/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.solitario_spider.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "Carta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carta_1.findAll", query = "SELECT c FROM Carta_1 c"),
    @NamedQuery(name = "Carta_1.findByIdCarta", query = "SELECT c FROM Carta_1 c WHERE c.idCarta = :idCarta"),
    @NamedQuery(name = "Carta_1.findByPalo", query = "SELECT c FROM Carta_1 c WHERE c.palo = :palo"),
    @NamedQuery(name = "Carta_1.findByValor", query = "SELECT c FROM Carta_1 c WHERE c.valor = :valor")})
public class Carta_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_carta")
    private BigDecimal idCarta;
    @Basic(optional = false)
    @Column(name = "palo")
    private String palo;
    @Basic(optional = false)
    @Column(name = "valor")
    private BigInteger valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarta", fetch = FetchType.LAZY)
    private List<CartaEnJuego> cartaEnJuegoList;

    public Carta_1() {
    }

    public Carta_1(BigDecimal idCarta) {
        this.idCarta = idCarta;
    }

    public Carta_1(BigDecimal idCarta, String palo, BigInteger valor) {
        this.idCarta = idCarta;
        this.palo = palo;
        this.valor = valor;
    }

    public BigDecimal getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(BigDecimal idCarta) {
        this.idCarta = idCarta;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<CartaEnJuego> getCartaEnJuegoList() {
        return cartaEnJuegoList;
    }

    public void setCartaEnJuegoList(List<CartaEnJuego> cartaEnJuegoList) {
        this.cartaEnJuegoList = cartaEnJuegoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarta != null ? idCarta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carta_1)) {
            return false;
        }
        Carta_1 other = (Carta_1) object;
        if ((this.idCarta == null && other.idCarta != null) || (this.idCarta != null && !this.idCarta.equals(other.idCarta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.solitario_spider.model.Carta_1[ idCarta=" + idCarta + " ]";
    }
    
}
