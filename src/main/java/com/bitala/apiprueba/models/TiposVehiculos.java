package com.bitala.apiprueba.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos_vehiculos")
@EntityListeners(AuditingEntityListener.class)
public class TiposVehiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;

    private String tipo_vehiculo;

    public TiposVehiculos() {
    }

    public TiposVehiculos(Long idVehiculo, String tipo_vehiculo) {
        this.idVehiculo = idVehiculo;
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    @Override
    public String toString() {
        return "TiposVehiculos [idVehiculo=" + idVehiculo + ", tipo_vehiculo=" + tipo_vehiculo + "]";
    }
}
