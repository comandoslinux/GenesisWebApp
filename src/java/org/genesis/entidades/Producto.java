/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.genesis.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author orlando
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByCodprdto", query = "SELECT p FROM Producto p WHERE p.codprdto = :codprdto"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 100)
    @Column(name = "codprdto")
    private String codprdto;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
//    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "codum", referencedColumnName = "codum")
    @ManyToOne(optional = false)
    private Umedida codum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Salidadeta> salidadetaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Donaciondeta> donaciondetaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Almacendeta> almacendetaList;

    public Producto() {
    }

    public Producto(String codprdto) {
        this.codprdto = codprdto;
    }

    public Producto(String codprdto, String nombre) {
        this.codprdto = codprdto;
        this.nombre = nombre;
    }

    public String getCodprdto() {
        return codprdto;
    }

    public void setCodprdto(String codprdto) {
        this.codprdto = codprdto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Umedida getCodum() {
        return codum;
    }

    public void setCodum(Umedida codum) {
        this.codum = codum;
    }

    @XmlTransient
    public List<Salidadeta> getSalidadetaList() {
        return salidadetaList;
    }

    public void setSalidadetaList(List<Salidadeta> salidadetaList) {
        this.salidadetaList = salidadetaList;
    }

    @XmlTransient
    public List<Donaciondeta> getDonaciondetaList() {
        return donaciondetaList;
    }

    public void setDonaciondetaList(List<Donaciondeta> donaciondetaList) {
        this.donaciondetaList = donaciondetaList;
    }

    @XmlTransient
    public List<Almacendeta> getAlmacendetaList() {
        return almacendetaList;
    }

    public void setAlmacendetaList(List<Almacendeta> almacendetaList) {
        this.almacendetaList = almacendetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprdto != null ? codprdto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codprdto == null && other.codprdto != null) || (this.codprdto != null && !this.codprdto.equals(other.codprdto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Producto[ codprdto=" + codprdto + " ]";
    }
    
}
