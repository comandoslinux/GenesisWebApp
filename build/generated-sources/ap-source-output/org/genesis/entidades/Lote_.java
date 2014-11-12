package org.genesis.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Donaciondeta;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-11T21:34:25")
@StaticMetamodel(Lote.class)
public class Lote_ { 

    public static volatile SingularAttribute<Lote, String> nombre;
    public static volatile ListAttribute<Lote, Donaciondeta> donaciondetaList;
    public static volatile SingularAttribute<Lote, String> descripcion;
    public static volatile SingularAttribute<Lote, Date> fechavencimto;
    public static volatile SingularAttribute<Lote, Integer> codlote;

}