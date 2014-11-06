package org.genesis.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Beneficiario;
import org.genesis.entidades.Salidadeta;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-04T20:31:33")
@StaticMetamodel(Salida.class)
public class Salida_ { 

    public static volatile SingularAttribute<Salida, Integer> codsalida;
    public static volatile SingularAttribute<Salida, String> concepto;
    public static volatile SingularAttribute<Salida, Date> fechasalida;
    public static volatile ListAttribute<Salida, Salidadeta> salidadetaList;
    public static volatile SingularAttribute<Salida, Beneficiario> codbenef;

}