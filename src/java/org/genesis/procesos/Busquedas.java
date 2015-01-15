/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.procesos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.genesis.entidades.Estddonacion;
import org.genesis.entidades.Rol;
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
}
