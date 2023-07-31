package com.bitala.api.mantenimiento.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - ANOMALIAS
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "anomalias")
@EntityListeners(AuditingEntityListener.class)
public class Anomalias {

    /* 
    CREATE TABLE `anomalias` (
		`id_anomalia` int(11) NOT NULL,
		`id_unidad` int(11) NOT NULL,
		`id_chofer` int(11) NOT NULL,
		`id_mantenimiento` int(11) DEFAULT NULL,
		`anomalia` varchar(128) NOT NULL,
		`descripcion` text DEFAULT NULL,
		`fecha` date DEFAULT NULL,
        `estatus` varchar(16) DEFAULT 'pendiente'
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */

    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
    @Column(name = "id_anomalia")
    private Long idAnomalia;

    private Long idUnidad;
    private Long idChofer;
    private Long idMantenimiento;
    private String anomalia;
    private String descripcion;
    
    //Agrega solo la fecha, sin la hora
    @Temporal(TemporalType.DATE)
    //Formato de fecha
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    private String estatus;

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

    //Metodos Get y Set
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

    //Metodo toString
    @Override
    public String toString() {
        return "Anomalias [idAnomalia=" + idAnomalia + ", idUnidad=" + idUnidad + ", idChofer=" + idChofer + ", idMantenimiento=" + idMantenimiento + ", anomalia=" + anomalia + ", descripcion=" + descripcion + ", fecha=" + fecha + ", estatus=" + estatus + "]";
    }
}
