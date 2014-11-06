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
@Table(name = "ESTDPRDTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estdprdto.findAll", query = "SELECT e FROM Estdprdto e"),
    @NamedQuery(name = "Estdprdto.findByCodstdprdto", query = "SELECT e FROM Estdprdto e WHERE e.codstdprdto = :codstdprdto"),
    @NamedQuery(name = "Estdprdto.findByNombre", query = "SELECT e FROM Estdprdto e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estdprdto.findByDescripcion", query = "SELECT e FROM Estdprdto e WHERE e.descripcion = :descripcion")})
public class Estdprdto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codstdprdto")
    private String codstdprdto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codstdprdto")
    private List<Donaciondeta> donaciondetaList;

    public Estdprdto() {
    }

    public Estdprdto(String codstdprdto) {
        this.codstdprdto = codstdprdto;
    }

    public Estdprdto(String codstdprdto, String nombre) {
        this.codstdprdto = codstdprdto;
        this.nombre = nombre;
    }

    public String getCodstdprdto() {
        return codstdprdto;
    }

    public void setCodstdprdto(String codstdprdto) {
        this.codstdprdto = codstdprdto;
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
    public List<Donaciondeta> getDonaciondetaList() {
        return donaciondetaList;
    }

    public void setDonaciondetaList(List<Donaciondeta> donaciondetaList) {
        this.donaciondetaList = donaciondetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codstdprdto != null ? codstdprdto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estdprdto)) {
            return false;
        }
        Estdprdto other = (Estdprdto) object;
        if ((this.codstdprdto == null && other.codstdprdto != null) || (this.codstdprdto != null && !this.codstdprdto.equals(other.codstdprdto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Estdprdto[ codstdprdto=" + codstdprdto + " ]";
    }
    
}
