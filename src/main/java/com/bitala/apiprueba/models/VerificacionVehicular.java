package com.bitala.apiprueba.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Table(name = "verificacion_vehicular")
@EntityListeners(AuditingEntityListener.class)
public class VerificacionVehicular {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_digito_verificador")
    private Long idDigitoVerificador;

    @Column(nullable = false)
    private String digitos;

    @Column(name = "p_semestre", nullable = false)
    private String pSemestre;

    @Column(name = "s_semestre", nullable = false)
    private String sSemestre;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String anio;

    public VerificacionVehicular() {

    }

    public VerificacionVehicular(Long idDigitoVerificador, String digitos, String pSemestre, String sSemestre,
            String color, String anio) {
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

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "VerificacionVehicular [idDigitoVerificador=" + idDigitoVerificador + ", digitos=" + digitos + ", pSemestre=" + pSemestre + ", sSemestre=" + sSemestre + ", color=" + color + ", anio=" + anio + "]";
    }
}
