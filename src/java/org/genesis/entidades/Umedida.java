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
@Table(name = "UMEDIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Umedida.findAll", query = "SELECT u FROM Umedida u"),
    @NamedQuery(name = "Umedida.findByCodum", query = "SELECT u FROM Umedida u WHERE u.codum = :codum"),
    @NamedQuery(name = "Umedida.findByNombre", query = "SELECT u FROM Umedida u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Umedida.findByDescripcion", query = "SELECT u FROM Umedida u WHERE u.descripcion = :descripcion")})
public class Umedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 20)
    @Column(name = "codum")
    private String codum;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codum")
    private List<Producto> productoList;

    public Umedida() {
    }

    public Umedida(String codum) {
        this.codum = codum;
    }

    public Umedida(String codum, String nombre) {
        this.codum = codum;
        this.nombre = nombre;
    }

    public String getCodum() {
        return codum;
    }

    public void setCodum(String codum) {
        this.codum = codum;
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
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codum != null ? codum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Umedida)) {
            return false;
        }
        Umedida other = (Umedida) object;
        if ((this.codum == null && other.codum != null) || (this.codum != null && !this.codum.equals(other.codum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Umedida[ codum=" + codum + " ]";
    }
    
}
