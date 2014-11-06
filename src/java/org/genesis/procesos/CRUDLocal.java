/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.procesos;

import javax.ejb.Local;

/**
 *
 * @author orlando
 */
@Local
public interface CRUDLocal {

    /**
     * Guarda una entidad generica en la bd
     *
     * @param <T> Generico
     * @param entidad Entidad a persistir/actualizar
     * @return Una entidad
     * @throws Exception Error generico
     */
    <T> T guardarEntidad(Object entidad) throws Exception;

    /**
     * Busca una entidad generica
     *
     * @param <T> Generico
     * @param clazz Clase
     * @param pk Llave primaria
     * @return Entidad buscada
     * @throws Exception Error generico
     */
    < T> T buscarEntidad(final Class clazz, final Object pk) throws Exception;

    /**
     * Elimina una entidad generica
     *
     * @param entidad Entidad a eliminar
     * @return Verdadero en caso de eliminar
     * @throws java.lang.Exception Error generico
     */
    boolean eliminarEntidad(Object entidad) throws Exception;

}
