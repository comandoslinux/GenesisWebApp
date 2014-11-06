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
@Table(name = "ALMACEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacen.findAll", query = "SELECT a FROM Almacen a"),
    @NamedQuery(name = "Almacen.findByCodalmacen", query = "SELECT a FROM Almacen a WHERE a.codalmacen = :codalmacen"),
    @NamedQuery(name = "Almacen.findByNombre", query = "SELECT a FROM Almacen a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Almacen.findByDescripcion", query = "SELECT a FROM Almacen a WHERE a.descripcion = :descripcion")})
public class Almacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codalmacen")
    private String codalmacen;
    @Size(max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codalmacen")
    private List<Almacendeta> almacendetaList;

    public Almacen() {
    }

    public Almacen(String codalmacen) {
        this.codalmacen = codalmacen;
    }

    public String getCodalmacen() {
        return codalmacen;
    }

    public void setCodalmacen(String codalmacen) {
        this.codalmacen = codalmacen;
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
        hash += (codalmacen != null ? codalmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacen)) {
            return false;
        }
        Almacen other = (Almacen) object;
        if ((this.codalmacen == null && other.codalmacen != null) || (this.codalmacen != null && !this.codalmacen.equals(other.codalmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Almacen[ codalmacen=" + codalmacen + " ]";
    }
    
}
