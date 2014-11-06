/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.genesis.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author orlando
 */
@Entity
@Table(name = "ALMACENDETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacendeta.findAll", query = "SELECT a FROM Almacendeta a"),
    @NamedQuery(name = "Almacendeta.findByIdalmdeta", query = "SELECT a FROM Almacendeta a WHERE a.almacendetaPK.idalmdeta = :idalmdeta"),
    @NamedQuery(name = "Almacendeta.findByCodprdto", query = "SELECT a FROM Almacendeta a WHERE a.almacendetaPK.codprdto = :codprdto"),
    @NamedQuery(name = "Almacendeta.findByCantidadprdto", query = "SELECT a FROM Almacendeta a WHERE a.cantidadprdto = :cantidadprdto")})
public class Almacendeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlmacendetaPK almacendetaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadprdto")
    private double cantidadprdto;
    @JoinColumn(name = "codprdto", referencedColumnName = "codprdto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "codalmacen", referencedColumnName = "codalmacen")
    @ManyToOne(optional = false)
    private Almacen codalmacen;

    public Almacendeta() {
    }

    public Almacendeta(AlmacendetaPK almacendetaPK) {
        this.almacendetaPK = almacendetaPK;
    }

    public Almacendeta(AlmacendetaPK almacendetaPK, double cantidadprdto) {
        this.almacendetaPK = almacendetaPK;
        this.cantidadprdto = cantidadprdto;
    }

    public Almacendeta(int idalmdeta, String codprdto) {
        this.almacendetaPK = new AlmacendetaPK(idalmdeta, codprdto);
    }

    public AlmacendetaPK getAlmacendetaPK() {
        return almacendetaPK;
    }

    public void setAlmacendetaPK(AlmacendetaPK almacendetaPK) {
        this.almacendetaPK = almacendetaPK;
    }

    public double getCantidadprdto() {
        return cantidadprdto;
    }

    public void setCantidadprdto(double cantidadprdto) {
        this.cantidadprdto = cantidadprdto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Almacen getCodalmacen() {
        return codalmacen;
    }

    public void setCodalmacen(Almacen codalmacen) {
        this.codalmacen = codalmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (almacendetaPK != null ? almacendetaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacendeta)) {
            return false;
        }
        Almacendeta other = (Almacendeta) object;
        if ((this.almacendetaPK == null && other.almacendetaPK != null) || (this.almacendetaPK != null && !this.almacendetaPK.equals(other.almacendetaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Almacendeta[ almacendetaPK=" + almacendetaPK + " ]";
    }
    
}
