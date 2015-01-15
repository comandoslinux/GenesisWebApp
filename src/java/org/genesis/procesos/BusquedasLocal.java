/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.procesos;

import java.util.List;
import javax.ejb.Local;
import org.genesis.entidades.Estddonacion;
import org.genesis.entidades.Rol;
import org.genesis.entidades.Umedida;
import org.genesis.entidades.Usuario;
import org.genesis.entidades.VExistenciasProd;

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
    
    /**
     * Retorna una lista de um
     *
     * @return List - Lista de UM
     * @throws Exception Error generico
     */
    List<Umedida> listaUM() throws Exception;

    /**
     * Hace una busqueda de productos que se encuentran almacenados.
     * 
     * @param codproducto producto a buscar.
     * @return lista de productos.
     * @throws Exception Error generico.
     */
    List<VExistenciasProd> consultaProductos(final String codproducto)
            throws Exception;
    
    /**
     * Retorna todos los registros de la entidad Estddonacion.
     * 
     * @return Lista de objetos de entidad Estddonacion.
     * @throws Exception Error generico.
     */
    List<Estddonacion> listaEstDona() throws Exception;
}
