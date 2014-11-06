package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Producto;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-04T20:31:33")
@StaticMetamodel(Umedida.class)
public class Umedida_ { 

    public static volatile SingularAttribute<Umedida, String> nombre;
    public static volatile SingularAttribute<Umedida, String> codum;
    public static volatile SingularAttribute<Umedida, String> descripcion;
    public static volatile ListAttribute<Umedida, Producto> productoList;

}