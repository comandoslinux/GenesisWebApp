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
@Table(name = "PROPIEDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propiedad.findAll", query = "SELECT p FROM Propiedad p"),
    @NamedQuery(name = "Propiedad.findByCodprpdad", query = "SELECT p FROM Propiedad p WHERE p.codprpdad = :codprpdad"),
    @NamedQuery(name = "Propiedad.findByNombre", query = "SELECT p FROM Propiedad p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Propiedad.findByDescripcion", query = "SELECT p FROM Propiedad p WHERE p.descripcion = :descripcion")})
public class Propiedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codprpdad")
    private String codprpdad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprpdad")
    private List<Donaciondeta> donaciondetaList;

    public Propiedad() {
    }

    public Propiedad(String codprpdad) {
        this.codprpdad = codprpdad;
    }

    public Propiedad(String codprpdad, String nombre) {
        this.codprpdad = codprpdad;
        this.nombre = nombre;
    }

    public String getCodprpdad() {
        return codprpdad;
    }

    public void setCodprpdad(String codprpdad) {
        this.codprpdad = codprpdad;
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
        hash += (codprpdad != null ? codprpdad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propiedad)) {
            return false;
        }
        Propiedad other = (Propiedad) object;
        if ((this.codprpdad == null && other.codprpdad != null) || (this.codprpdad != null && !this.codprpdad.equals(other.codprpdad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Propiedad[ codprpdad=" + codprpdad + " ]";
    }
    
}
