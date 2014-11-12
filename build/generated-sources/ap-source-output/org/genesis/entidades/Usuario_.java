package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Donacion;
import org.genesis.entidades.Rol;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-11T21:34:25")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile SingularAttribute<Usuario, Integer> codusr;
    public static volatile ListAttribute<Usuario, Donacion> donacionList;
    public static volatile SingularAttribute<Usuario, String> pass;
    public static volatile SingularAttribute<Usuario, Rol> codrol;

}