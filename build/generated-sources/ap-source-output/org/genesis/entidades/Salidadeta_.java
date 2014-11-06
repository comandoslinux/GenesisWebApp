package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Producto;
import org.genesis.entidades.Salida;
import org.genesis.entidades.SalidadetaPK;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-04T20:31:33")
@StaticMetamodel(Salidadeta.class)
public class Salidadeta_ { 

    public static volatile SingularAttribute<Salidadeta, Salida> codsalida;
    public static volatile SingularAttribute<Salidadeta, Double> cantidadprdto;
    public static volatile SingularAttribute<Salidadeta, Producto> producto;
    public static volatile SingularAttribute<Salidadeta, SalidadetaPK> salidadetaPK;

}