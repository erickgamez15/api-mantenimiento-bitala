package com.bitala.apiprueba.models;

import java.sql.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "anomalias")
@EntityListeners(AuditingEntityListener.class)
public class Anomalias {
    
    @Id
    @Column(name = "id_anomalia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnomalia;

    private Long idUnidad;
    private Long idChofer;
    private Long idMantenimiento;
    private String anomalia;
    private String descripcion;
    
    @Temporal(TemporalType.DATE)//Agrega solo la fecha, sin la hora
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    private String estatus = "pendiente";

    public Anomalias(){

    }

    //Constructor para inicializar variables
    public Anomalias(Long idAnomalia, Long idUnidad, Long idChofer, Long idMantenimiento, String anomalia, String descripcion, Date fecha, String estatus){
        this.idAnomalia = idAnomalia;
        this.idUnidad = idUnidad;
        this.idChofer = idChofer;
        this.idMantenimiento = idMantenimiento;
        this.anomalia = anomalia;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estatus = estatus;
    }

    public Long getIdAnomalia() {
        return idAnomalia;
    }

    public void setIdAnomalia(Long idAnomalia) {
        this.idAnomalia = idAnomalia;
    }

    public Long getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Long idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Long getIdChofer() {
        return idChofer;
    }

    public void setIdChofer(Long idChofer) {
        this.idChofer = idChofer;
    }

    public Long getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Long idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getAnomalia() {
        return anomalia;
    }

    public void setAnomalia(String anomalia) {
        this.anomalia = anomalia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Anomalias [idAnomalia=" + idAnomalia + ", idUnidad=" + idUnidad + ", idChofer=" + idChofer + ", idMantenimiento=" + idMantenimiento + ", anomalia=" + anomalia + ", descripcion=" + descripcion + ", fecha=" + fecha + ", estatus=" + estatus + "]";
    }
}
