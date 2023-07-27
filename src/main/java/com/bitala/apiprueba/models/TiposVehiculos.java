package com.bitala.apiprueba.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos_vehiculos")
@EntityListeners(AuditingEntityListener.class)
public class TiposVehiculos {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) <--en la base de datos no es incrementable. Descommentar cuando se modifuque eso.
    @Column(name = "id_vehiculo")
    private Long idVehiculo;

    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;

    public TiposVehiculos() {
    }

    public TiposVehiculos(Long idVehiculo, String tipoVehiculo) {
        this.idVehiculo = idVehiculo;
        this.tipoVehiculo = tipoVehiculo;
    }

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

    @Override
    public String toString() {
        return "TiposVehiculos [idVehiculo=" + idVehiculo + ", tipoVehiculo=" + tipoVehiculo + "]";
    }
}
