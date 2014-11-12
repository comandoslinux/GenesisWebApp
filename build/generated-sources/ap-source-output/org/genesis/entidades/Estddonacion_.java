package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Donacion;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-11T21:34:25")
@StaticMetamodel(Estddonacion.class)
public class Estddonacion_ { 

    public static volatile SingularAttribute<Estddonacion, String> nombre;
    public static volatile SingularAttribute<Estddonacion, String> codstddncn;
    public static volatile SingularAttribute<Estddonacion, String> descripcion;
    public static volatile ListAttribute<Estddonacion, Donacion> donacionList;

}