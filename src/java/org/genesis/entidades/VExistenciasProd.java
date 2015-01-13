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
@Table(name = "vExistenciasProd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VExistenciasProd.findAll", query = "SELECT v FROM VExistenciasProd v"),
    @NamedQuery(name = "VExistenciasProd.findByCodprdto", query = "SELECT v FROM VExistenciasProd v WHERE v.codprdto LIKE :codprdto"),
    @NamedQuery(name = "VExistenciasProd.findByNombre", query = "SELECT v FROM VExistenciasProd v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "VExistenciasProd.findByCantidadprdto", query = "SELECT v FROM VExistenciasProd v WHERE v.cantidadprdto = :cantidadprdto"),
    @NamedQuery(name = "VExistenciasProd.findByCodalmacen", query = "SELECT v FROM VExistenciasProd v WHERE v.codalmacen = :codalmacen"),
    @NamedQuery(name = "VExistenciasProd.findByCantidad", query = "SELECT v FROM VExistenciasProd v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "VExistenciasProd.findByUmedida", query = "SELECT v FROM VExistenciasProd v WHERE v.umedida = :umedida")})
public class VExistenciasProd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codprdto")
    private String codprdto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidadprdto")
    private Double cantidadprdto;
    @Size(max = 50)
    @Column(name = "codalmacen")
    private String codalmacen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Size(max = 50)
    @Column(name = "umedida")
    private String umedida;

    public VExistenciasProd() {
    }

    public String getCodprdto() {
        return codprdto;
    }

    public void setCodprdto(String codprdto) {
        this.codprdto = codprdto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidadprdto() {
        return cantidadprdto;
    }

    public void setCantidadprdto(Double cantidadprdto) {
        this.cantidadprdto = cantidadprdto;
    }

    public String getCodalmacen() {
        return codalmacen;
    }

    public void setCodalmacen(String codalmacen) {
        this.codalmacen = codalmacen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUmedida() {
        return umedida;
    }

    public void setUmedida(String umedida) {
        this.umedida = umedida;
    }
    
}
