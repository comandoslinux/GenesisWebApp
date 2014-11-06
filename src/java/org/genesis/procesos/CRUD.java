/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.procesos;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author orlando
 */
@Stateful
public class CRUD implements CRUDLocal {

    @PersistenceContext(unitName = "GenesisWebAppPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /**
     * Guarda una entidad generica en la bd
     *
     * @param <T> Generico
     * @param entidad Entidad a persistir/actualizar
     * @return Una entidad
     * @throws Exception Error generico
     */
    @Override
    public <T> T guardarEntidad(Object entidad) throws Exception {
        if (entidad == null) {
            return null;
        }
        T t = (T) em.merge(entidad);
        return t;
    }

    /**
     * Busca una entidad generica
     *
     * @param <T> Generico
     * @param clazz Clase
     * @param pk Llave primaria
     * @return Entidad buscada
     * @throws Exception Error generico
     */
    @Override
    public <T> T buscarEntidad(Class clazz, Object pk) throws Exception {
        if (clazz == null || pk == null) {
            return null;
        }
        return (T) em.find(clazz, pk);
    }

    /**
     * Elimina una entidad generica
     *
     * @param entidad Entidad a eliminar
     * @return Verdadero en caso de eliminar
     * @throws java.lang.Exception Error generico
     */
    @Override
    public boolean eliminarEntidad(Object entidad) throws Exception {

        boolean ok = false;
        if (entidad == null) {
            return ok;
        }
        em.remove(em.merge(entidad));
        ok = true;
        return ok;
    }
}
