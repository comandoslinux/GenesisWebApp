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
import org.genesis.entidades.Rol;
import org.genesis.entidades.Usuario;

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

}
