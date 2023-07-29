package com.bitala.apiprueba.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "control_vehicular")
@EntityListeners(AuditingEntityListener.class)
public class ControlVehicular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que sea autoincrementable
    @Column(name = "id_control_vehicular")
    private Long idControlVehicular;

    @Temporal(TemporalType.DATE) //Agrega solo la fecha, sin la hora
    @DateTimeFormat(pattern = "yyyy-MM-dd") //Formato de fecha
    @Column(name = "fecha_p_semestre")
    private Date fechaPSemestre;

    @Column(name = "doc_p_semestre")
    private String docPSemestre;

    @Column(name = "checked_pago_ps")
    private String checkedPagoPs;

    @Temporal(TemporalType.DATE) //Agrega solo la fecha, sin la hora
    @DateTimeFormat(pattern = "yyyy-MM-dd") //Formato de fecha
    @Column(name = "fecha_s_semestre")
    private Date fechaSSemestre;

    @Column(name = "doc_s_semestre")
    private String docSSemestre;

    @Column(name = "checked_pago_ss")
    private String checkedPagoSs;

    public ControlVehicular() {

    }

    //Constructor para inicializar variables
    public ControlVehicular(Long idControlVehicular, Date fechaPSemestre, String docPSemestre, String checkedPagoPs, Date fechaSSemestre, String docSSemestre, String checkedPagoSs) {
        this.idControlVehicular = idControlVehicular;
        this.fechaPSemestre = fechaPSemestre;
        this.docPSemestre = docPSemestre;
        this.checkedPagoPs = checkedPagoPs;
        this.fechaSSemestre = fechaSSemestre;
        this.docSSemestre = docSSemestre;
        this.checkedPagoSs = checkedPagoSs;
    }

    public Long getIdControlVehicular() {
        return idControlVehicular;
    }

    public void setIdControlVehicular(Long idControlVehicular) {
        this.idControlVehicular = idControlVehicular;
    }

    public Date getFechaPSemestre() {
        return fechaPSemestre;
    }

    public void setFechaPSemestre(Date fechaPSemestre) {
        this.fechaPSemestre = fechaPSemestre;
    }

    public String getDocPSemestre() {
        return docPSemestre;
    }

    public void setDocPSemestre(String docPSemestre) {
        this.docPSemestre = docPSemestre;
    }

    public String getCheckedPagoPs() {
        return checkedPagoPs;
    }

    public void setCheckedPagoPs(String checkedPagoPs) {
        this.checkedPagoPs = checkedPagoPs;
    }

    public Date getFechaSSemestre() {
        return fechaSSemestre;
    }

    public void setFechaSSemestre(Date fechaSSemestre) {
        this.fechaSSemestre = fechaSSemestre;
    }

    public String getDocSSemestre() {
        return docSSemestre;
    }

    public void setDocSSemestre(String docSSemestre) {
        this.docSSemestre = docSSemestre;
    }

    public String getCheckedPagoSs() {
        return checkedPagoSs;
    }

    public void setCheckedPagoSs(String checkedPagoSs) {
        this.checkedPagoSs = checkedPagoSs;
    }

    @Override
    public String toString() {
        return "ControlVehicular [idControlVehicular=" + idControlVehicular + ", fechaPSemestre=" + fechaPSemestre+ ", docPSemestre=" + docPSemestre + ", checkedPagoPs=" + checkedPagoPs + ", fechaSSemestre=" + fechaSSemestre + ", docSSemestre=" + docSSemestre + ", checkedPagoSs=" + checkedPagoSs + "]";
    }
}
