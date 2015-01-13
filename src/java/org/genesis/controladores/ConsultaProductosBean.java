//<editor-fold defaultstate="collapsed" desc="Imports">  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.genesis.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.genesis.entidades.VExistenciasProd;
import org.genesis.procesos.BusquedasLocal;
import org.genesis.util.Util;
import org.genesis.util.UtilidadesVarias;

/**
 *
 * @author orlando
 */
//</editor-fold>
@ManagedBean(name = "consultaProductos")
@ViewScoped
public class ConsultaProductosBean implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Llamado a los EJB'S">  
    @EJB
    private BusquedasLocal busquedas;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Variables">  
    //Codigo del producto a consultar
    private String codproducto;
    //Variable para mensajes del dialogo
    private StringBuilder msg = new StringBuilder();
    //Variable list de productos
    private List<VExistenciasProd> lstExistProd = new ArrayList();
    //Bitacora de logs
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    //Utilidades varias
    private UtilidadesVarias util = Util.buscarBean("util");
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(String codproducto) {
        this.codproducto = codproducto;
    }

    public StringBuilder getMsg() {
        return msg;
    }

    public void setMsg(StringBuilder msg) {
        this.msg = msg;
    }

    public List<VExistenciasProd> getLstExistProd() {
        return lstExistProd;
    }

    public void setLstExistProd(List<VExistenciasProd> lstExistProd) {
        this.lstExistProd = lstExistProd;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">  
    /**
     * Busca un producto en especifico.
     *
     * @throws Exception Error generico.
     */
    public void buscarExistProd() throws Exception {
        
        msg = new StringBuilder();
        try {
            if(codproducto.isEmpty()){
                msg.append("Codigo de producto es requerido.");
                util.alerta(msg, 2);
                return;
            }
            lstExistProd = busquedas.consultaProductos(codproducto);
            if (lstExistProd.isEmpty()) {
                msg.append("No se encontro ningun producto.");
                util.alerta(msg, 2);
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en buscarExistProd():", e);
            msg.append("Error al consultar existencias, consulte a IT");
            util.alerta(msg, 3);
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">  
    /**
     * Creates a new instance of ConsultaProductosBean
     */
    public ConsultaProductosBean() {
    }    
    //</editor-fold>
    
}
