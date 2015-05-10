/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.procesos;

import static com.sun.xml.ws.security.impl.policy.Constants.logger;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.genesis.entidades.Beneficiario;
import org.genesis.entidades.Donacion;
import org.genesis.entidades.Donaciondeta;
import org.genesis.entidades.Donante;
import org.genesis.entidades.Estddonacion;
import org.genesis.entidades.Estdprdto;
import org.genesis.entidades.Lote;
import org.genesis.entidades.Producto;
import org.genesis.entidades.Propiedad;
import org.genesis.entidades.Rol;
import org.genesis.entidades.Tpdonante;
import org.genesis.entidades.Umedida;
import org.genesis.entidades.Usuario;
import org.genesis.entidades.VExistenciasProd;

/**
 *
 * @author orlando
 */
@Stateless
public class Busquedas implements BusquedasLocal {

    @PersistenceContext(unitName = "GenesisWebAppPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /**
     * Retorna una lista de roles
     *
     * @return List - Lista Roles
     * @throws Exception Error generico
     */
    @Override
    public List<Rol> listaRoles() throws Exception {
        List<Rol> lstRol = null;
        Query q = em.createNamedQuery("Rol.findAll");
        lstRol = q.getResultList();
        return lstRol;
    }

    /**
     * Retorna una lista de usuarios
     *
     * @return List - Lista Usuarios
     * @throws Exception Error generico
     */
    @Override
    public List<Usuario> listaUsers() throws Exception {
        List<Usuario> lstUsers = null;
        Query q = em.createNamedQuery("Usuario.findAll");
        lstUsers = q.getResultList();
        return lstUsers;
    }
    
    /**
     * Trae todos los registros de la bd para dicha entidad.
     * 
     * @return lista de Tpdonante,
     * @throws Exception Error generico.
     */
    @Override
    public List<Tpdonante> listaTpDonantes() throws Exception {
        List<Tpdonante> lstTpDonantes = null;
        Query q = em.createNamedQuery("Tpdonante.findAll");
        lstTpDonantes = q.getResultList();
        return lstTpDonantes;
    }
    
    /**
     * Trae todos los registros de la bd para dicha entidad.
     * 
     * @return lista de Donantes.
     * @throws Exception Error generico.
     */
    @Override
    public List<Donante> listaDonantes() throws Exception {
        List<Donante> lstDonantes = null;
        Query q = em.createNamedQuery("Donante.findAll");
        lstDonantes = q.getResultList();
        return lstDonantes;
    }
    
    /**
     * Trae todos los registros de la bd para dicha entidad.
     * 
     * @return lista de Beneficiarios.
     * @throws Exception Error generico.
     */
    @Override
    public List<Beneficiario> listaBenefi() throws Exception {
        List<Beneficiario> lstBenefi = null;
        Query q = em.createNamedQuery("Beneficiario.findAll");
        lstBenefi = q.getResultList();
        return lstBenefi;
    }

    /**
     * Retorna una lista de Unidad de medida
     *
     * @return List - Lista de UM
     * @throws Exception Error generico
     */
    @Override
    public List<Umedida> listaUM() throws Exception {
        List<Umedida> lstUsers = null;
        Query q = em.createNamedQuery("Umedida.findAll");
        lstUsers = q.getResultList();
        return lstUsers;
    }

    /**
     * Hace una busqueda de productos que se encuentran almacenados.
     *
     * @param codproducto producto a buscar.
     * @return lista de productos.
     * @throws Exception Error generico.
     */
    @Override
    public List<VExistenciasProd> consultaProductos(final String codproducto)
            throws Exception {
        List<VExistenciasProd> lstExistProd = null;
        Query q = em.createNamedQuery("VExistenciasProd.findByCodprdto");
        if (!codproducto.isEmpty()) {
            q.setParameter("codprdto", "%"+ codproducto +"%");
        }
        lstExistProd = q.getResultList();
        return lstExistProd;
    }
    
    /**
     * Retorna todos los registros de la entidad Estddonacion.
     *
     * @return Lista de objetos de entidad Estddonacion.
     * @throws Exception Error generico.
     */
    @Override
    public List<Estddonacion> listaEstDona() throws Exception {
        List<Estddonacion> lstEstDona = null;
        Query q = em.createNamedQuery("Estddonacion.findAll");
        lstEstDona = q.getResultList();
        return lstEstDona;
    }
    
    /**
     * Retorna todos los registros de la entidad Estdprdto.
     * 
     * @return Lista de objetos de entidad Estdprdto.
     * @throws Exception 
     */
    @Override
    public List<Estdprdto> listaEstadProd() throws Exception {
        List<Estdprdto> lstEstdProdu = null;
        Query q = em.createNamedQuery("Estdprdto.findAll");
        lstEstdProdu = q.getResultList();
        return lstEstdProdu;
    }
    
    /**
     * Retorna todos los registros de la entidad Lote.
     * 
     * @return Lista de objetos de entidad Lote.
     * @throws Exception Error generico.
     */
    @Override
    public List<Lote> listaLote() throws Exception {
        List<Lote> lstLotes = null;
        Query q = em.createNamedQuery("Lote.findAll");
        lstLotes = q.getResultList();
        return lstLotes;
    }
    
    /**
     * Retorna todos los registros de la entidad Propiedad.
     *
     * @return Lista de objetos de entidad Propiedad.
     * @throws Exception Error generico.
     */
    @Override
    public List<Propiedad> listaPropiedad() throws Exception {
        List<Propiedad> lstPropiedad = null;
        Query q = em.createNamedQuery("Propiedad.findAll");
        lstPropiedad = q.getResultList();
        return lstPropiedad;
    }
    
    /**
     * Retorna todos los registros de la entidad Producto.
     * 
     * @return Lista de objetos de entidad Producto.
     * @throws Exception Error generico.
     */
    @Override
    public List<Producto> listaProducto() throws Exception {
        List<Producto> lstProducto = null;
        Query q = em.createNamedQuery("Producto.findAll");
        lstProducto = q.getResultList();
        return lstProducto;
    }
    
    /**
     * Busca el ultimo codigo correlativo usado en Donacion
     *
     * @return El ultimo correlativo.
     * @throws java.lang.Exception Error generico.
     */
    @Override
    public BigInteger buscarCorrDonacion() throws Exception {
        try {
            em.clear();
            Query q = em.createNamedQuery("Donacion.findLastID");
            BigInteger corr = (BigInteger) q.getSingleResult();
            if (corr == null) {
                corr = new BigInteger("0");
            }
            return corr;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Metodo buscarCorrDonacion(): " + ex);
            throw new Exception(ex);
        }
    }
    
    /**
     * Busca una donacion especifica.
     * 
     * @param nodonacion Numero de donacion a buscar.
     * @return Donacion buscada.
     * @throws Exception Error generico.
     */
    @Override
    public List<Donacion> buscarDonacion(BigInteger nodonacion) throws Exception {
        List<Donacion> lstDonacion = null;
        Query q = null;
        q = em.createNamedQuery("Donacion.findByCodcorredncn");
        if (nodonacion != null) {
            q.setParameter("codcorredncn", nodonacion);
        }
        lstDonacion = q.getResultList();
        return lstDonacion;
    }
    
    /**
     * Busca un detalle de  donacion especifica.
     * 
     * @param nodonaciondeta Numero de detalle de donacion a buscar.
     * @return Detalle de donacion buscada.
     * @throws Exception Error generico.
     */
    @Override
    public List<Donaciondeta> buscarDonacionDeta(BigInteger nodonaciondeta)
            throws Exception {
        List<Donaciondeta> lstDonaciondeta = null;
        Query q = null;
        q = em.createNamedQuery("Donaciondeta.findByCorrdona");
        if (nodonaciondeta != null) {
            q.setParameter("codcorredncn", nodonaciondeta);
        }
        lstDonaciondeta = q.getResultList();
        return lstDonaciondeta;
    }
    
}
