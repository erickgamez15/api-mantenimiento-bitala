package com.bitala.apiprueba.models;

import jakarta.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * API MANTENIMIENTOS - BITALA
 * @AUTHOR ERICK GAMEZ
 * MODEL - VERIFICACIONVEHICULAR
 * 
 * version 1.0
 */

@Entity
//name sigue la nomenclatura de SQL (nombre de la tabla)
@Table(name = "verificacion_vehicular")
@EntityListeners(AuditingEntityListener.class)
public class VerificacionVehicular {

    /* 
    CREATE TABLE `verificacion_vehicular` (
		`id_digito_verificador` int(11) NOT NULL,
		`digitos`varchar(3) NOT NULL,
		`p_semestre` varchar(128) NOT NULL,
		`s_semestre`varchar(128) NOT NULL,
		`color` varchar(10) NOT NULL,
		`anio` varchar(4) NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
    
    //Indica que es la PK de la tabla
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) <-- en la base de datos no es incrementable. Descomentar cuando se modifique eso.
    //name sigue la nomenclatura de SQL
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

    //Contructor para inicializar variables
    public VerificacionVehicular(Long idDigitoVerificador, String digitos, String pSemestre, String sSemestre, String color, String anio) {
        this.idDigitoVerificador = idDigitoVerificador;
        this.digitos = digitos;
        this.pSemestre = pSemestre;
        this.sSemestre = sSemestre;
        this.color = color;
        this.anio = anio;
    }

    //Metodos Get y Set
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

    //Metodo toString
    @Override
    public String toString() {
        return "VerificacionVehicular [idDigitoVerificador=" + idDigitoVerificador + ", digitos=" + digitos + ", pSemestre=" + pSemestre + ", sSemestre=" + sSemestre + ", color=" + color + ", anio=" + anio + "]";
    }
}
