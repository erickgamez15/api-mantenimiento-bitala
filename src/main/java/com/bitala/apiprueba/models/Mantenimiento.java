package com.bitala.apiprueba.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - MANTENIMIENTO
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "mantenimiento")
@EntityListeners(AuditingEntityListener.class)
public class Mantenimiento {

    /* 
    CREATE TABLE `mantenimiento` (
		`id_mantenimiento` int(11) NOT NULL,
		`id_unidad` int(11) NOT NULL,
		`fecha_solicitada` datetime DEFAULT NULL,
		`fecha_entrega` datetime DEFAULT NULL,
		`estatus` varchar(45) DEFAULT NULL,
		`observacion` text DEFAULT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */

    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_mantenimiento")
    private Long idMantenimento;

    @Column(name = "id_unidad")
    private Long idUnidad;

    @Column(name = "fecha_solicitada")
    private Date fechaSolicitada;

    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    private String estatus;
    private String observacion;

    public Mantenimiento() {

    }

    //Constructor para inicializar variables
    public Mantenimiento(Long idMantenimento, Long idUnidad, Date fechaSolicitada, Date fechaEntrega, String estatus, String observacion) {
        this.idMantenimento = idMantenimento;
        this.idUnidad = idUnidad;
        this.fechaSolicitada = fechaSolicitada;
        this.fechaEntrega = fechaEntrega;
        this.estatus = estatus;
        this.observacion = observacion;
    }

    //Metodos Get y Set
    public Long getIdMantenimento() {
        return idMantenimento;
    }

    public void setIdMantenimento(Long idMantenimento) {
        this.idMantenimento = idMantenimento;
    }

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Date getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(Date fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Mantenimiento [idMantenimento=" + idMantenimento + ", idUnidad=" + idUnidad + ", fechaSolicitada=" + fechaSolicitada + ", fechaEntrega=" + fechaEntrega + ", estatus=" + estatus + ", observacion=" + observacion + "]";
    } 
}
