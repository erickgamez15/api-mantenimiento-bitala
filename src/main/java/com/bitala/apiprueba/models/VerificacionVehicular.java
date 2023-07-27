package com.bitala.apiprueba.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Table(name = "verificacion_vehicular")
@EntityListeners(AuditingEntityListener.class)
public class VerificacionVehicular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que sea autoincrementable
    @Column(name = "id_digitoVerificador")
    private Long idDigitoVerificador;

    private String digitos;

    @Column(name = "p_semestre")
    private String pSemestre;

    @Column(name = "s_semestre")
    private String sSemestre;

    private String color;
    private Integer anio;

    public VerificacionVehicular() {

    }

    public VerificacionVehicular(Long idDigitoVerificador, String digitos, String pSemestre, String sSemestre, String color, Integer anio) {
        this.idDigitoVerificador = idDigitoVerificador;
        this.digitos = digitos;
        this.pSemestre = pSemestre;
        this.sSemestre = sSemestre;
        this.color = color;
        this.anio = anio;
    }

    public Long getIdDigitoVerificador() {
        return idDigitoVerificador;
    }

    public void setIdDigitoVerificador(Long idDigitoVerificador) {
        this.idDigitoVerificador = idDigitoVerificador;
    }

    public String getDigitos() {
        return digitos;
    }

    public void setDigitos(String digitos) {
        this.digitos = digitos;
    }

    public String getpSemestre() {
        return pSemestre;
    }

    public void setpSemestre(String pSemestre) {
        this.pSemestre = pSemestre;
    }

    public String getsSemestre() {
        return sSemestre;
    }

    public void setsSemestre(String sSemestre) {
        this.sSemestre = sSemestre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "VerificacionVehicular [idDigitoVerificador=" + idDigitoVerificador + ", digitos=" + digitos + ", pSemestre=" + pSemestre + ", sSemestre=" + sSemestre + ", color=" + color + ", anio=" + anio + "]";
    }
}
