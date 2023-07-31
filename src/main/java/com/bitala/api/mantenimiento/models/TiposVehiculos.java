package com.bitala.api.mantenimiento.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - TIPOSVEHICULOS
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "tipos_vehiculos")
@EntityListeners(AuditingEntityListener.class)
public class TiposVehiculos {

    /* 
    CREATE TABLE `tipos_vehiculos` (
		`id_vehiculo` int(11) NOT NULL,
		`tipo_vehiculo` varchar(128) NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
    
    //Indica que es la PK de la tabla
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) <-- en la base de datos no es incrementable. Descomentar cuando se modifique eso.
    //name sigue la nomenclatura de SQL
    @Column(name = "id_vehiculo")
    private Long idVehiculo;

    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;

    public TiposVehiculos() {

    }

    //Constructor para inicializar variables
    public TiposVehiculos(Long idVehiculo, String tipoVehiculo) {
        this.idVehiculo = idVehiculo;
        this.tipoVehiculo = tipoVehiculo;
    }

    //Metodos Get y Set
    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getTipo_vehiculo() {
        return tipoVehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipoVehiculo = tipo_vehiculo;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "TiposVehiculos [idVehiculo=" + idVehiculo + ", tipoVehiculo=" + tipoVehiculo + "]";
    }
}
