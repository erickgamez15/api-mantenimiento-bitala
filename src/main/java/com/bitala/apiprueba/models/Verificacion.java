package com.bitala.apiprueba.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - VERIFICACION
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "verificacion")
@EntityListeners(AuditingEntityListener.class)
public class Verificacion {

    /* 
    CREATE TABLE `verificacion` (
		`id_verificacion` int(11) NOT NULL,
		`id_mantenimiento` int(11) NOT NULL,
		`fecha_inicial` date NOT NULL,
		`fecha_checkeado` date DEFAULT NULL,
		`estatus` varchar(45) DEFAULT 'pendiente'
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */

    //Indica que es la PK de la tabla
    @Id
    //Para que sea autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //name sigue la nomenclatura de SQL
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

    //Constructor para inicializar variables
    public Verificacion(Long idVerificacion, Long idMantenimiento, Date fechaInicial, Date fechaCheckeado,String estatus) {
        this.idVerificacion = idVerificacion;
        this.idMantenimiento = idMantenimiento;
        this.fechaInicial = fechaInicial;
        this.fechaCheckeado = fechaCheckeado;
        this.estatus = estatus;
    }

    //Metodos Get y Set
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

    //Metodo toString
    @Override
    public String toString() {
        return "Verificacion [idVerificacion=" + idVerificacion + ", idMantenimiento=" + idMantenimiento + ", fechaInicial=" + fechaInicial + ", fechaCheckeado=" + fechaCheckeado + ", estatus=" + estatus + "]";
    }
}
