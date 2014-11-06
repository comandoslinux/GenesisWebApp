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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DONANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donante.findAll", query = "SELECT d FROM Donante d"),
    @NamedQuery(name = "Donante.findByCoddnte", query = "SELECT d FROM Donante d WHERE d.coddnte = :coddnte"),
    @NamedQuery(name = "Donante.findByNombre", query = "SELECT d FROM Donante d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Donante.findByFingreso", query = "SELECT d FROM Donante d WHERE d.fingreso = :fingreso"),
    @NamedQuery(name = "Donante.findByDui", query = "SELECT d FROM Donante d WHERE d.dui = :dui"),
    @NamedQuery(name = "Donante.findByNit", query = "SELECT d FROM Donante d WHERE d.nit = :nit"),
    @NamedQuery(name = "Donante.findByTelefono", query = "SELECT d FROM Donante d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Donante.findByDireccion", query = "SELECT d FROM Donante d WHERE d.direccion = :direccion")})
public class Donante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "coddnte")
    private Integer coddnte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fingreso")
    @Temporal(TemporalType.DATE)
    private Date fingreso;
    @Size(max = 10)
    @Column(name = "dui")
    private String dui;
    @Size(max = 17)
    @Column(name = "nit")
    private String nit;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "codtpdonante", referencedColumnName = "codtpdonante")
    @ManyToOne(optional = false)
    private Tpdonante codtpdonante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddnte")
    private List<Donacion> donacionList;

    public Donante() {
    }

    public Donante(Integer coddnte) {
        this.coddnte = coddnte;
    }

    public Donante(Integer coddnte, String nombre, Date fingreso) {
        this.coddnte = coddnte;
        this.nombre = nombre;
        this.fingreso = fingreso;
    }

    public Integer getCoddnte() {
        return coddnte;
    }

    public void setCoddnte(Integer coddnte) {
        this.coddnte = coddnte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFingreso() {
        return fingreso;
    }

    public void setFingreso(Date fingreso) {
        this.fingreso = fingreso;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Tpdonante getCodtpdonante() {
        return codtpdonante;
    }

    public void setCodtpdonante(Tpdonante codtpdonante) {
        this.codtpdonante = codtpdonante;
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
        hash += (coddnte != null ? coddnte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donante)) {
            return false;
        }
        Donante other = (Donante) object;
        if ((this.coddnte == null && other.coddnte != null) || (this.coddnte != null && !this.coddnte.equals(other.coddnte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Donante[ coddnte=" + coddnte + " ]";
    }
    
}
