package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Donante;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-11T21:34:25")
@StaticMetamodel(Tpdonante.class)
public class Tpdonante_ { 

    public static volatile SingularAttribute<Tpdonante, String> nombre;
    public static volatile SingularAttribute<Tpdonante, String> codtpdonante;
    public static volatile SingularAttribute<Tpdonante, String> descripcion;
    public static volatile ListAttribute<Tpdonante, Donante> donanteList;

}