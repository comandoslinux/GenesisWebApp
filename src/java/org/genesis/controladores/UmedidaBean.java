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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.genesis.entidades.Umedida;
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
@ManagedBean(name = "umedidaBean")
@ViewScoped
public class UmedidaBean implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Llamado a los EJB'S">     
    @EJB
    private BusquedasLocal busquedas;     
    @EJB
    private CRUDLocal cRUD;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Variables"> 
    //Variable para mensajes del dialogo
    private StringBuilder msg = new StringBuilder();
    //Bandera btn Eliminar
    private boolean banBtnEli = false;
    //Bandera activar/desactivar pk
    private boolean banpk = false;
    //Utilidades varias
    private UtilidadesVarias util = Util.buscarBean("util");
    //Bitacora de logs
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    //Entidad UM
    private Umedida umedida = new Umedida();
    //Lista de um
    private List<Umedida> lstUmedida = new ArrayList();
    //Datatable para um
    private DataTable tblUm = new DataTable();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public StringBuilder getMsg() {
        return msg;
    }

    public void setMsg(StringBuilder msg) {
        this.msg = msg;
    }

    public Umedida getUmedida() {
        return umedida;
    }

    public void setUmedida(Umedida umedida) {
        this.umedida = umedida;
    }

    public List<Umedida> getLstUmedida() throws Exception {
        lstUmedida = busquedas.listaUM();
        return lstUmedida;
    }

    public void setLstUmedida(List<Umedida> lstUmedida) {
        this.lstUmedida = lstUmedida;
    }

    public UtilidadesVarias getUtil() {
        return util;
    }

    public void setUtil(UtilidadesVarias util) {
        this.util = util;
    }

    public boolean isBanBtnEli() {
        return banBtnEli;
    }

    public void setBanBtnEli(boolean banBtnEli) {
        this.banBtnEli = banBtnEli;
    }

    public DataTable getTblUm() {
        return tblUm;
    }

    public void setTblUm(DataTable tblUm) {
        this.tblUm = tblUm;
    }

    public boolean isBanpk() {
        return banpk;
    }

    public void setBanpk(boolean banpk) {
        this.banpk = banpk;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">  
    /**
     * Valida que los datos requeridos se ingresen.
     *
     * @return true en caso de que los campos requeridos esten llenos.
     */
    public boolean validaInputs() {
        msg = new StringBuilder();
        if (umedida.getCodum().isEmpty()) {
            msg.append("Codigo de um es requerido");
            util.alerta(msg, 2);
            return false;
        }
        if (umedida.getNombre().isEmpty()) {
            msg.append("Nombre de um es requerido");
            util.alerta(msg, 2);
            return false;
        }
        return true;
    }

    /**
     *
     * Limpia los inputs
     */
    public void limpiarPantalla() {
        umedida = new Umedida();
        banBtnEli = false;
        banpk = false;

    }

    /**
     * Inserta/Actualiza una UM en la bd.
     *
     * @throws Exception Error generico
     */
    public void guardarUm() throws Exception {
        msg = new StringBuilder();
        if (validaInputs()) {
            try {
                cRUD.guardarEntidad(umedida);
                msg.append("Unidad de medida guardada con exito");
                util.alerta(msg, 1);
                limpiarPantalla();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error en guardarUm():", e);
                msg.append("Error al guardar la um, consulte a IT");
                util.alerta(msg, 3);
            }

        }
    }
    
    //Desactiva la pk para la no edicion
    public void activarPK() {
        banpk = true;
        banBtnEli = true;
    }

    /**
     * Elimina un registro del datatable.
     * 
     * @throws Exception Error generico.
     */
    public void btnEliminarLinea() throws Exception {
        msg = new StringBuilder();
        try {
            if (tblUm.getRowData() != null) {
                cRUD.eliminarEntidad(tblUm.getRowData());
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en btnEliminarLinea():", e);
            msg.append("Error al eliminar la um, consulte a alguien de IT");
            util.alerta(msg, 3);
        }

    }
    
    /**
     * Elimina una um de la base de datos.
     * 
     * @throws Exception Error generico.
     */
    public void eliminarUm() throws Exception {
        msg = new StringBuilder();
        try {
            if (umedida != null) {
                cRUD.eliminarEntidad(umedida);
                limpiarPantalla();
            } else {
                msg.append("No hay nada que eliminar");
                util.alerta(msg, 2);
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en eliminarUm():", e);
            msg.append("Error al eliminar la um, consulte a IT");
            util.alerta(msg, 3);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">  
    /**
     * Creates a new instance of UmedidaBean
     */
    public UmedidaBean() {
    }

    //</editor-fold>
}
