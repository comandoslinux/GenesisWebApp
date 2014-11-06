/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.procesos;

import java.util.List;
import javax.ejb.Local;
import org.genesis.entidades.Rol;
import org.genesis.entidades.Usuario;

/**
 *
 * @author orlando
 */
@Local
public interface BusquedasLocal {

    /**
     * Retorna una lista de roles
     *
     * @return List - Lista Roles
     * @throws Exception Error generico
     */
    List<Rol> listaRoles() throws Exception;

    /**
     * Retorna una lista de usuarios
     *
     * @return List - Lista Usuarios
     * @throws Exception Error generico
     */
    List<Usuario> listaUsers() throws Exception;

}
