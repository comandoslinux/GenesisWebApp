package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Donaciondeta;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-11T21:34:25")
@StaticMetamodel(Estdprdto.class)
public class Estdprdto_ { 

    public static volatile SingularAttribute<Estdprdto, String> nombre;
    public static volatile SingularAttribute<Estdprdto, String> codstdprdto;
    public static volatile ListAttribute<Estdprdto, Donaciondeta> donaciondetaList;
    public static volatile SingularAttribute<Estdprdto, String> descripcion;

}