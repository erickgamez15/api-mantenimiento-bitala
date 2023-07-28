package com.bitala.apiprueba.models;

import java.sql.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Table(name = "verificacion")
@EntityListeners(AuditingEntityListener.class)
public class Verificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_verificacion")
    private Long idVerificacion;

    @Column(name = "id_mantenimiento")
    private Long idMantenimiento;

    @Column(name = "fecha_inicial")
    private Date fechaInicial;

    @Column(name = "fecha_checkeado")
    private Date fechaCheckeado;

    private String estatus;

    public Verificacion() {

    }

    public Verificacion(Long idVerificacion, Long idMantenimiento, Date fechaInicial, Date fechaCheckeado,String estatus) {
        this.idVerificacion = idVerificacion;
        this.idMantenimiento = idMantenimiento;
        this.fechaInicial = fechaInicial;
        this.fechaCheckeado = fechaCheckeado;
        this.estatus = estatus;
    }

    public Long getIdVerificacion() {
        return idVerificacion;
    }

    public void setIdVerificacion(Long idVerificacion) {
        this.idVerificacion = idVerificacion;
    }

    public Long getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Long idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaCheckeado() {
        return fechaCheckeado;
    }

    public void setFechaCheckeado(Date fechaCheckeado) {
        this.fechaCheckeado = fechaCheckeado;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Verificacion [idVerificacion=" + idVerificacion + ", idMantenimiento=" + idMantenimiento + ", fechaInicial=" + fechaInicial + ", fechaCheckeado=" + fechaCheckeado + ", estatus=" + estatus + "]";
    }
}
