package com.bitala.api.mantenimiento.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - UNIDAD
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "unidad")
@EntityListeners(AuditingEntityListener.class)
public class Unidad {

    /* 
    CREATE TABLE `unidad` (
		`id_unidad` int(11) NOT NULL,
		`id_empresa` int(11)NOT NULL,
		`id_vehiculo` int(11) NOT NULL,
		`id_control_vehicular` int(11) NOT NULL,
		`clave` varchar(16) DEFAULT 'S/S',
		`marca` varchar(128) NOT NULL,
		`modelo` varchar(128) NOT NULL,
		`anio` varchar(16) NOT NULL,
		`motor` varchar(32) NOT NULL,
		`vin` varchar(128) DEFAULT 'S/V',
		`placas` varchar(32) DEFAULT 'S/P',
		`estatus` varchar(45) DEFAULT 'correcto',
		`foto_unidad` varchar(45) DEFAULT 'unidad_default.png'
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */

    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_unidad")
    private Long idUnidad;

    @Column(name = "id_empresa")
    private Long idEmpresa;

    @Column(name = "id_vehiculo")
    private Long idVehiculo;

    @Column(name = "id_control_vehicular")
    private Long idControlVehicular;

    private String clave;
    private String marca;
    private String modelo;
    private String anio;
    private String motor;
    private String vin;
    private String placas;
    private String estatus;

    @Column(name = "foto_unidad")
    private String fotoUnidad;

    public Unidad() {

    }

    //Constructor para inicializar variables
    public Unidad(Long idUnidad, Long idEmpresa, Long idVehiculo, Long idControlVehicular, String clave, String marca, String modelo, String anio, String motor, String vin, String placas, String estatus, String fotoUnidad) {
        this.idUnidad = idUnidad;
        this.idEmpresa = idEmpresa;
        this.idVehiculo = idVehiculo;
        this.idControlVehicular = idControlVehicular;
        this.clave = clave;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.motor = motor;
        this.vin = vin;
        this.placas = placas;
        this.estatus = estatus;
        this.fotoUnidad = fotoUnidad;
    }

    //Metodos Get y Set
    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Long getIdControlVehicular() {
        return idControlVehicular;
    }

    public void setIdControlVehicular(Long idControlVehicular) {
        this.idControlVehicular = idControlVehicular;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getFotoUnidad() {
        return fotoUnidad;
    }

    public void setFotoUnidad(String fotoUnidad) {
        this.fotoUnidad = fotoUnidad;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Unidad [idUnidad=" + idUnidad + ", idEmpresa=" + idEmpresa + ", idVehiculo=" + idVehiculo + ", idControlVehicular=" + idControlVehicular + ", clave=" + clave + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", motor=" + motor + ", vin=" + vin + ", placas=" + placas + ", estatus=" + estatus + ", fotoUnidad=" + fotoUnidad + "]";
    } 
}
