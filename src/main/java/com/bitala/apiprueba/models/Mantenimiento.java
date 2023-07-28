package com.bitala.apiprueba.models;

import java.sql.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Table(name = "mantenimiento")
@EntityListeners(AuditingEntityListener.class)
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Mantenimiento(Long idMantenimento, Long idUnidad, Date fechaSolicitada, Date fechaEntrega, String estatus, String observacion) {
        this.idMantenimento = idMantenimento;
        this.idUnidad = idUnidad;
        this.fechaSolicitada = fechaSolicitada;
        this.fechaEntrega = fechaEntrega;
        this.estatus = estatus;
        this.observacion = observacion;
    }

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

    @Override
    public String toString() {
        return "Mantenimiento [idMantenimento=" + idMantenimento + ", idUnidad=" + idUnidad + ", fechaSolicitada=" + fechaSolicitada + ", fechaEntrega=" + fechaEntrega + ", estatus=" + estatus + ", observacion=" + observacion + "]";
    } 
}
