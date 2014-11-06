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
@Table(name = "TPDONANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpdonante.findAll", query = "SELECT t FROM Tpdonante t"),
    @NamedQuery(name = "Tpdonante.findByCodtpdonante", query = "SELECT t FROM Tpdonante t WHERE t.codtpdonante = :codtpdonante"),
    @NamedQuery(name = "Tpdonante.findByNombre", query = "SELECT t FROM Tpdonante t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tpdonante.findByDescripcion", query = "SELECT t FROM Tpdonante t WHERE t.descripcion = :descripcion")})
public class Tpdonante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codtpdonante")
    private String codtpdonante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtpdonante")
    private List<Donante> donanteList;

    public Tpdonante() {
    }

    public Tpdonante(String codtpdonante) {
        this.codtpdonante = codtpdonante;
    }

    public Tpdonante(String codtpdonante, String nombre) {
        this.codtpdonante = codtpdonante;
        this.nombre = nombre;
    }

    public String getCodtpdonante() {
        return codtpdonante;
    }

    public void setCodtpdonante(String codtpdonante) {
        this.codtpdonante = codtpdonante;
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
    public List<Donante> getDonanteList() {
        return donanteList;
    }

    public void setDonanteList(List<Donante> donanteList) {
        this.donanteList = donanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtpdonante != null ? codtpdonante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpdonante)) {
            return false;
        }
        Tpdonante other = (Tpdonante) object;
        if ((this.codtpdonante == null && other.codtpdonante != null) || (this.codtpdonante != null && !this.codtpdonante.equals(other.codtpdonante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Tpdonante[ codtpdonante=" + codtpdonante + " ]";
    }
    
}
