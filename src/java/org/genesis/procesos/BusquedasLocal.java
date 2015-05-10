/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.procesos;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;
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
     * Trae todos los registros de la bd para dicha entidad.
     * 
     * @return lista de Tpdonante,
     * @throws Exception Error generico.
     */
    List<Tpdonante> listaTpDonantes() throws Exception;
    
    /**
     * Trae todos los registros de la bd para dicha entidad.
     * 
     * @return lista de Donantes.
     * @throws Exception Error generico.
     */
    List<Donante> listaDonantes() throws Exception;
    
    /**
     * Trae todos los registros de la bd para dicha entidad.
     * 
     * @return lista de Beneficiarios.
     * @throws Exception Error generico.
     */
    List<Beneficiario> listaBenefi() throws Exception;
    
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
    
    /**
     * Retorna todos los registros de la entidad Estdprdto.
     * 
     * @return Lista de objetos de entidad Estdprdto.
     * @throws Exception Error generico.
     */
    List<Estdprdto> listaEstadProd() throws Exception;
    
    /**
     * Retorna todos los registros de la entidad Lote.
     * 
     * @return Lista de objetos de entidad Lote.
     * @throws Exception Error generico.
     */
    List<Lote> listaLote() throws Exception;
    
    /**
     * Retorna todos los registros de la entidad Propiedad.
     * 
     * @return Lista de objetos de entidad Propiedad.
     * @throws Exception Error generico.
     */
    List<Propiedad> listaPropiedad() throws Exception;
    
    /**
     * Retorna todos los registros de la entidad Producto.
     * 
     * @return Lista de objetos de entidad Producto.
     * @throws Exception Error generico.
     */
    List<Producto> listaProducto() throws Exception;
    
    /**
     * Busca el ultimo codigo correlativo usado en Donacion.
     *
     * @return El ultimo correlativo.
     * @throws java.lang.Exception Error generico.
     */
    BigInteger buscarCorrDonacion() throws Exception;
    
    /**
     * Busca una donacion especifica.
     * 
     * @param nodonacion Numero de donacion a buscar.
     * @return Donacion buscada.
     * @throws Exception Error generico.
     */
    List<Donacion> buscarDonacion(BigInteger nodonacion) throws Exception;
    
    /**
     * Busca un detalle de  donacion especifica.
     * 
     * @param nodonaciondeta Numero de detalle de donacion a buscar.
     * @return Detalle de donacion buscada.
     * @throws Exception Error generico.
     */
    List<Donaciondeta> buscarDonacionDeta(BigInteger nodonaciondeta) throws Exception;
}
