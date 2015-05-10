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
import org.genesis.entidades.Producto;
import org.genesis.entidades.Rol;
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
@ManagedBean(name = "producto")
@ViewScoped
public class ProductoBean implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Llamado a los EJB'S">     
    @EJB
    private BusquedasLocal busquedas;     
    @EJB
    private CRUDLocal cRUD;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Variables"> 
    //Variable para mensajes del dialogo
    private StringBuilder msg = new StringBuilder();
    //Variable para almacenar la um seleccionada del combo
    private String codUM;
    //Bandera btn Eliminar
    private boolean banBtnEli = false;
    //Bandera activar/desactivar pk
    private boolean banpk = false;
    //Utilidades varias
    private UtilidadesVarias util = Util.buscarBean("util");
    //Bitacora de logs
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    //Entidad Producto
    private Producto prod = new Producto();
    //Lista de productos
    private List<Producto> lstProductos = new ArrayList();
    //Lista de roles a mostrar en el combo
    private List<Umedida> lstUms = new ArrayList();
    //Datatable para Producto
    private DataTable tblProd = new DataTable();
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

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public List<Producto> getLstProductos() throws Exception {
        lstProductos = busquedas.listaProducto();
        return lstProductos;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public DataTable getTblProd() {
        return tblProd;
    }

    public void setTblProd(DataTable tblProd) {
        this.tblProd = tblProd;
    }

    public String getCodUM() {
        return codUM;
    }

    public void setCodUM(String codUM) {
        this.codUM = codUM;
    }

    public List<Umedida> getLstUms() throws Exception {
        lstUms = busquedas.listaUM();
        return lstUms;
    }

    public void setLstUms(List<Umedida> lstUms) {
        this.lstUms = lstUms;
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
        if (prod.getCodprdto().isEmpty()) {
            msg.append(" Codigo de producto es requerido. ");
            util.alerta(msg, 2);
            return false;
        }
        if (prod.getNombre().isEmpty()) {
            msg.append(" Nombre de producto es requerido. ");
            util.alerta(msg, 2);
            return false;
        }
        if (codUM.equals("-")) {
            msg.append(" Codigo de UM es requerido. ");
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
        prod = new Producto();
        banBtnEli = false;
        banpk = false;

    }

    /**
     * Inserta/Actualiza un registro en la bd.
     *
     * @throws Exception Error generico
     */
    public void guardarProd() throws Exception {
        msg = new StringBuilder();
        if (validaInputs()) {
            try {
                prod.setCodum(new Umedida(codUM));
                cRUD.guardarEntidad(prod);
                msg.append(" Registro guardado con exito. ");
                util.alerta(msg, 1);
                limpiarPantalla();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error en guardarProd():", e);
                msg.append("Error al guardar la el registro, consulte a IT");
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
            if (tblProd.getRowData() != null) {
                cRUD.eliminarEntidad(tblProd.getRowData());
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en btnEliminarLinea():", e);
            msg.append("Error al eliminar la um, consulte a alguien de IT");
            util.alerta(msg, 3);
        }

    }
    
    /**
     * Elimina un registro de la base de datos.
     * 
     * @throws Exception Error generico.
     */
    public void eliminarProd() throws Exception {
        msg = new StringBuilder();
        try {
            if (prod != null) {
                cRUD.eliminarEntidad(prod);
                limpiarPantalla();
            } else {
                msg.append("No hay nada que eliminar");
                util.alerta(msg, 2);
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en eliminarProd():", e);
            msg.append("Error al eliminar la um, consulte a IT");
            util.alerta(msg, 3);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructor">  
    /**
     * Creates a new instance of UmedidaBean
     */
    public ProductoBean() {
    }

    //</editor-fold>
}
