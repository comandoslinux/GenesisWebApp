//<editor-fold defaultstate="collapsed" desc="Imports">

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.controladores;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.genesis.entidades.Donacion;
import org.genesis.entidades.Donaciondeta;
import org.genesis.entidades.DonaciondetaPK;
import org.genesis.entidades.Donante;
import org.genesis.entidades.Estddonacion;
import org.genesis.entidades.Estdprdto;
import org.genesis.entidades.Lote;
import org.genesis.entidades.Producto;
import org.genesis.entidades.Propiedad;
import org.genesis.entidades.Usuario;
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

@ManagedBean
@ViewScoped
public class DonacionBean implements Serializable {
    
    //<editor-fold defaultstate="collapsed" desc="Llamado a los ejbs">
    @EJB
    private BusquedasLocal busquedas;
    @EJB
    private CRUDLocal cRUD;   
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private Donacion encaDonacion = new Donacion();
    private Donaciondeta donadeta = new Donaciondeta();
    private List<Donacion> lstDonaciones = new ArrayList();
    private List<Donaciondeta> lstDonacionesdeta = new ArrayList();
    private List<Estddonacion> lstEstdDonacion = new ArrayList();
    private List<Usuario> lstUsers = new ArrayList();
    private List<Donante> lstDonante = new ArrayList();
    private List<Donaciondeta> lstDonadeta = new ArrayList<Donaciondeta>();
    private List<Producto> lstProducto = new ArrayList();
    private List<Estdprdto> lstEstadProdu = new ArrayList();
    private List<Propiedad> lstPropiedad = new ArrayList();
    private List<Lote> lstLote = new ArrayList();
    private BigInteger correlativoDonaDeta = new BigInteger("0");
    private Double cantidad;
    private Integer coduser;
    private Integer coddonante;
    private Integer codLote;
    private BigInteger numeroDona;
    private String codstddonacion;
    private String codproducto;
    private String propiedad1;
    private String propiedad2;
    private String codpropiedad;
    private String codStdoprodu;
    //Variable para mensajes del dialogo.
    private StringBuilder msg = new StringBuilder();
    //Bandera para activar/desactivar boton de agregar detalle
    private boolean banActDesacDeta = true;
    //Bandera para activar/desactivar el boton guardar
    private boolean banBotonGuardar = true;
    //Utilidades varias.
    private UtilidadesVarias util = Util.buscarBean("util");
    //Bitacora de logs.
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    //Datatable de donaciondeta
    private DataTable tblDonadeta = new DataTable();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public List<Donaciondeta> getLstDonacionesdeta() {
        return lstDonacionesdeta;
    }

    public void setLstDonacionesdeta(List<Donaciondeta> lstDonacionesdeta) {
        this.lstDonacionesdeta = lstDonacionesdeta;
    }

    public List<Donacion> getLstDonaciones() {
        return lstDonaciones;
    }

    public void setLstDonaciones(List<Donacion> lstDonaciones) {
        this.lstDonaciones = lstDonaciones;
    }

    public BigInteger getNumeroDona() {
        return numeroDona;
    }

    public void setNumeroDona(BigInteger numeroDona) {
        this.numeroDona = numeroDona;
    }

    public boolean isBanActDesacDeta() {
        return banActDesacDeta;
    }

    public void setBanActDesacDeta(boolean banActDesacDeta) {
        this.banActDesacDeta = banActDesacDeta;
    }

    public BigInteger getCorrelativo() {
        return correlativoDonaDeta;
    }

    public void setCorrelativo(BigInteger correlativo) {
        this.correlativoDonaDeta = correlativo;
    }

    public Donacion getEncaDonacion() {
        return encaDonacion;
    }

    public void setEncaDonacion(Donacion encaDonacion) {
        this.encaDonacion = encaDonacion;
    }

    public Integer getCoduser() {
        return coduser;
    }

    public void setCoduser(Integer coduser) {
        this.coduser = coduser;
    }

    public Integer getCoddonante() {
        return coddonante;
    }

    public void setCoddonante(Integer coddonante) {
        this.coddonante = coddonante;
    }

    public String getCodstddonacion() {
        return codstddonacion;
    }

    public void setCodstddonacion(String codstddonacion) {
        this.codstddonacion = codstddonacion;
    }

    public List<Estddonacion> getLstEstdDonacion() throws Exception {
        lstEstdDonacion = busquedas.listaEstDona();
        return lstEstdDonacion;
    }

    public void setLstEstdDonacion(List<Estddonacion> lstEstdDonacion) {
        this.lstEstdDonacion = lstEstdDonacion;
    }

    public List<Usuario> getLstUsers() throws Exception {
        lstUsers = busquedas.listaUsers();
        return lstUsers;
    }

    public void setLstUsers(List<Usuario> lstUsers) {
        this.lstUsers = lstUsers;
    }

    public List<Donante> getLstDonante() throws Exception {
        lstDonante = busquedas.listaDonantes();
        return lstDonante;
    }

    public void setLstDonante(List<Donante> lstDonante) {
        this.lstDonante = lstDonante;
    }

    public Donaciondeta getDonadeta() {
        return donadeta;
    }

    public void setDonadeta(Donaciondeta donadeta) {
        this.donadeta = donadeta;
    }

    public List<Donaciondeta> getLstDonadeta() {
        return lstDonadeta;
    }

    public void setLstDonadeta(List<Donaciondeta> lstDonadeta) {
        this.lstDonadeta = lstDonadeta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getCorrelativoDonaDeta() {
        return correlativoDonaDeta;
    }

    public void setCorrelativoDonaDeta(BigInteger correlativoDonaDeta) {
        this.correlativoDonaDeta = correlativoDonaDeta;
    }

    public Integer getCodLote() {
        return codLote;
    }

    public void setCodLote(Integer codLote) {
        this.codLote = codLote;
    }

    public String getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(String codproducto) {
        this.codproducto = codproducto;
    }

    public String getPropiedad1() {
        return propiedad1;
    }

    public void setPropiedad1(String propiedad1) {
        this.propiedad1 = propiedad1;
    }

    public String getPropiedad2() {
        return propiedad2;
    }

    public void setPropiedad2(String propiedad2) {
        this.propiedad2 = propiedad2;
    }

    public String getCodpropiedad() {
        return codpropiedad;
    }

    public void setCodpropiedad(String codpropiedad) {
        this.codpropiedad = codpropiedad;
    }

    public String getCodStdoprodu() {
        return codStdoprodu;
    }

    public void setCodStdoprodu(String codStdoprodu) {
        this.codStdoprodu = codStdoprodu;
    }

    public List<Producto> getLstProducto() throws Exception {
        lstProducto = busquedas.listaProducto();
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public List<Estdprdto> getLstEstadProdu() throws Exception {
        lstEstadProdu = busquedas.listaEstadProd();
        return lstEstadProdu;
    }

    public void setLstEstadProdu(List<Estdprdto> lstEstadProdu) {
        this.lstEstadProdu = lstEstadProdu;
    }

    public List<Propiedad> getLstPropiedad() throws Exception {
        lstPropiedad = busquedas.listaPropiedad();
        return lstPropiedad;
    }

    public void setLstPropiedad(List<Propiedad> lstPropiedad) {
        this.lstPropiedad = lstPropiedad;
    }

    public List<Lote> getLstLote() throws Exception {
        lstLote = busquedas.listaLote();
        return lstLote;
    }

    public void setLstLote(List<Lote> lstLote) {
        this.lstLote = lstLote;
    }

    public StringBuilder getMsg() {
        return msg;
    }

    public void setMsg(StringBuilder msg) {
        this.msg = msg;
    }

    public boolean isBanBotonGuardar() {
        return banBotonGuardar;
    }

    public void setBanBotonGuardar(boolean banBotonGuardar) {
        this.banBotonGuardar = banBotonGuardar;
    }

    public DataTable getTblDonadeta() {
        return tblDonadeta;
    }

    public void setTblDonadeta(DataTable tblDonadeta) {
        this.tblDonadeta = tblDonadeta;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    
    /**
     * Limpia los valores ingresado en la pantalla
     */
    public void limpiarPantalla() {
        banActDesacDeta = true;
        banBotonGuardar = true;
        cantidad = null;
        coduser = null;
        codstddonacion = "";
        coddonante = null;
        encaDonacion = new Donacion();
        lstDonadeta.clear();
        correlativoDonaDeta = null;
    }

    /**
     * Agrega un nuevo correlativo de donacion
     *
     * @throws java.lang.Exception Error generico
     */
    public void agregarCorrDonacion() throws Exception {
        try {
            banActDesacDeta = false;
            encaDonacion.setCodcorredncn(busquedas.buscarCorrDonacion()
                    .add(new BigInteger("1")));
            encaDonacion.setDonaciondetaList(new ArrayList<Donaciondeta>());
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Agrega un nuevo producto con detalle
     *
     * @throws java.lang.Exception
     */
    public final void agregarDetalle() throws Exception {
        msg = new StringBuilder();
        try {
            if (!lstDonadeta.isEmpty()) {
                for (Donaciondeta d : lstDonadeta) {
                    if (d.getDonaciondetaPK().getCodprdto().equals(codproducto)) {
                        msg.append(" El producto ");
                        msg.append(codproducto);
                        msg.append(" ya se utilizo. ");
                        util.alerta(msg, 2);
                        return;
                    }
                }
            }
            correlativoDonaDeta = correlativoDonaDeta.add(new BigInteger("1"));
            donadeta = new Donaciondeta(
                    new DonaciondetaPK(correlativoDonaDeta, codproducto, 
                    encaDonacion.getCodcorredncn()));
            donadeta.setCodcorredncn(new Donacion(encaDonacion.getCodcorredncn()));
//            if(cantidad.intValue() == 0){
//                msg.append(" Cantidad no puede ser cero. ");
//                util.alerta(msg, 2);
//                return;
//            }
            donadeta.setCantidad(cantidad);
            donadeta.setVprpdad1(propiedad1);
            donadeta.setVprpdad2(propiedad2);
            donadeta.setCodprpdad(new Propiedad(codpropiedad));
            donadeta.setCodstdprdto(new Estdprdto(codStdoprodu));
            donadeta.setCodlote(new Lote(codLote));
            lstDonadeta.add(donadeta);
            banBotonGuardar = false;
            cantidad = null;
            propiedad1 = "";
            propiedad2 = "";
        } catch (Exception e) {
            throw e;
        }

    }
    
    /**
     * Elimina una linea del datatable de donaciondeta.
     * 
     * @throws Exception Error generico.
     */
    public void btnEliminarLinea() throws Exception {
        msg = new StringBuilder();
        try {
            if (tblDonadeta.getRowData() != null) {
                lstDonadeta.remove(donadeta);
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en btnEliminarLinea():", e);
            msg.append("Error al eliminar el la linea, consulte a alguien de IT");
            util.alerta(msg, 3);
        }
    }

    /**
     * Valida que los campos requeridos los ingrese el usuario.
     * 
     * @return true si los campos requeridos tienen algun dato.
     */
    public final boolean validarImpus() {

        msg = new StringBuilder();
        if (encaDonacion.getCodcorredncn().equals(new BigInteger("0"))) {
            msg.append(" Codigo de correlativo es requerido. ");
            util.alerta(msg, 2);
            return false;
        }
        if (encaDonacion.getConcepto().toString().isEmpty()) {
            msg.append(" Concepto es requerido. ");
            util.alerta(msg, 2);
            return false;
        }
        if (encaDonacion.getFingreso() == null) {
            msg.append(" Fecha de ingreso es requerida. ");
            util.alerta(msg, 2);
            return false;
        }
        if (lstDonadeta.isEmpty()) {
            msg.append(" Debe ingresar por lo menos un detalle.  ");
            util.alerta(msg, 2);
            return false;
        }

        return true;

    }

    /**
     * Guarda la donacion con su detalle en la base de datos.
     *
     * @throws java.lang.Exception Error generico.
     */
    public void guardarDonacion() throws Exception {

        msg = new StringBuilder();        
        if (validarImpus()) {

            try {
                List<Donaciondeta> lstTemp = new ArrayList();
                lstTemp.addAll(lstDonadeta);
                encaDonacion.getDonaciondetaList().clear();
                for (Donaciondeta dod : lstTemp) {
                    dod.setCodcorredncn(new Donacion(encaDonacion.getCodcorredncn()));
                    encaDonacion.getDonaciondetaList().add(dod);
                }
                encaDonacion.setCodstddncn(new Estddonacion(codstddonacion));
                encaDonacion.setCodusr(new Usuario(coduser));
                encaDonacion.setCoddnte(new Donante(coddonante));
                cRUD.guardarEntidad(encaDonacion);
                msg.append(" Donacion guardada con éxito! ");
                util.alerta(msg, 1);
                limpiarPantalla();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error en guardarDonacion():", e);
                msg.append(" Error al guardar el registro, consulte a IT. ");
                msg.append(e.getMessage());
                util.alerta(msg, 3);
                e.printStackTrace();
            }
        }

    }


    /**
     * Busca una donacion con su detalle
     * 
     * @throws Exception Error generico
     */
    public void buscarDonacion() throws Exception {
        msg = new StringBuilder();
        try {
            if (numeroDona != null && numeroDona != new BigInteger("0") ) {
                lstDonaciones = busquedas.buscarDonacion(numeroDona);
                buscarDonacionDeta();
                numeroDona = null;
            } else {     
                msg.append(" No hay nada que buscar ");
                util.alerta(msg, 2);
            }

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Busca el correlativo de donacion en Donaciondeta
     * 
     * @throws Exception Error generico
     */
    public void buscarDonacionDeta() throws Exception {
        try {
            if (numeroDona != null) {
                lstDonacionesdeta = busquedas.buscarDonacionDeta(numeroDona);
            }

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Limpia los filtros de busqueda
     */
    public void limpiarBusqueda() {
        numeroDona = null;
        lstDonaciones.clear();
        lstDonacionesdeta.clear();
    }

    /**
     * Creates a new instance of DonacionBean
     */
    public DonacionBean() {
    }
    //</editor-fold>
}
