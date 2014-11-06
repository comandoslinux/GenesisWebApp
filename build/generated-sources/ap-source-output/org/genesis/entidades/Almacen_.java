package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Almacendeta;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-04T20:31:33")
@StaticMetamodel(Almacen.class)
public class Almacen_ { 

    public static volatile SingularAttribute<Almacen, String> nombre;
    public static volatile SingularAttribute<Almacen, String> codalmacen;
    public static volatile ListAttribute<Almacen, Almacendeta> almacendetaList;
    public static volatile SingularAttribute<Almacen, String> descripcion;

}