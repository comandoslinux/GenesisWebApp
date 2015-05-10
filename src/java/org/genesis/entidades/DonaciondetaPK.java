/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.genesis.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;
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
public class DonaciondetaPK implements Serializable {
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "codcorrdndeta")
    private BigInteger codcorrdndeta;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 100)
    @Column(name = "codprdto")
    private String codprdto;
    @Column(name = "codcorredncn")
    private BigInteger codcorredncn;

    public DonaciondetaPK() {
    }

    public DonaciondetaPK(BigInteger codcorrdndeta, String codprdto, BigInteger codcorredncn) {
        this.codcorrdndeta = codcorrdndeta;
        this.codprdto = codprdto;
        this.codcorredncn = codcorredncn;
    }

    public BigInteger getCodcorrdndeta() {
        return codcorrdndeta;
    }

    public void setCodcorrdndeta(BigInteger codcorrdndeta) {
        this.codcorrdndeta = codcorrdndeta;
    }

    public String getCodprdto() {
        return codprdto;
    }

    public void setCodprdto(String codprdto) {
        this.codprdto = codprdto;
    }

    public BigInteger getCodcorredncn() {
        return codcorredncn;
    }

    public void setCodcorredncn(BigInteger codcorredncn) {
        this.codcorredncn = codcorredncn;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.codcorrdndeta);
        hash = 41 * hash + Objects.hashCode(this.codprdto);
        hash = 41 * hash + Objects.hashCode(this.codcorredncn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DonaciondetaPK other = (DonaciondetaPK) obj;
        if (!Objects.equals(this.codcorrdndeta, other.codcorrdndeta)) {
            return false;
        }
        if (!Objects.equals(this.codprdto, other.codprdto)) {
            return false;
        }
        if (!Objects.equals(this.codcorredncn, other.codcorredncn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DonaciondetaPK{" + "codcorrdndeta=" + codcorrdndeta + ", codprdto=" + codprdto + ", codcorredncn=" + codcorredncn + '}';
    }

    
}