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
@Table(name = "ESTDDONACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estddonacion.findAll", query = "SELECT e FROM Estddonacion e"),
    @NamedQuery(name = "Estddonacion.findByCodstddncn", query = "SELECT e FROM Estddonacion e WHERE e.codstddncn = :codstddncn"),
    @NamedQuery(name = "Estddonacion.findByNombre", query = "SELECT e FROM Estddonacion e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estddonacion.findByDescripcion", query = "SELECT e FROM Estddonacion e WHERE e.descripcion = :descripcion")})
public class Estddonacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 20)
    @Column(name = "codstddncn")
    private String codstddncn;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codstddncn")
    private List<Donacion> donacionList;

    public Estddonacion() {
    }

    public Estddonacion(String codstddncn) {
        this.codstddncn = codstddncn;
    }

    public Estddonacion(String codstddncn, String nombre) {
        this.codstddncn = codstddncn;
        this.nombre = nombre;
    }

    public String getCodstddncn() {
        return codstddncn;
    }

    public void setCodstddncn(String codstddncn) {
        this.codstddncn = codstddncn;
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
    public List<Donacion> getDonacionList() {
        return donacionList;
    }

    public void setDonacionList(List<Donacion> donacionList) {
        this.donacionList = donacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codstddncn != null ? codstddncn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estddonacion)) {
            return false;
        }
        Estddonacion other = (Estddonacion) object;
        if ((this.codstddncn == null && other.codstddncn != null) || (this.codstddncn != null && !this.codstddncn.equals(other.codstddncn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Estddonacion[ codstddncn=" + codstddncn + " ]";
    }
    
}
