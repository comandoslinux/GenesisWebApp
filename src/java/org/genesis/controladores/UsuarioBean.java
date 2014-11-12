//<editor-fold defaultstate="collapsed" desc="Variables"> 
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
import org.genesis.entidades.Usuario;
import org.genesis.procesos.BusquedasLocal;
import org.genesis.procesos.CRUDLocal;
import org.genesis.util.Encriptar;
import org.genesis.util.Util;
import org.genesis.util.UtilidadesVarias;
import org.primefaces.component.datatable.DataTable;

/**
 *
 * @author orlando
 */
//</editor-fold>
@ManagedBean(name = "user")
@ViewScoped
public class UsuarioBean implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Llamado a los EJB'S"> 
    @EJB
    private CRUDLocal cRUD;
    @EJB
    private BusquedasLocal busquedas;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Variables">  
    //Datatable de rol
    private DataTable tblRol = new DataTable();
    //Entidad a guardar en la bd
    private Usuario usuario = new Usuario();
    //Lista de usuarios a mostrar en el datatble
    private List<Usuario> lstUsers = new ArrayList();
    //Lista de roles a mostrar en el combo
    private List<Rol> lstRoles = new ArrayList();
    //Variable para almacenar el rol seleccionado del combo
    private String codrol;
    //String para guardar clave
    private String password;
    //Bitacora de logs
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    //Variable para mensajes del dialogo
    private StringBuilder msg = new StringBuilder();
    //Bandera para btn guardar
    private boolean banBtnSave = false;
    //Bandera activar/desactivar Dialog
    private boolean banPopUpMsg = false;
    //Bandera para btn eliminar
    private boolean banBtnDelet = false;
    //Bandera activar/desactivar pk
    private boolean banpk = false;
    //Utilidades varias
    private UtilidadesVarias util = Util.buscarBean("util");
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLstUsers() throws Exception {
        lstUsers = busquedas.listaUsers();
        return lstUsers;
    }

    public void setLstUsers(List<Usuario> lstUsers) {
        this.lstUsers = lstUsers;
    }

    public String getCodrol() {
        return codrol;
    }

    public void setCodrol(String codrol) {
        this.codrol = codrol;
    }

    public StringBuilder getMsg() {
        return msg;
    }

    public void setMsg(StringBuilder msg) {
        this.msg = msg;
    }


    public boolean isBanBtnSave() {
        return banBtnSave;
    }

    public void setBanBtnSave(boolean banBtnSave) {
        this.banBtnSave = banBtnSave;
    }

    public boolean isBanBtnDelet() {
        return banBtnDelet;
    }

    public void setBanBtnDelet(boolean banBtnDelet) {
        this.banBtnDelet = banBtnDelet;
    }

    public List<Rol> getLstRoles() throws Exception {
        lstRoles = busquedas.listaRoles();
        return lstRoles;
    }

    public void setLstRoles(List<Rol> lstRoles) {
        this.lstRoles = lstRoles;
    }

    public boolean isBanpk() {
        return banpk;
    }

    public void setBanpk(boolean banpk) {
        this.banpk = banpk;
    }

    public boolean isBanPopUpMsg() {
        return banPopUpMsg;
    }

    public void setBanPopUpMsg(boolean banPopUpMsg) {
        this.banPopUpMsg = banPopUpMsg;
    }

    public DataTable getTblRol() {
        return tblRol;
    }

    public void setTblRol(DataTable tblRol) {
        this.tblRol = tblRol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UtilidadesVarias getUtil() {
        return util;
    }

    public void setUtil(UtilidadesVarias util) {
        this.util = util;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">  
    /**
     * Permite seleccionar el rol que tiene  el
     * usuario que captura la propiedad:
     * "..setPropertyActionListener value="#{lst}" target="#{user.usuario}"
     * 
     */
    public final void seleccionaEntidad() {
        codrol = usuario.getCodrol().getCodrol();
        banBtnDelet = true;
    }

    //Limpia los valores de los inputs
    public final void limpiarPantalla() {
        banBtnDelet = false;
        usuario = new Usuario();
        codrol = "";
    }

    /**
     * Valida que los inputs sean ingresados
     *
     * @return true, Si todos los filtros son true
     */
    public final boolean validaInputs() {
        msg = new StringBuilder();
        if (usuario.getUsuario().isEmpty()) {
            msg.append("Usuario es requerido");
            util.alerta(msg, 2);
            return false;
        }
        if (password.isEmpty()) {
            msg.append("Clave es requerido");
            util.alerta(msg, 2);
            return false;
        }
        if (codrol.equals("-")) {
            msg.append("Codigo de rol es requerido");
            util.alerta(msg, 2);
            return false;
        }
        return true;
    }


    /**
     * Inserta/Actualiza un usuario en la bd
     *
     * @throws Exception Error generico
     */
    public final void guardarUsuario() throws Exception {
        msg = new StringBuilder();
        try {
            if (validaInputs()) {
                password = Encriptar.getStringMessageDigest(password, Encriptar.SHA1);
                usuario.setPass(password);
                usuario.setCodrol(new Rol(codrol));
                cRUD.guardarEntidad(usuario);
                msg.append("Usuario guardado con exito");                
                util.alerta(msg, 1);
                limpiarPantalla();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en guardarUsuario():", e);
            msg.append("Error al guardar un usuario, consulte a IT");
            util.alerta(msg, 3);
        }
    }

    /**
     * Elimina un usuario de la bd
     *
     * @throws Exception Error generico
     */
    public final void eliminarUsuario() throws Exception {
        msg = new StringBuilder();
        try {
            if (usuario.getCodusr() != null) {
                cRUD.eliminarEntidad(usuario);
                msg.append("Usuario eliminado con exito");
                util.alerta(msg, 1);
                limpiarPantalla();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en eliminarUsuario():", e);
            msg.append("Error al eliminar un usuario, consulte a IT");
            util.alerta(msg, 3);
        }
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor"> 
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    //</editor-fold>
}
