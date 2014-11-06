package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Almacen;
import org.genesis.entidades.AlmacendetaPK;
import org.genesis.entidades.Producto;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-04T20:31:33")
@StaticMetamodel(Almacendeta.class)
public class Almacendeta_ { 

    public static volatile SingularAttribute<Almacendeta, Almacen> codalmacen;
    public static volatile SingularAttribute<Almacendeta, Double> cantidadprdto;
    public static volatile SingularAttribute<Almacendeta, AlmacendetaPK> almacendetaPK;
    public static volatile SingularAttribute<Almacendeta, Producto> producto;

}