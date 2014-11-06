package org.genesis.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Donacion;
import org.genesis.entidades.Tpdonante;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-04T20:31:33")
@StaticMetamodel(Donante.class)
public class Donante_ { 

    public static volatile SingularAttribute<Donante, String> nombre;
    public static volatile SingularAttribute<Donante, String> direccion;
    public static volatile SingularAttribute<Donante, String> dui;
    public static volatile SingularAttribute<Donante, String> nit;
    public static volatile SingularAttribute<Donante, Tpdonante> codtpdonante;
    public static volatile SingularAttribute<Donante, Date> fingreso;
    public static volatile SingularAttribute<Donante, String> telefono;
    public static volatile ListAttribute<Donante, Donacion> donacionList;
    public static volatile SingularAttribute<Donante, Integer> coddnte;

}