/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.genesis.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author orlando
 */
@Entity
@Table(name = "ID_GEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdGen.findAll", query = "SELECT i FROM IdGen i"),
    @NamedQuery(name = "IdGen.findByGenName", query = "SELECT i FROM IdGen i WHERE i.genName = :genName"),
    @NamedQuery(name = "IdGen.findByGenVal", query = "SELECT i FROM IdGen i WHERE i.genVal = :genVal")})
public class IdGen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GEN_NAME")
    private String genName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GEN_VAL")
    private int genVal;

    public IdGen() {
    }

    public IdGen(String genName) {
        this.genName = genName;
    }

    public IdGen(String genName, int genVal) {
        this.genName = genName;
        this.genVal = genVal;
    }

    public String getGenName() {
        return genName;
    }

    public void setGenName(String genName) {
        this.genName = genName;
    }

    public int getGenVal() {
        return genVal;
    }

    public void setGenVal(int genVal) {
        this.genVal = genVal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genName != null ? genName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdGen)) {
            return false;
        }
        IdGen other = (IdGen) object;
        if ((this.genName == null && other.genName != null) || (this.genName != null && !this.genName.equals(other.genName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.IdGen[ genName=" + genName + " ]";
    }
    
}
