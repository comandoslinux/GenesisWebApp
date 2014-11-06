package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Salida;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-04T20:31:33")
@StaticMetamodel(Beneficiario.class)
public class Beneficiario_ { 

    public static volatile SingularAttribute<Beneficiario, String> nombrebene;
    public static volatile SingularAttribute<Beneficiario, String> direccion;
    public static volatile SingularAttribute<Beneficiario, String> email;
    public static volatile SingularAttribute<Beneficiario, String> dui;
    public static volatile SingularAttribute<Beneficiario, String> nit;
    public static volatile SingularAttribute<Beneficiario, String> telefono;
    public static volatile SingularAttribute<Beneficiario, Integer> codbenef;
    public static volatile SingularAttribute<Beneficiario, String> contactobene;
    public static volatile ListAttribute<Beneficiario, Salida> salidaList;

}