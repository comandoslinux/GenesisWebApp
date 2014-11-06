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
@Table(name = "DONACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donacion.findAll", query = "SELECT d FROM Donacion d"),
    @NamedQuery(name = "Donacion.findByCodcorredncn", query = "SELECT d FROM Donacion d WHERE d.codcorredncn = :codcorredncn"),
    @NamedQuery(name = "Donacion.findByConcepto", query = "SELECT d FROM Donacion d WHERE d.concepto = :concepto"),
    @NamedQuery(name = "Donacion.findByFingreso", query = "SELECT d FROM Donacion d WHERE d.fingreso = :fingreso"),
    @NamedQuery(name = "Donacion.findByFrecepcion", query = "SELECT d FROM Donacion d WHERE d.frecepcion = :frecepcion")})
public class Donacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codcorredncn")
    private Integer codcorredncn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "concepto")
    private String concepto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fingreso")
    @Temporal(TemporalType.DATE)
    private Date fingreso;
    @Column(name = "frecepcion")
    @Temporal(TemporalType.DATE)
    private Date frecepcion;
    @JoinColumn(name = "codusr", referencedColumnName = "codusr")
    @ManyToOne(optional = false)
    private Usuario codusr;
    @JoinColumn(name = "coddnte", referencedColumnName = "coddnte")
    @ManyToOne(optional = false)
    private Donante coddnte;
    @JoinColumn(name = "codstddncn", referencedColumnName = "codstddncn")
    @ManyToOne(optional = false)
    private Estddonacion codstddncn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcorredncn")
    private List<Donaciondeta> donaciondetaList;

    public Donacion() {
    }

    public Donacion(Integer codcorredncn) {
        this.codcorredncn = codcorredncn;
    }

    public Donacion(Integer codcorredncn, String concepto, Date fingreso) {
        this.codcorredncn = codcorredncn;
        this.concepto = concepto;
        this.fingreso = fingreso;
    }

    public Integer getCodcorredncn() {
        return codcorredncn;
    }

    public void setCodcorredncn(Integer codcorredncn) {
        this.codcorredncn = codcorredncn;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFingreso() {
        return fingreso;
    }

    public void setFingreso(Date fingreso) {
        this.fingreso = fingreso;
    }

    public Date getFrecepcion() {
        return frecepcion;
    }

    public void setFrecepcion(Date frecepcion) {
        this.frecepcion = frecepcion;
    }

    public Usuario getCodusr() {
        return codusr;
    }

    public void setCodusr(Usuario codusr) {
        this.codusr = codusr;
    }

    public Donante getCoddnte() {
        return coddnte;
    }

    public void setCoddnte(Donante coddnte) {
        this.coddnte = coddnte;
    }

    public Estddonacion getCodstddncn() {
        return codstddncn;
    }

    public void setCodstddncn(Estddonacion codstddncn) {
        this.codstddncn = codstddncn;
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
        hash += (codcorredncn != null ? codcorredncn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donacion)) {
            return false;
        }
        Donacion other = (Donacion) object;
        if ((this.codcorredncn == null && other.codcorredncn != null) || (this.codcorredncn != null && !this.codcorredncn.equals(other.codcorredncn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Donacion[ codcorredncn=" + codcorredncn + " ]";
    }
    
}
