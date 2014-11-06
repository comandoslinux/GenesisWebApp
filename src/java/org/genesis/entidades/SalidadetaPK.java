/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.genesis.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author orlando
 */
@Embeddable
public class SalidadetaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsalidadeta")
    private int idsalidadeta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codprdto")
    private String codprdto;

    public SalidadetaPK() {
    }

    public SalidadetaPK(int idsalidadeta, String codprdto) {
        this.idsalidadeta = idsalidadeta;
        this.codprdto = codprdto;
    }

    public int getIdsalidadeta() {
        return idsalidadeta;
    }

    public void setIdsalidadeta(int idsalidadeta) {
        this.idsalidadeta = idsalidadeta;
    }

    public String getCodprdto() {
        return codprdto;
    }

    public void setCodprdto(String codprdto) {
        this.codprdto = codprdto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idsalidadeta;
        hash += (codprdto != null ? codprdto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidadetaPK)) {
            return false;
        }
        SalidadetaPK other = (SalidadetaPK) object;
        if (this.idsalidadeta != other.idsalidadeta) {
            return false;
        }
        if ((this.codprdto == null && other.codprdto != null) || (this.codprdto != null && !this.codprdto.equals(other.codprdto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.genesis.entidades.SalidadetaPK[ idsalidadeta=" + idsalidadeta + ", codprdto=" + codprdto + " ]";
    }
    
}
