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
import org.genesis.entidades.Estddonacion;
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
@ManagedBean(name = "estdDonacion")
@ViewScoped
public class EstdDonacionBean implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Llamado a los EJB'S">  
    @EJB
    private BusquedasLocal busquedas;
    @EJB
    private CRUDLocal cRUD;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Variables">  
    //Lista de estadodonacion a mostrar en el datatable.
    private List<Estddonacion> lstEstdDonacion = new ArrayList();
    //Entidad a guardar en la bd.
    private Estddonacion stdDonacion = new Estddonacion();
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
    private DataTable tblEstdDonacion = new DataTable();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public Estddonacion getStdDonacion() {
        return stdDonacion;
    }

    public void setStdDonacion(Estddonacion stdDonacion) {
        this.stdDonacion = stdDonacion;
    }

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

    public List<Estddonacion> getLstEstdDonacion() throws Exception {
        lstEstdDonacion = busquedas.listaEstDona();
        return lstEstdDonacion;
    }

    public void setLstEstdDonacion(List<Estddonacion> lstEstdDonacion) {
        this.lstEstdDonacion = lstEstdDonacion;
    }

    public DataTable getTblEstdDonacion() {
        return tblEstdDonacion;
    }

    public void setTblEstdDonacion(DataTable tblEstdDonacion) {
        this.tblEstdDonacion = tblEstdDonacion;
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
        if (stdDonacion.getCodstddncn().isEmpty()) {
            msg.append("Codigo de estado donacion es requerido");
            util.alerta(msg, 2);
            return false;
        }
        if (stdDonacion.getNombre().isEmpty()) {
            msg.append("Codigo de estado donacion es requerido");
            util.alerta(msg, 2);
            return false;
        }
        return true;
    }
    
    /**
     * Limpia los valores ingresados en los inpus.
     */
    public final void limpiarPantalla(){
        stdDonacion = new Estddonacion();
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
     * Inserta/Actualiza un estado de donacion en la bd.
     *
     * @throws Exception Error generico.
     */
    public void guardarEstdDonacion() throws Exception {
        
        msg = new StringBuilder();
        if (validaInputs()) {
            try {
                cRUD.guardarEntidad(stdDonacion);
                msg.append("Registro guardado con exito");
                util.alerta(msg, 1);
                limpiarPantalla();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error en guardarEstdDonacion():", e);
                msg.append("Error al guardar el estado de donacion, consulte a IT");
                util.alerta(msg, 3);
            }

        }
    }
    
    /**
     * Elimina de la bd un registro.
     *
     * @throws Exception Error generico.
     */
    public final void eliminarEstdDonacion() throws Exception {
        
        msg = new StringBuilder();
        try {
            if (stdDonacion != null) {
                cRUD.eliminarEntidad(stdDonacion);
                msg.append("Registro eliminado con exito");
                util.alerta(msg, 1);
            }
            limpiarPantalla();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en eliminarEstdDonacion():", e);
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
            if (tblEstdDonacion.getRowData() != null) {
                cRUD.eliminarEntidad(tblEstdDonacion.getRowData());
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
    public EstdDonacionBean() {
    }
    //</editor-fold>    
}
