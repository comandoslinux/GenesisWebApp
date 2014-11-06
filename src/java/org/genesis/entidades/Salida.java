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
@Table(name = "SALIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salida.findAll", query = "SELECT s FROM Salida s"),
    @NamedQuery(name = "Salida.findByCodsalida", query = "SELECT s FROM Salida s WHERE s.codsalida = :codsalida"),
    @NamedQuery(name = "Salida.findByConcepto", query = "SELECT s FROM Salida s WHERE s.concepto = :concepto"),
    @NamedQuery(name = "Salida.findByFechasalida", query = "SELECT s FROM Salida s WHERE s.fechasalida = :fechasalida")})
public class Salida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codsalida")
    private Integer codsalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "concepto")
    private String concepto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechasalida")
    @Temporal(TemporalType.DATE)
    private Date fechasalida;
    @JoinColumn(name = "codbenef", referencedColumnName = "codbenef")
    @ManyToOne(optional = false)
    private Beneficiario codbenef;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codsalida")
    private List<Salidadeta> salidadetaList;

    public Salida() {
    }

    public Salida(Integer codsalida) {
        this.codsalida = codsalida;
    }

    public Salida(Integer codsalida, String concepto, Date fechasalida) {
        this.codsalida = codsalida;
        this.concepto = concepto;
        this.fechasalida = fechasalida;
    }

    public Integer getCodsalida() {
        return codsalida;
    }

    public void setCodsalida(Integer codsalida) {
        this.codsalida = codsalida;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Beneficiario getCodbenef() {
        return codbenef;
    }

    public void setCodbenef(Beneficiario codbenef) {
        this.codbenef = codbenef;
    }

    @XmlTransient
    public List<Salidadeta> getSalidadetaList() {
        return salidadetaList;
    }

    public void setSalidadetaList(List<Salidadeta> salidadetaList) {
        this.salidadetaList = salidadetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsalida != null ? codsalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salida)) {
            return false;
        }
        Salida other = (Salida) object;
        if ((this.codsalida == null && other.codsalida != null) || (this.codsalida != null && !this.codsalida.equals(other.codsalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Salida[ codsalida=" + codsalida + " ]";
    }
    
}
