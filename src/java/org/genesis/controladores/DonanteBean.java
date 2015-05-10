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
import org.genesis.entidades.Donante;
import org.genesis.entidades.Tpdonante;
import org.genesis.procesos.BusquedasLocal;
import org.genesis.procesos.CRUDLocal;
import org.genesis.util.Util;
import org.genesis.util.UtilidadesVarias;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author orlando
 */
//</editor-fold>
@ManagedBean(name = "donante")
@ViewScoped
public class DonanteBean implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Llamado a los EJB'S">  
    @EJB
    private BusquedasLocal busquedas;
    @EJB
    private CRUDLocal cRUD;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Variables">  
    //Lista de donantes a mostrar en el datatable.
    private List<Donante> lstDonante = new ArrayList();
    //Lista para combo de tipos de donantes
    private List<Tpdonante> lstTpdonantes = new ArrayList();
    //Entidad a guardar en la bd.
    private Donante donante = new Donante();
    //Utilidades varias.
    private UtilidadesVarias util = Util.buscarBean("util");
    //Variable para mensajes del dialogo.
    private StringBuilder msg = new StringBuilder();
    //Codigo para el tipo de donante
    private String codtpDonante;
    //Bandera para btn Eliminar: true muestra, false esconde.
    private boolean banBtnEli = false;
    //Bandera activar/desactivar pk
    private boolean banpk = false;
    //Bitacora de logs.
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    //Datatable para la entidad Estddonacion.
    private DataTable tblDonantes = new DataTable();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public StringBuilder getMsg() {
        return msg;
    }

    public void setMsg(StringBuilder msg) {
        this.msg = msg;
    }

    public boolean isBanBtnEli() {
        return banBtnEli;
    }

    public void setBanBtnEli(boolean banBtnEli) {
        this.banBtnEli = banBtnEli;
    }

    public boolean isBanpk() {
        return banpk;
    }

    public void setBanpk(boolean banpk) {
        this.banpk = banpk;
    }    

    public List<Donante> getLstDonante() throws Exception {
        lstDonante = busquedas.listaDonantes();
        return lstDonante;
    }

    public void setLstDonante(List<Donante> lstDonante) {
        this.lstDonante = lstDonante;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    public DataTable getTblDonantes() {
        return tblDonantes;
    }

    public void setTblDonantes(DataTable tblDonantes) {
        this.tblDonantes = tblDonantes;
    }

    public List<Tpdonante> getLstTpdonantes() throws Exception {
        lstTpdonantes = busquedas.listaTpDonantes();
        return lstTpdonantes;
    }

    public void setLstTpdonantes(List<Tpdonante> lstTpdonantes) throws Exception {
        lstTpdonantes = busquedas.listaTpDonantes();
        this.lstTpdonantes = lstTpdonantes;
    }

    public String getCodtpDonante() {
        return codtpDonante;
    }

    public void setCodtpDonante(String codtpDonante) {
        this.codtpDonante = codtpDonante;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos"> 
    /**
     * Valida que los datos requeridos sean ingresados.
     *
     * @return true en caso de exito.
     */
    public final boolean validaInputs() {        
        
        msg = new StringBuilder();
        if (donante.getNombre().isEmpty()) {
            msg.append(" Nombre es requerido. ");
            util.alerta(msg, 2);
            return false;
        }
        if (donante.getFingreso() == null) {
            msg.append(" Fecha es requerida. ");
            util.alerta(msg, 2);
            return false;
        }
        if (codtpDonante.equals("-")) {
            msg.append(" Codigo de tipo de donante es requerido. ");
            util.alerta(msg, 2);
            return false;
        }
        return true;
    }
    
    /**
     * Limpia los valores ingresados en los inpus.
     */
    public final void limpiarPantalla(){
        donante = new Donante();
        banpk = false;
        banBtnEli = false;
        codtpDonante = "";
    }
    

    /**
     * Desactiva la pk para la no edicion.
     */
    public final void activarPK() {
        codtpDonante = donante.getCodtpdonante().getCodtpdonante();
        banpk = true;
        banBtnEli = true;
    }
    
    
    /**
     * Inserta/Actualiza un donante en la bd.
     *
     * @throws Exception Error generico.
     */
    public void guardarDonante() throws Exception {
        
        msg = new StringBuilder();
        if (validaInputs()) {
            try {
                donante.setCodtpdonante(new Tpdonante(codtpDonante));
                cRUD.guardarEntidad(donante);
                msg.append("Registro guardado con exito");
                util.alerta(msg, 1);
                limpiarPantalla();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error en guardarDonante():", e);
                msg.append("Error al guardar el donante, consulte a IT");
                util.alerta(msg, 3);
            }

        }
    }
    
    /**
     * Elimina de la bd un registro.
     *
     * @throws Exception Error generico.
     */
    public final void eliminarDonante() throws Exception {
        
        msg = new StringBuilder();
        try {
            if (donante != null) {
                cRUD.eliminarEntidad(donante);
                msg.append(" Registro eliminado con exito. ");
                util.alerta(msg, 1);
            }
            limpiarPantalla();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en eliminarDonante():", e);
            msg.append("Error al eliminar el registro, consulte a alguien de IT");
            util.alerta(msg, 3);
        }
    }
    
    /**
     * ELimina un registro del datatable.
     * 
     * @throws Exception Error generico.
     */
    public void btnEliminarLinea() throws Exception {
        
        msg = new StringBuilder();
        try {
            if (tblDonantes.getRowData() != null) {
                cRUD.eliminarEntidad(tblDonantes.getRowData());
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en btnEliminarLinea():", e);
            msg.append("Error al eliminar la linea, consulte a alguien de IT");
            util.alerta(msg, 3);
        }

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">  
    /**
     * Creates a new instance of EstdDonacionBean
     */
    public DonanteBean() {
    }
    //</editor-fold>    
}
