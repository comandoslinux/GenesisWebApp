package org.genesis.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Donaciondeta;
import org.genesis.entidades.Donante;
import org.genesis.entidades.Estddonacion;
import org.genesis.entidades.Usuario;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-04T20:31:33")
@StaticMetamodel(Donacion.class)
public class Donacion_ { 

    public static volatile SingularAttribute<Donacion, Integer> codcorredncn;
    public static volatile SingularAttribute<Donacion, String> concepto;
    public static volatile SingularAttribute<Donacion, Estddonacion> codstddncn;
    public static volatile ListAttribute<Donacion, Donaciondeta> donaciondetaList;
    public static volatile SingularAttribute<Donacion, Date> fingreso;
    public static volatile SingularAttribute<Donacion, Usuario> codusr;
    public static volatile SingularAttribute<Donacion, Date> frecepcion;
    public static volatile SingularAttribute<Donacion, Donante> coddnte;

}