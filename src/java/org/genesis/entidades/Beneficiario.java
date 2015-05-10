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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author orlando
 */
@Entity
@Table(name = "BENEFICIARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beneficiario.findAll", query = "SELECT b FROM Beneficiario b"),
    @NamedQuery(name = "Beneficiario.findByCodbenef", query = "SELECT b FROM Beneficiario b WHERE b.codbenef = :codbenef"),
    @NamedQuery(name = "Beneficiario.findByNombrebene", query = "SELECT b FROM Beneficiario b WHERE b.nombrebene = :nombrebene"),
    @NamedQuery(name = "Beneficiario.findByTelefono", query = "SELECT b FROM Beneficiario b WHERE b.telefono = :telefono"),
    @NamedQuery(name = "Beneficiario.findByEmail", query = "SELECT b FROM Beneficiario b WHERE b.email = :email"),
    @NamedQuery(name = "Beneficiario.findByDireccion", query = "SELECT b FROM Beneficiario b WHERE b.direccion = :direccion"),
    @NamedQuery(name = "Beneficiario.findByDui", query = "SELECT b FROM Beneficiario b WHERE b.dui = :dui"),
    @NamedQuery(name = "Beneficiario.findByNit", query = "SELECT b FROM Beneficiario b WHERE b.nit = :nit"),
    @NamedQuery(name = "Beneficiario.findByContactobene", query = "SELECT b FROM Beneficiario b WHERE b.contactobene = :contactobene")})
public class Beneficiario implements Serializable {
    private static final long serialVersionUID = 1L;
    //Generador de secuencias o autoincremental
    @TableGenerator(name = "benefi_gen",
            table = "ID_GEN",
            pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VAL")
    @Id
    @GeneratedValue(generator = "benefi_gen")
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "codbenef")
    private Integer codbenef;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 150)
    @Column(name = "nombrebene")
    private String nombrebene;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 150)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "dui")
    private String dui;
    @Size(max = 17)
    @Column(name = "nit")
    private String nit;
    @Size(max = 150)
    @Column(name = "contactobene")
    private String contactobene;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codbenef")
    private List<Salida> salidaList;

    public Beneficiario() {
    }

    public Beneficiario(Integer codbenef) {
        this.codbenef = codbenef;
    }

    public Beneficiario(Integer codbenef, String nombrebene) {
        this.codbenef = codbenef;
        this.nombrebene = nombrebene;
    }

    public Integer getCodbenef() {
        return codbenef;
    }

    public void setCodbenef(Integer codbenef) {
        this.codbenef = codbenef;
    }

    public String getNombrebene() {
        return nombrebene;
    }

    public void setNombrebene(String nombrebene) {
        this.nombrebene = nombrebene;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getContactobene() {
        return contactobene;
    }

    public void setContactobene(String contactobene) {
        this.contactobene = contactobene;
    }

    @XmlTransient
    public List<Salida> getSalidaList() {
        return salidaList;
    }

    public void setSalidaList(List<Salida> salidaList) {
        this.salidaList = salidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbenef != null ? codbenef.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiario)) {
            return false;
        }
        Beneficiario other = (Beneficiario) object;
        if ((this.codbenef == null && other.codbenef != null) || (this.codbenef != null && !this.codbenef.equals(other.codbenef))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Beneficiario[ codbenef=" + codbenef + " ]";
    }
    
}
