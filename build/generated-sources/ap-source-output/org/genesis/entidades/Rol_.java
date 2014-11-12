package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Usuario;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-11T21:34:25")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> nombre;
    public static volatile ListAttribute<Rol, Usuario> usuarioList;
    public static volatile SingularAttribute<Rol, String> descripcion;
    public static volatile SingularAttribute<Rol, String> codrol;

}