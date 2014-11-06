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
@Table(name = "SALIDADETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salidadeta.findAll", query = "SELECT s FROM Salidadeta s"),
    @NamedQuery(name = "Salidadeta.findByIdsalidadeta", query = "SELECT s FROM Salidadeta s WHERE s.salidadetaPK.idsalidadeta = :idsalidadeta"),
    @NamedQuery(name = "Salidadeta.findByCodprdto", query = "SELECT s FROM Salidadeta s WHERE s.salidadetaPK.codprdto = :codprdto"),
    @NamedQuery(name = "Salidadeta.findByCantidadprdto", query = "SELECT s FROM Salidadeta s WHERE s.cantidadprdto = :cantidadprdto")})
public class Salidadeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalidadetaPK salidadetaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadprdto")
    private double cantidadprdto;
    @JoinColumn(name = "codprdto", referencedColumnName = "codprdto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "codsalida", referencedColumnName = "codsalida")
    @ManyToOne(optional = false)
    private Salida codsalida;

    public Salidadeta() {
    }

    public Salidadeta(SalidadetaPK salidadetaPK) {
        this.salidadetaPK = salidadetaPK;
    }

    public Salidadeta(SalidadetaPK salidadetaPK, double cantidadprdto) {
        this.salidadetaPK = salidadetaPK;
        this.cantidadprdto = cantidadprdto;
    }

    public Salidadeta(int idsalidadeta, String codprdto) {
        this.salidadetaPK = new SalidadetaPK(idsalidadeta, codprdto);
    }

    public SalidadetaPK getSalidadetaPK() {
        return salidadetaPK;
    }

    public void setSalidadetaPK(SalidadetaPK salidadetaPK) {
        this.salidadetaPK = salidadetaPK;
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

    public Salida getCodsalida() {
        return codsalida;
    }

    public void setCodsalida(Salida codsalida) {
        this.codsalida = codsalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salidadetaPK != null ? salidadetaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salidadeta)) {
            return false;
        }
        Salidadeta other = (Salidadeta) object;
        if ((this.salidadetaPK == null && other.salidadetaPK != null) || (this.salidadetaPK != null && !this.salidadetaPK.equals(other.salidadetaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Salidadeta[ salidadetaPK=" + salidadetaPK + " ]";
    }
    
}
