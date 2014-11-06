package org.genesis.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.genesis.entidades.Donacion;
import org.genesis.entidades.DonaciondetaPK;
import org.genesis.entidades.Estdprdto;
import org.genesis.entidades.Lote;
import org.genesis.entidades.Producto;
import org.genesis.entidades.Propiedad;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-11-04T20:31:33")
@StaticMetamodel(Donaciondeta.class)
public class Donaciondeta_ { 

    public static volatile SingularAttribute<Donaciondeta, DonaciondetaPK> donaciondetaPK;
    public static volatile SingularAttribute<Donaciondeta, Donacion> codcorredncn;
    public static volatile SingularAttribute<Donaciondeta, Estdprdto> codstdprdto;
    public static volatile SingularAttribute<Donaciondeta, Double> cantidad;
    public static volatile SingularAttribute<Donaciondeta, Producto> producto;
    public static volatile SingularAttribute<Donaciondeta, String> vprpdad1;
    public static volatile SingularAttribute<Donaciondeta, Lote> codlote;
    public static volatile SingularAttribute<Donaciondeta, String> vprpdad2;
    public static volatile SingularAttribute<Donaciondeta, Propiedad> codprpdad;

}