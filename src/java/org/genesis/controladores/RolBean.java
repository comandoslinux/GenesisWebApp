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
import org.genesis.entidades.Rol;
import org.genesis.procesos.BusquedasLocal;
import org.genesis.procesos.CRUDLocal;
import org.genesis.util.Util;
import org.genesis.util.UtilidadesVarias;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author orlando
 */
@ManagedBean(name = "rol")
@ViewScoped
public class RolBean implements Serializable {
    @EJB
    private CRUDLocal cRUD;

    //<editor-fold defaultstate="collapsed" desc="Llamado a los EJB'S">  
    @EJB
    private BusquedasLocal busquedas;

    //<editor-fold defaultstate="collapsed" desc="Variables">  
    //Entidad rol
    private Rol rol = new Rol();
    //Lista de roles a mostrar en el datatable
    private List<Rol> lstRoles = new ArrayList();
    //Bitacora de logs
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    //Datatable de rol
    private DataTable tblRol = new DataTable();
    //Bandera activar/desactivar pk
    private boolean banpk = false;
    //Bandera btn Eliminar
    private boolean banBtnEli = false;
    //Variable para mensajes del dialogo
    private StringBuilder msg = new StringBuilder();
    //Utilidades varias
    private UtilidadesVarias util = Util.buscarBean("util");

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getLstRoles() throws Exception {
        lstRoles = busquedas.listaRoles();
        return lstRoles;
    }

    public void setLstRoles(List<Rol> lstRoles) {
        this.lstRoles = lstRoles;
    }

    public DataTable getTblRol() {
        return tblRol;
    }

    public void setTblRol(DataTable tblRol) {
        this.tblRol = tblRol;
    }

    public boolean isBanpk() {
        return banpk;
    }

    public void setBanpk(boolean banpk) {
        this.banpk = banpk;
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

    public UtilidadesVarias getUtil() {
        return util;
    }

    public void setUtil(UtilidadesVarias util) {
        this.util = util;
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos">   
    //Limpia los inputs
    public void limpiarPantalla() {
        rol = new Rol();
        banpk = false;
        banBtnEli = false;
    }

    //Valida que los datos requeridos se ingresen
    public boolean validaInputs() {
        msg = new StringBuilder();
        if (rol.getCodrol().isEmpty()) {
            msg.append("Codigo de rol es requerido");
            util.alerta(msg, 2);
            return false;
        }
        if (rol.getNombre().isEmpty()) {
            msg.append("Nombre de rol es requerido");
            util.alerta(msg, 2);
            return false;
        }
        return true;
    }

    /**
     * Inserta/Actualiza un rol en la bd
     *
     * @throws Exception Error generico
     */
    public void guardarRol() throws Exception {
        msg = new StringBuilder();
        if (validaInputs()) {
            try {
                cRUD.guardarEntidad(rol);
                msg.append("Rol guardado con exito");
                util.alerta(msg, 1);
                limpiarPantalla();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error en guardarRol():", e);
                msg.append("Error al guardar el usuario, consulte a IT");
                util.alerta(msg, 3);
            }

        }
    }

    /**
     * Elimina de la bd un rol
     *
     * @throws Exception Error generico
     */
    public final void eliminarRol() throws Exception {
        msg = new StringBuilder();
        try {
            if (rol != null) {
                cRUD.eliminarEntidad(rol);
                msg.append("Rol eliminado con exito");
                util.alerta(msg, 1);
            }
            limpiarPantalla();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en eliminarRol():", e);
            msg.append("Error al eliminar el rol, consulte a alguien de IT");
            util.alerta(msg, 3);
        }
    }

    //Desactiva la pk para la no edicion
    public void activarPK() {
        banpk = true;
        banBtnEli = true;
    }

    public void btnEliminarLinea() throws Exception {
        msg = new StringBuilder();
        try {
            if (tblRol.getRowData() != null) {
                cRUD.eliminarEntidad(tblRol.getRowData());
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en btnEliminarLinea():", e);
            msg.append("Error al eliminar el rol, consulte a alguien de IT");
            util.alerta(msg, 3);
        }

    }

    //<editor-fold defaultstate="collapsed" desc="Constructor">  
    /**
     * Creates a new instance of RolBean
     */
    public RolBean() {
    }

}
