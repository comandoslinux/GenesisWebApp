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
import org.genesis.entidades.Beneficiario;
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
@ManagedBean(name = "benefi")
@ViewScoped
public class BeneficiarioBean implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Llamado a los EJB'S">  
    @EJB
    private BusquedasLocal busquedas;
    @EJB
    private CRUDLocal cRUD;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Variables">  
    //Lista de donantes a mostrar en el datatable.
    private List<Beneficiario> lstBenefi = new ArrayList();
    //Entidad a guardar en la bd.
    private Beneficiario beneficiario = new Beneficiario();
    //Utilidades varias.
    private UtilidadesVarias util = Util.buscarBean("util");
    //Variable para mensajes del dialogo.
    private StringBuilder msg = new StringBuilder();
    //Bandera para btn Eliminar: true muestra, false esconde.
    private boolean banBtnEli = false;
    //Bandera activar/desactivar pk
    private boolean banpk = false;
    //Bitacora de logs.
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    //Datatable para la entidad Estddonacion.
    private DataTable tblBenefi = new DataTable();
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

    public List<Beneficiario> getLstBenefi() throws Exception {
        lstBenefi = busquedas.listaBenefi();
        return lstBenefi;
    }

    public void setLstBenefi(List<Beneficiario> lstBenefi) {
        this.lstBenefi = lstBenefi;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public DataTable getTblBenefi() {
        return tblBenefi;
    }

    public void setTblBenefi(DataTable tblBenefi) {
        this.tblBenefi = tblBenefi;
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
        if (beneficiario.getNombrebene().isEmpty()) {
            msg.append(" Nombre es requerido. ");
            util.alerta(msg, 2);
            return false;
        }
        return true;
    }
    
    /**
     * Limpia los valores ingresados en los inpus.
     */
    public final void limpiarPantalla(){
        beneficiario = new Beneficiario();
        banpk = false;
        banBtnEli = false;
    }
    

    /**
     * Desactiva la pk para la no edicion.
     */
    public final void activarPK() {
        banpk = true;
        banBtnEli = true;
    }
    
    
    /**
     * Inserta/Actualiza un Beneficiario en la bd.
     *
     * @throws Exception Error generico.
     */
    public void guardarBeneficiario() throws Exception {
        
        msg = new StringBuilder();
        if (validaInputs()) {
            try {
                cRUD.guardarEntidad(beneficiario);
                msg.append(" Registro guardado con exito. ");
                util.alerta(msg, 1);
                limpiarPantalla();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error en guardarBeneficiario():", e);
                msg.append("Error al guardar el registro, consulte a IT");
                util.alerta(msg, 3);
            }

        }
    }
    
    /**
     * Elimina de la bd un registro.
     *
     * @throws Exception Error generico.
     */
    public final void eliminarBeneficiario() throws Exception {
        
        msg = new StringBuilder();
        try {
            if (beneficiario != null) {
                cRUD.eliminarEntidad(beneficiario);
                msg.append(" Registro eliminado con exito. ");
                util.alerta(msg, 1);
            }
            limpiarPantalla();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en eliminarBeneficiario():", e);
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
            if (tblBenefi.getRowData() != null) {
                cRUD.eliminarEntidad(tblBenefi.getRowData());
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
    public BeneficiarioBean() {
    }
    //</editor-fold>    
}
