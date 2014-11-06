/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.genesis.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author orlando
 */
@Entity
@Table(name = "LOTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l"),
    @NamedQuery(name = "Lote.findByCodlote", query = "SELECT l FROM Lote l WHERE l.codlote = :codlote"),
    @NamedQuery(name = "Lote.findByNombre", query = "SELECT l FROM Lote l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Lote.findByDescripcion", query = "SELECT l FROM Lote l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "Lote.findByFechavencimto", query = "SELECT l FROM Lote l WHERE l.fechavencimto = :fechavencimto")})
public class Lote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codlote")
    private Integer codlote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechavencimto")
    @Temporal(TemporalType.DATE)
    private Date fechavencimto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codlote")
    private List<Donaciondeta> donaciondetaList;

    public Lote() {
    }

    public Lote(Integer codlote) {
        this.codlote = codlote;
    }

    public Lote(Integer codlote, String nombre) {
        this.codlote = codlote;
        this.nombre = nombre;
    }

    public Integer getCodlote() {
        return codlote;
    }

    public void setCodlote(Integer codlote) {
        this.codlote = codlote;
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

    public Date getFechavencimto() {
        return fechavencimto;
    }

    public void setFechavencimto(Date fechavencimto) {
        this.fechavencimto = fechavencimto;
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
        hash += (codlote != null ? codlote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.codlote == null && other.codlote != null) || (this.codlote != null && !this.codlote.equals(other.codlote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Lote[ codlote=" + codlote + " ]";
    }
    
}
