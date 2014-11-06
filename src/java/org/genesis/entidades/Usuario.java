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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodusr", query = "SELECT u FROM Usuario u WHERE u.codusr = :codusr"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByPass", query = "SELECT u FROM Usuario u WHERE u.pass = :pass")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
     //Generador de sencuencasss
    @TableGenerator(name = "user_gen",
            table = "ID_GEN",
            pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VAL")
    @Id @GeneratedValue(generator = "user_gen")
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "codusr")
    private Integer codusr;
//    @Size(max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "usuario")
    private String usuario;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 50)
    @Column(name = "pass")
    private String pass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codusr")
    private List<Donacion> donacionList;
    @JoinColumn(name = "codrol", referencedColumnName = "codrol")
    @ManyToOne(optional = false)
    private Rol codrol;

    public Usuario() {
    }

    public Usuario(Integer codusr) {
        this.codusr = codusr;
    }

    public Usuario(Integer codusr, String usuario, String pass) {
        this.codusr = codusr;
        this.usuario = usuario;
        this.pass = pass;
    }

    public Integer getCodusr() {
        return codusr;
    }

    public void setCodusr(Integer codusr) {
        this.codusr = codusr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlTransient
    public List<Donacion> getDonacionList() {
        return donacionList;
    }

    public void setDonacionList(List<Donacion> donacionList) {
        this.donacionList = donacionList;
    }

    public Rol getCodrol() {
        return codrol;
    }

    public void setCodrol(Rol codrol) {
        this.codrol = codrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codusr != null ? codusr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codusr == null && other.codusr != null) || (this.codusr != null && !this.codusr.equals(other.codusr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.Usuario[ codusr=" + codusr + " ]";
    }
    
}
