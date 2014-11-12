package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Almacendeta;
import org.genesis.entidades.Donaciondeta;
import org.genesis.entidades.Salidadeta;
import org.genesis.entidades.Umedida;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-11T21:34:25")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile ListAttribute<Producto, Donaciondeta> donaciondetaList;
    public static volatile ListAttribute<Producto, Almacendeta> almacendetaList;
    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Umedida> codum;
    public static volatile ListAttribute<Producto, Salidadeta> salidadetaList;
    public static volatile SingularAttribute<Producto, String> codprdto;

}